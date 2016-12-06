package com.libo.service;

import java.util.List;

import com.libo.po.Classes;
import com.libo.po.Students;


public interface StuService {
	public List<Students> queryAll(Students stu);
	public boolean delete(Students stu);
	public boolean saveOrUpdate(Students stu);
	public List<Classes> queryAllClasses(Classes cla);
}
