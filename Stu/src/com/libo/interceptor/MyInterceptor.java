package com.libo.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor {
	private int updates;
	private int creates;
	public void onDelete(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types){
		
	}
	public boolean onFlushDirty(Object entity,Serializable id,Object[] currentState,Object[] previousState,String[] propertyNames,Type[] types){
		
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
