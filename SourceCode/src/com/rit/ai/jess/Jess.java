package com.rit.ai.jess;

import java.util.ArrayList;
import java.util.HashMap;

import jess.*;

public class Jess {
	public static Jess jess;

	public static Jess getJessInstance() {
		if (jess == null) {
			jess = new Jess();
			return jess; 
		}
		return jess;
	}

	private Jess() {

	}

	HashMap<String, Float> sensorHm = new HashMap<>();
	float totalConfidence = 0f;

	public void startJess(ArrayList<PHSpecificaion> phSpecificaionsList,
			ArrayList<ConducSpecification> conductList,
			ArrayList<OxySpecification> oxyList,
			ArrayList<SalSpecification> salList,
			ArrayList<TempSpecification> tempList) {

		Rete rete = new Rete();

		// Read in the rules
		try {
			rete.executeCommand("(batch Rules.clp)");

			rete.executeCommand("(reset)");

			// Tell Jess about them
			for (PHSpecificaion ph : phSpecificaionsList) {

				Funcall f = new Funcall("definstance", rete);
				f.add(new Value("PHSpecificaion", RU.ATOM));
				f.add(new Value(ph));
				f.execute(rete.getGlobalContext());
			}

			
			
			rete.executeCommand("(run)");

			for (PHSpecificaion ph : phSpecificaionsList) {

				System.out.println("ddddddddddd "+ph.getWeightForROC());
			}

			
			for (ConducSpecification cs : conductList) {

				Funcall f = new Funcall("definstance", rete);
				f.add(new Value("ConducSpecification", RU.ATOM));
				f.add(new Value(cs));
				f.execute(rete.getGlobalContext());
			}

			rete.executeCommand("(run)");

			for (OxySpecification ph : oxyList) {

				Funcall f = new Funcall("definstance", rete);
				f.add(new Value("OxySpecification", RU.ATOM));
				f.add(new Value(ph));
				f.execute(rete.getGlobalContext());
			}

			rete.executeCommand("(run)");

			for (SalSpecification ph : salList) {

				Funcall f = new Funcall("definstance", rete);
				f.add(new Value("SalSpecification", RU.ATOM));
				f.add(new Value(ph));
				f.execute(rete.getGlobalContext());
			}

			rete.executeCommand("(run)");

			for (TempSpecification ph : tempList) {

				Funcall f = new Funcall("definstance", rete);
				f.add(new Value("TempSpecification", RU.ATOM));
				f.add(new Value(ph));
				f.execute(rete.getGlobalContext());
			}

			int i = 0;
			for (PHSpecificaion ph : phSpecificaionsList) {
				i++;
				float confidence = ph.getWeightForCAL() + ph.getWeightForMNT()
						+ ph.getWeightForROC();
				confidence /= 3f;
				
				System.out.println("confidence  "+confidence);
				sensorHm.put("PHSpecificaion" + i, confidence);
			}

			i = 0;
			for (ConducSpecification ph : conductList) {
				i++;
				float confidence = ph.getWeightForCAL() + ph.getWeightForMNT()
						+ ph.getWeightForROC();
				confidence /= 3f;
				sensorHm.put("ConducSpecification" + i, confidence);
			}

			i = 0;
			for (OxySpecification ph : oxyList) {
				i++;
				float confidence = ph.getWeightForCAL() + ph.getWeightForMNT()
						+ ph.getWeightForROC();
				confidence /= 3f;
				sensorHm.put("OxySpecification" + i, confidence);
			}

			i = 0;
			for (SalSpecification ph : salList) {
				i++;
				float confidence = ph.getWeightForCAL() + ph.getWeightForMNT()
						+ ph.getWeightForROC();
				confidence /= 3f;
				sensorHm.put("SalSpecification" + i, confidence);
			}

			i = 0;
			for (TempSpecification ph : tempList) {
				i++;
				float confidence = ph.getWeightForCAL() + ph.getWeightForMNT()
						+ ph.getWeightForROC();
				confidence /= 3f;
				sensorHm.put("TempSpecification" + i, confidence);
			}

			i = 0;
			for (SalSpecification ph : salList) {
				i++;
				float confidence = ph.getWeightForCAL() + ph.getWeightForMNT()
						+ ph.getWeightForROC();
				confidence /= 3f;
				sensorHm.put("SalSpecification" + i, confidence);
			}

		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HashMap<String, Float> getSensorHm() {
		return sensorHm;
	}

	public void setSensorHm(HashMap<String, Float> sensorHm) {
		this.sensorHm = sensorHm;
	}

	public float getTotalConfidence() {
		return totalConfidence;
	}

	public void setTotalConfidence(float totalConfidence) {
		this.totalConfidence = totalConfidence;
	}

	
	
	
	
}
