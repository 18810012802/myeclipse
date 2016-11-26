package com.libo.dao.impl.yetong;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.yetong.OrgEmployeeSearchDao;
import com.libo.entity.Employee;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class OrgEmployeeSearchDaoImpl extends BaseDao implements
		OrgEmployeeSearchDao {

	List<Org_employee> oeList = new ArrayList<Org_employee>();
	Org_employee oe = null;

	@Override
	public Org_employee showInfo(int id) {
		oe = new Org_employee();
		getConnection();
		String sql = "select * from org_employee where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				oe.setId(rs.getInt("id"));
				oe.setLoginname(rs.getString("loginName"));
				oe.setUsername(rs.getString("userName"));
				oe.setEmail(rs.getString("email"));
				oe.setIdcaid(rs.getString("idcaid"));
				oe.setTelphone(rs.getString("telphone"));
				oe.setSex(rs.getInt("sex"));
				oe.setPhoto(rs.getString("photo"));
				oe.setRoleid(rs.getInt("roleId"));
				oe.setState(rs.getInt("state"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return oe;
	}

	@Override
	public int modifyPwd(int id, String pwdold, String pwdnew) {
		int rows = 0;
		try {
			getConnection();
			String sql = "UPDATE org_employee SET loginpassword=? WHERE id=? AND loginpassword=?;";
			pst = conn.prepareStatement(sql);
			pst.setString(1, pwdnew);
			pst.setInt(2, id);
			pst.setString(3, pwdold);
			rows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

	public List<Employee> selectemp() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM org_employee";
			getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getDate(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getString(13));
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

}
