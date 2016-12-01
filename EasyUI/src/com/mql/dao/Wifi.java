package com.mql.dao;

public class Wifi {

	public Wifi(){
		
	}
	//static final String hex="4C696542616f57694669313638";
	//static final String hex="54502D4C494E4B20313236";
	static final String hex="54502D4C494E4B5F575A";
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
	  // byte[] b="4C696542616f57694669313638".getBytes();
	   //System.out.println( Wifi.Bytes2HexString(b));
		char[] c=new char[hex.length()];
		for(int i=0;i<hex.length();i++){
			c[i]=hex.charAt(i);
		}
	  String result=new String(hexToBytes(c));
	  System.out.println(result);
			   
	}
    
	//public static final char[] kDigits=new char[hex.length()];
	
	public static byte[] hexToBytes(char[] hexs){
		int length=hexs.length/2;
		byte[] raw=new byte[length];
		for(int i=0;i<length;i++){
			int high=Character.digit(hexs[i*2], 16);
			int low=Character.digit(hexs[i*2+1], 16);
			int value=(high<<4)|low;
			if(value>127)
				value-=256;
				raw[i]=(byte)value;
		}
		return raw;
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
