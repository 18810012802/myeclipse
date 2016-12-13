package com.libo.listener;

import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class MyLoadListener extends DefaultLoadEventListener{
	public void onLoad(LoadEvent event,LoadEventListener.LoadType loadType){
		System.out.println("自定义的load事件");
		System.out.println(event.getEntityClassName()+"====="+event.getEntityId());
		super.onLoad(event, loadType);
	}
}
/*public class MyLoadListener extends DefaultSaveEventListener{
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event){
		System.out.println("自定义的save事件");
		System.out.println(event.getObject());
		return super.performSaveOrUpdate(event);
	}
}*/