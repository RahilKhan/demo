package com.example.demo.utils;

public final class Constants {

    private Constants() {
        throw new IllegalStateException("Constant class will not be instantiate");
    }
    
	public static final String REGEX_DATE_FORMAT_WD_HYPEN_YYYY_MM_DD = "[\\d+-]{3,}\\s\\d+:\\d+";
	public static final String NAME_MULTI_HYPEN_DATE = "PARTY CITY CTR - PREMIUM/SERVEWARE - 2022-08-23 7:23";
	public static final String NAME_SINGLE_HYPEN_DATE = "EXTERIOR PAINT - 2022-05-19 15:28";
}
