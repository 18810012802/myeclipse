package com.libo.interceptor;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor {
	//记录修改次数
	private int updates;
	//记录创建次数
	private int creates;
	//删除实体时
	public void onDelete(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types){
		
	}
	//持久化同步到数据库
	public boolean onFlushDirty(Object entity,Serializable id,Object[] currentState,Object[] previousState,String[] propertyNames,Type[] types){
		updates++;
		for(int i=0;i<propertyNames.length;i++){
			if("lastUpdateTimestamp".equals(propertyNames[i])){
				currentState[i]=new Date();
				return true;
			}
		}
		return false;
	}
	//加载持久化实例时
	public boolean onLoad(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types){
		for(int i=0;i<propertyNames.length;i++){
			if("name".equals(propertyNames[i])){
				System.out.println(state[i]);
				return true;
			}
		}
		return false;
	}
	//保存持久化实例是
	public boolean onSave(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types){
		creates++;
		for(int i=0;i<propertyNames.length;i++){
			if("createTimestamp".equals(propertyNames[i])){
				state[i]=new Date();
				return true;
			}
		}
		return  false;
	}
	//持久化修改同步完成时
	public void postFlush(Iterator entries){
		System.out.println("创建的次数："+creates+",更新的次数："+updates);
	}
	//同步持久化所作修改之前
	public void preFlush(Iterator entries){
		
	}
	//事务提交之前
	public void beforeTransactionCompletion(Transaction ts){
		System.out.println("事务即将结束");
	}
	//事务提交之后
	public void afterTransactionCompletion(Transaction tx){
		System.out.println("事务已经结束");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
