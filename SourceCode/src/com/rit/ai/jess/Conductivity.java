package com.rit.ai.jess;
import jess.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;


 class X{
	
	static boolean check = false;
	
}

public class Conductivity
{
	
	private int rateofchage;
	private int threshold;
	private int confidence;
	

	private int lastCaliberDate;
	private int threshold_LCD;
	private int confidence_LCD;
	
	private int lastMaintDate;
	private int threshold_MD;
	private int confidence_MD;
	
	private int overallQuality;
	
		
	Conductivity(int r, int t, int c)
	{
		rateofchage = r;
		threshold = t;
		confidence = c;
		
		lastCaliberDate = 2;
		threshold_LCD = 1;
		confidence_LCD = 100;
		
		lastCaliberDate = 2;
		threshold_LCD = 1;
		confidence_LCD = 100;
		
		lastMaintDate = 5; 
		threshold_MD  = 3;
		confidence_MD = 100;
		
		overallQuality = 100;
		
		
		
	}
	
 public int getLastMaintDate() {
		return lastMaintDate;
	}

	public void setLastMaintDate(int lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
	}

	public int getThreshold_MD() {
		return threshold_MD;
	}

	public void setThreshold_MD(int threshold_MD) {
		this.threshold_MD = threshold_MD;
	}

	public int getConfidence_MD() {
		return confidence_MD;
	}

	public void setConfidence_MD(int confidence_MD) {
		this.confidence_MD = confidence_MD;
	}

	public int getOverallQuality() {
		return overallQuality;
	}

	public void setOverallQuality(int overallQuality) {
		this.overallQuality = overallQuality;
	}

public int getLastCaliberDate() {
		return lastCaliberDate;
	}

	public void setLastCaliberDate(int lastCaliberDate) {
		this.lastCaliberDate = lastCaliberDate;
	}

	public int getThreshold_LCD() {
		return threshold_LCD;
	}

	public void setThreshold_LCD(int threshold_LCD) {
		this.threshold_LCD = threshold_LCD;
	}

	public int getConfidence_LCD() {
		return confidence_LCD;
	}

	public void setConfidence_LCD(int confidence_LCD) {
		this.confidence_LCD = confidence_LCD;
	}

public int getRateofchage() {
		return rateofchage;
	}

 public void setRateofchage(int rateofchage) {
		this.rateofchage = rateofchage;
	}

public int getThreshold() {
		return threshold;
	}

public void setThreshold(int threshold) {
		this.threshold = threshold;
	}


public int getConfidence() {
		return confidence;
	}

public void setConfidence(int v_confidence) {
	
    int tmp = confidence;
    confidence = v_confidence;
   
   System.out.println(v_confidence );
    
    pcs.firePropertyChange("confidence", new Integer(tmp),
            new Integer(confidence));
    
		
	}


private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

public void addPropertyChangeListener(PropertyChangeListener pcl)
{

//	pcs.addPropertyChangeListener(pcl);
			
}

public void removePropertyChangeListener(PropertyChangeListener pcl)
{
   //pcs.removePropertyChangeListener(pcl);
}




}







