package com.rit.ai.bo;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private Salinity salinitySensor = new Salinity();
	private PH phSensor = new PH();
	private DissolvedOxy dissolvedOxySensor = new DissolvedOxy();
	private Temperature tempSensor = new Temperature();
	private Conductivity conductivity = new Conductivity();
	
	List<Float> timeLastCalibration = new ArrayList<>();
	List<Float> timeLastMaintainence = new ArrayList<>();
	
	
	public List<Float> getTimeLastCalibration() {
		return timeLastCalibration;
	}
	public void setTimeLastCalibration(List<Float> timeLastCalibration) {
		this.timeLastCalibration = timeLastCalibration;
	}
	public List<Float> getTimeLastMaintainence() {
		return timeLastMaintainence;
	}
	public void setTimeLastMaintainence(List<Float> timeLastMaintainence) {
		this.timeLastMaintainence = timeLastMaintainence;
	}
	public Salinity getSalinitySensor() {
		return salinitySensor;
	}
	public void setSalinitySensor(Salinity salinitySensor) {
		this.salinitySensor = salinitySensor;
	}
	public PH getPhSensor() {
		return phSensor;
	}
	public void setPhSensor(PH phSensor) {
		this.phSensor = phSensor;
	}
	public DissolvedOxy getDissolvedOxySensor() {
		return dissolvedOxySensor;
	}
	public void setDissolvedOxySensor(DissolvedOxy dissolvedOxySensor) {
		this.dissolvedOxySensor = dissolvedOxySensor;
	}
	public Temperature getTempSensor() {
		return tempSensor;
	}
	public void setTempSensor(Temperature tempSensor) {
		this.tempSensor = tempSensor;
	}
	public Conductivity getConductivity() {
		return conductivity;
	}
	public void setConductivity(Conductivity conductivity) {
		this.conductivity = conductivity;
	}

}
