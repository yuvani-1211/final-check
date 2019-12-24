package com.cognizant.moviecruiser.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;




public class DateUtil {
	public static Date convertToDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date d=sdf.parse(date);
		return d;
		
	}
}
