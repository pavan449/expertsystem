package com.rit.ai.utility;
public final class Constants {
	
	public static final float PH = 7.0F;
	
	public static final float SALINITY = 0.05F;
	
	public static final float DISSOLVEDOXYGEN = 8.0F;
	
	public static final int TEMPERATURE_MAX = 21;
	
	public static final int TEMPERATURE_MIN = 18;
	
	public static final float CONDUCTIVITY_MAX = 5F;
	
	public static final float CONDUCTIVITY_MIN = 50F;
	
	private Constants() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
