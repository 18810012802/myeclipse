package com.mql.dao;

public class Wifi {

	public Wifi(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
	   byte[] b="4C696542616f57694669313638".getBytes();
	   System.out.println( Wifi.Bytes2HexString(b));
	   String a="d:/s/s";
	   String[] aa=a.split("/");
			   
	}
    
	public static String Bytes2HexString(byte[] b){
		String ret="";
		for(int i=0;i<b.length;i++){
			String hex=Integer.toHexString(b[i] & 0xFF);
			if(hex.length()==1){
				hex='0'+hex;
				
			}
			ret+=hex.toUpperCase();
		}
		
		return ret;
	}
	

}
