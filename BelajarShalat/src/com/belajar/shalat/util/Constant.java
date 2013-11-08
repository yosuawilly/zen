package com.belajar.shalat.util;

public class Constant {
	
	public static final String SUBUH = "subuh";
	public static final String DZUHUR = "dzuhur";
	public static final String ASHAR = "ashar";
	public static final String MAGHRIB = "maghrib";
	public static final String ISYA = "isya";
	
	public static final String STEP = "step";
	public static final String NIAT = "niat";
	public static final String QUNUT = "qunut";
	
	public static final String FATIHAH = "fatihah";
	public static final String FALAQ = "falaq";
	public static final String NAS = "nas";
	public static final String IKHLAS = "ikhlas";
	
	public static final String getTitle(String typeShalat){
		if(typeShalat.equals(SUBUH)){
			return "Shalat Subuh";
		}else if(typeShalat.equals(DZUHUR)){
			return "Shalat Dzuhur";
		}else if(typeShalat.equals(ASHAR)){
			return "Shalat Ashar";
		}else if(typeShalat.equals(MAGHRIB)){
			return "Shalat Maghrib";
		}else if(typeShalat.equals(ISYA)){
			return "Shalat Isya";
		}
		return "";
	}
	
	public static final String BASE_PATH = "android.resource://com.belajar.shalat/raw/";

}
