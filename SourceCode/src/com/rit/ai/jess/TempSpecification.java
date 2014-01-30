package com.rit.ai.jess;

import java.util.Iterator;
import java.util.List;

import com.rit.ai.bo.Node;
import com.rit.ai.bo.PH;
import com.rit.ai.bo.Temperature;

public class TempSpecification {

	float rateOfChange;
	float timeCalibrationMiliSecond;
	float timeMaintainceMiliSecond;
	
	
	
	private float thresholdForROC;
	private long thresholdForCAL;
	private long thresholdForMNT;
	
	private float WeightForROC = 1;
	private float WeightForCAL = 1 ;
	private float weightForMNT = 1;
	
	private float overAllConfidence = 0;
	
	public float getThresholdForROC() {
		return thresholdForROC;
	}




	public void setThresholdForROC(float thresholdForROC) {
		this.thresholdForROC = thresholdForROC;
	}




	public long getThresholdForCAL() {
		return thresholdForCAL;
	}




	public void setThresholdForCAL(long thresholdForCAL) {
		this.thresholdForCAL = thresholdForCAL;
	}




	public long getThresholdForMNT() {
		return thresholdForMNT;
	}




	public void setThresholdForMNT(long thresholdForMNT) {
		this.thresholdForMNT = thresholdForMNT;
	}




	public float getWeightForROC() {
		return WeightForROC;
	}




	public void setWeightForROC(float weightForROC) {
		WeightForROC = weightForROC;
	}




	public float getWeightForCAL() {
		return WeightForCAL;
	}




	public void setWeightForCAL(float weightForCAL) {
		WeightForCAL = weightForCAL;
	}




	public float getWeightForMNT() {
		return weightForMNT;
	}




	public void setWeightForMNT(float weightForMNT) {
		this.weightForMNT = weightForMNT;
	}




	public float getOverAllConfidence() {
		return overAllConfidence;
	}




	public void setOverAllConfidence(float overAllConfidence) {
		this.overAllConfidence = overAllConfidence;
	}



	
	
	public float getRateOfChange() {
		return rateOfChange;
	}

	public void setRateOfChange(float rateOfChange) {
		this.rateOfChange = rateOfChange;
	}

	public float getTimeCalibrationMiliSecond() {
		return timeCalibrationMiliSecond;
	}

	public void setTimeCalibrationMiliSecond(float timeCalibrationMiliSecond) {
		this.timeCalibrationMiliSecond = timeCalibrationMiliSecond;
	}

	public float getTimeMaintainceMiliSecond() {
		return timeMaintainceMiliSecond;
	}

	public void setTimeMaintainceMiliSecond(float timeMaintainceMiliSecond) {
		this.timeMaintainceMiliSecond = timeMaintainceMiliSecond;
	}


	public void populate(Temperature temperature, Node node) {
		populateRateOfChange(temperature.getValues());
		populateTimeCalibrationMiliSecond(temperature, node);
		populateTimeMaintainceMiliSecond(temperature, node);
	}


	
	private void populateTimeMaintainceMiliSecond(Temperature temperature, Node node) {
		
		List<Float> timeLastMaintainence  = node.getTimeLastMaintainence();
		float avg = 0f;
		for(float value : timeLastMaintainence){
			avg += value;
		}
		avg = avg/(float)timeLastMaintainence.size();
		this.timeMaintainceMiliSecond = avg;
	}


	private void populateTimeCalibrationMiliSecond(Temperature temperature, Node node) {
		List<Float> timeLastCalibration  = node.getTimeLastCalibration();
		float avg = 0f;
		for(float value : timeLastCalibration){
			avg += value;
		}
		avg = avg/(float)timeLastCalibration.size();
		this.timeCalibrationMiliSecond = avg;
		
	}



	private void populateRateOfChange(List<Integer> list) {

		int length = list.size();
		int first = 0;
		float second = 0, i = 0;
		Iterator<Integer> it =list.iterator();
		while(i!=(length/2)){
			i +=1;
			first += it.next();
			
		}
		first /=i;
		while(it.hasNext()){
			second +=it.next();
		}
		second /=i;
		
		float slope = (second - first)/i;
		rateOfChange = slope;
		
	
		
	}
	

}
