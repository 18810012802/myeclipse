package com.libo.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Da {
	public static Date toDate(String str){
		Date date =null;
		if(str!=null&&str!=""){
		try {
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date tm=sd.parse(str);
			 date=new Date(tm.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		return date;
}
}