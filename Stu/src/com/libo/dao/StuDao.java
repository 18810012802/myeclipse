package com.libo.dao;

import java.util.List;

import com.libo.po.Classes;
import com.libo.po.Students;

public interface StuDao {
	public List<Students> queryAll(Students stu);
	public boolean delete(Students stu);
	public boolean saveOrUpdate(Students stu);
	public List<Classes> queryAllClasses(Classes cla);
}
