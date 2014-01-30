package com.rit.ai.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import com.rit.ai.bo.Conductivity;
import com.rit.ai.bo.DissolvedOxy;
import com.rit.ai.bo.Node;
import com.rit.ai.bo.PH;
import com.rit.ai.bo.Salinity;
import com.rit.ai.bo.Temperature;
import com.rit.ai.jess.ConducSpecification;
import com.rit.ai.jess.Jess;
import com.rit.ai.jess.OxySpecification;
import com.rit.ai.jess.PHSpecificaion;
import com.rit.ai.jess.SalSpecification;
import com.rit.ai.jess.TempSpecification;
import com.rit.ai.ui.VisitLogsUtil;
import com.rit.ai.utility.Constants;
import com.rit.ai.utility.Parser;

public class Demo {

	private int phError=0;
	private int tempError=0;
	private int conductError=0;
	private int salinityError=0;
	private int oxygonError=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Demo demo = new Demo();
		Parser parser = new Parser();
		ArrayList<Node> nodeList = parser.parseFile("dataset1.txt");
		
		demo.checkRules(nodeList);
		demo.populateJessValues(nodeList);
		
	}
	
	
public void populateJessValues(ArrayList<Node> nodeList) {
	
	PHSpecificaion phs = new PHSpecificaion();
	ConducSpecification conds = new ConducSpecification();
	OxySpecification oxs = new OxySpecification();
	SalSpecification sals = new SalSpecification();
	TempSpecification temps = new TempSpecification();
	
	ArrayList<PHSpecificaion> phList = new ArrayList<>();
	ArrayList<ConducSpecification> conductList = new ArrayList<>();
	ArrayList<OxySpecification> oxyList = new ArrayList<>();
	ArrayList<SalSpecification> salList = new ArrayList<>();
	ArrayList<TempSpecification> tempList = new ArrayList<>();
	
	java.util.Iterator<Node> itNode = nodeList.iterator();
	
	while(itNode.hasNext()){
		
		Node node = itNode.next();
		
		phs.populate(node.getPhSensor(), node);
		phList.add(phs);
		
		conds.populate(node.getConductivity(), node);
		conductList.add(conds);
		
		oxs.populate(node.getDissolvedOxySensor(), node);
		oxyList.add(oxs);
		
		sals.populate(node.getSalinitySensor(), node);
		salList.add(sals);
		
		temps.populate(node.getTempSensor(), node);
		tempList.add(temps);
		
		
	}
	Jess jess = Jess.getJessInstance();
	jess.startJess(phList, conductList, oxyList, salList, tempList); //////////////////////////////
	System.out.println();
}
HashMap<String, Integer> hmPieData = new HashMap<>();
static int i=0;
	public void checkRules(ArrayList<Node> nodeList) {
		java.util.Iterator<Node> it = nodeList.iterator();
		int i=0;
		while(it.hasNext()){
			Node node = it.next();
			PH phSensor = node.getPhSensor();
			Conductivity conductivitySensor = node.getConductivity();
			Salinity salinitySensor = node.getSalinitySensor();
			Temperature temperatureSensor = node.getTempSensor();
			DissolvedOxy oxygonSensor = node.getDissolvedOxySensor();
			
			checkPhSensor(phSensor);
			checkSalinitySensor(salinitySensor);
			checkConductivitySensor(conductivitySensor);
			checkTemperatureSensor(temperatureSensor);
			checkOxygonSensor(oxygonSensor) ;
			i++;
			hmPieData.put("phsensor"+i, phError);
			hmPieData.put("conductivitysensor"+i, conductError);
			hmPieData.put("temperaturesensor"+i, tempError);
			hmPieData.put("salinitysensor"+i, salinityError);
			hmPieData.put("oxygonsensor"+i, oxygonError);
			phError = 0;
			conductError= 0;
			tempError= 0;
			salinityError= 0;
			oxygonError= 0;
			
		}
		System.out.println("Finalll   "+phError +"   "+salinityError +"   "+conductError +" Oxy "+oxygonError +" tmp "+tempError);
		VisitLogsUtil.locationGraphData = hmPieData;
	}

	private  void checkOxygonSensor(DissolvedOxy oxygonSensor) {
		

		Iterator<Float> it = oxygonSensor.getValues().iterator();
		int recordNumber = 5;
		float average = 0f;
		
		float countForAvg = 5f;
		while((it.hasNext()) && recordNumber>0){  //Get avg for first five records
			average += it.next();
			recordNumber--;
		}
		average /= 5f;
		recordNumber = 0;
		while(it.hasNext()){
			System.out.println("record  "+i++);
			recordNumber++;
			float oxyValue = it.next();
			if( oxyValue != Constants.DISSOLVEDOXYGEN ){

				if( ((oxyValue) <(average-2)) || ((oxyValue) > (average+2)) ) {
				oxygonError++; // if condition fails i.e. the value is outlier
				}else{					
					average = (average*countForAvg + oxyValue)/(++countForAvg);
				}
				
			}
		}
	
	}


	private  void checkTemperatureSensor(Temperature temperatureSensor) {
		
		Iterator<Integer> it = temperatureSensor.getValues().iterator();
		int recordNumber = 5;
		float average = 0f;
		
		float countForAvg = 5f;
		while((it.hasNext()) && recordNumber>0){  //Get avg for first five records
 			average += it.next();
			recordNumber--;
		}
		average /= 5f;
		recordNumber = 0;
		while(it.hasNext()){
			System.out.println("record  "+i++);
			recordNumber++;
			float tempValue = it.next();
			if( (tempValue > Constants.TEMPERATURE_MAX) || (tempValue < Constants.TEMPERATURE_MIN) ){

				if( ((tempValue) <(average-2)) || ((tempValue) > (average+2)) ) {
					tempError++; // if condition fails i.e. the value is outlier
				}else{
					
						average = (average*countForAvg + tempValue)/(++countForAvg);
				}
				
			}
		}
		
	
		
	}


	private void checkConductivitySensor(Conductivity conductivitySensor) {
		

		java.util.Iterator<Float> it = conductivitySensor.getValues().iterator();
		int recordNumber = 5;
		float average = 0f;
		
		float countForAvg = 5f;
		while((it.hasNext()) && recordNumber>0){  //Get avg for first five records
			average += it.next();
			recordNumber--;
		}
		average /= 5f;
		recordNumber = 0;
		while(it.hasNext()){
			System.out.println("record  "+i++);
			recordNumber++;
			float conducValue = it.next();
			if( (conducValue > Constants.CONDUCTIVITY_MAX) || (conducValue < Constants.CONDUCTIVITY_MIN)){

				if( ((conducValue) <(average-2)) || ((conducValue) > (average+2)) ) {
					conductError++; // if condition fails i.e. the value is outlier
				}else{
					
					average = (average*countForAvg + conducValue)/(++countForAvg);
				}
				
			}
		}
		
	
	
	}



	private void checkPhSensor(PH phSensor) {
		java.util.Iterator<Float> it = phSensor.getValues().iterator();
		int recordNumber = 5;
		float average = 0f;
		
		float countForAvg = 5f;
		while((it.hasNext()) && recordNumber>0){  //Get avg for first five records
			average += it.next();
			recordNumber--;
		}
		average /= 5f;
		recordNumber = 0;
		while(it.hasNext()){
			System.out.println("record  "+i++);
			recordNumber++;
			float phValue = it.next();
			if(phValue != Constants.PH){

				if( ((phValue) <(average-2)) || ((phValue) > (average+2)) ) {
					phError++; // if condition fails i.e. the value is outlier
				}else{
					
					average = (average*countForAvg + phValue)/(++countForAvg);
				}
				
			}
		}
		
	}


	
	private void checkSalinitySensor(Salinity salinitySensor) {
		
		

		java.util.Iterator<Float> it = salinitySensor.getValues().iterator();
		int recordNumber = 5;
		float average = 0f;
		
		
		float countForAvg = 5f;
		while((it.hasNext()) && recordNumber>0){  //Get avg for first five records
			average += it.next();
			recordNumber--;
		}
		average /= 5f;
		recordNumber = 0;
		while(it.hasNext()){
			System.out.println("record  "+i++);
			recordNumber++;
			float salValue = it.next();
			if(salValue != Constants.SALINITY){
		
				
				if( ((salValue) <(average-0.02)) || ((salValue) > (average+0.02)) ) {
					salinityError++; // if condition fails i.e. the value is outlier
				}else{
					
					average = (average*countForAvg + salValue)/(++countForAvg);
				}
				
			}
		}
		
	
		
	}

}
