package com.libo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileLoadUtil {
	public static String DownloadFile(String fromPath,String toPath){
		try {
			FileInputStream fis=new FileInputStream(fromPath);
			FileOutputStream fos=new FileOutputStream(toPath);
			byte[] bbuf=new byte[32];
			int hasRead=0;
			while((hasRead=fis.read(bbuf))>0){
				fos.write(bbuf,0,hasRead);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "下载失败！";
		}
		return "下载成功，路径是："+toPath+"!";
	}
}
