package com.libo.dao.impl.fan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.libo.dao.fan.Org_EmployeeDao_fan;
import com.libo.entity.Org_employee;
import com.libo.entity.Org_role;





import com.libo.util.BaseDao;

public class Org_EmployeeDaoImpl_fan extends BaseDao implements Org_EmployeeDao_fan {

	
	/**
	 * 按用户名称查询
	 * @param username
	 * @return
	 */

	@Override
	public List<Org_employee> selectOrg() {
		List<Org_employee> list = new ArrayList<Org_employee>();
		Org_employee employee = null;
		try {
			String sql = "SELECT * FROM org_employee,org_role WHERE roleid = org_role.id";
				getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()){
					Org_role orgRole = new Org_role();
					orgRole.setRoleName(rs.getString("roleName"));
					employee = new Org_employee(rs.getInt("id"), rs.getDate("createDate"), rs.getString("loginname"), rs.getString("loginpassword"), rs.getString("username"), rs.getInt("sex"), rs.getString("email"), rs.getString("telphone"), rs.getString("idcaid"), rs.getString("address"), rs.getInt("state"), rs.getInt("roleid"), rs.getString("photo"));
					employee.setOrgrole(orgRole);
					list.add(employee);
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	@Override
	public int getCount(String username) {
		int count =0;
			try {
				String sql = "select count(*) from org_employee";
				if(username!=null){
					sql=sql+" where loginname like ?";
				}
				getConnection();
				pst = conn.prepareStatement(sql);
				if(username!=null){
					pst.setString(1, "%"+username+"%");
				}
				rs = pst.executeQuery();
				if(rs.next()){
					count = rs.getInt("count(*)");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
		
		return count;
	}
	/**
	 * 人员信息分页管理
	 */
	@Override
	public List<Org_employee> getAllByPage(int pageNum, int pageSize,
			String username) {
		List<Org_employee> list=new ArrayList<Org_employee>();
		Org_employee employee=null;
		try {
			String sql = "SELECT * FROM org_employee,org_role WHERE roleid = org_role.id";
			if(username!=null){
				sql=sql+" AND org_employee.loginname LIKE ?";
			}
			sql=sql+" limit ?,?";
			getConnection();
				pst = conn.prepareStatement(sql);
				if(username!=null){
					pst.setString(1, "%"+username+"%");
					pst.setInt(2, (pageNum-1)*pageSize);
					pst.setInt(3, pageSize);
				}
				else{
					pst.setInt(1, (pageNum-1)*pageSize);
					pst.setInt(2, pageSize);
				}
				rs = pst.executeQuery();
				while(rs.next()){
					Org_role orgRole = new Org_role();
					orgRole.setRoleName(rs.getString("roleName"));
					employee = new Org_employee(rs.getInt("id"), rs.getDate("createDate"), rs.getString("loginname"), rs.getString("loginpassword"), rs.getString("username"), rs.getInt("sex"), rs.getString("email"), rs.getString("telphone"), rs.getString("idcaid"), rs.getString("address"), rs.getInt("state"), rs.getInt("roleid"), rs.getString("photo"));
					employee.setOrgrole(orgRole);
					list.add(employee);
				    
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	@Override
	public int deleteOrgEmployee(int id) {
		int count = 0;
		try {
			String sql = "delete from org_employee where id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			count = pst.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return count;
	}

	@Override
	public List<Org_employee> getAllByInput(String input) {
		List<Org_employee> list = new ArrayList<Org_employee>();
		Org_employee employee = null;
		try {
			String sql = "SELECT * FROM org_employee,org_role WHERE roleid = org_role.id ";
			getConnection();
			if(input!=null){
				sql+="AND  org_employee.username LIKE ?";
			}
				pst = conn.prepareStatement(sql);
				if(input!=null){
				pst.setString(1, "%"+input+"%");
				}
				rs = pst.executeQuery();
				while(rs.next()){
					Org_role orgRole = new Org_role();
					orgRole.setRoleName(rs.getString("roleName"));
					employee = new Org_employee(rs.getInt("id"), rs.getDate("createDate"), rs.getString("loginname"), rs.getString("loginpassword"), rs.getString("username"), rs.getInt("sex"), rs.getString("email"), rs.getString("telphone"), rs.getString("idcaid"), rs.getString("address"), rs.getInt("state"), rs.getInt("roleid"), rs.getString("photo"));
					employee.setOrgrole(orgRole);
					list.add(employee);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	@Override
	public int addOrgEmployee(Org_employee orgEmployee) {
		int count = 0;
		try {
			String sql = "INSERT INTO org_employee(createDate,loginname,loginpassword,username,sex,email,telphone,idcaid,address,state,roleid,photo)"+ 
			" VALUES(NOW(),?,?,?,?,?,?,?,?,?,?,?)";
			getConnection();
				pst = conn.prepareStatement(sql);
				pst.setString(1, orgEmployee.getLoginname());
				pst.setString(2, orgEmployee.getLoginpassword());
				pst.setString(3, orgEmployee.getUsername());
				pst.setInt(4, orgEmployee.getSex());
				pst.setString(5, orgEmployee.getEmail());
				pst.setString(6, orgEmployee.getTelphone());
				pst.setString(7, orgEmployee.getIdcaid());
				pst.setString(8, orgEmployee.getAddress());
				pst.setInt(9, orgEmployee.getState());
				pst.setInt(10, orgEmployee.getRoleid());
				pst.setString(11, orgEmployee.getPhoto());
				count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return count;
	}

	@Override
	public Org_employee getOrgEmployeeById(int id) {
		Org_employee orgEmployee  = null;
		try {
			String sql = "SELECT * FROM org_employee,org_role WHERE roleid = org_role.id and org_employee.id=?";
			getConnection();
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if(rs.next()){
					 Org_role orgRole = new Org_role();
					 orgRole.setRoleName(rs.getString("roleName"));
					 orgEmployee = new Org_employee(rs.getInt("id"), rs.getDate("createDate"), rs.getString("loginname"), rs.getString("loginpassword"), rs.getString("username"), rs.getInt("sex"), rs.getString("email"), rs.getString("telphone"), rs.getString("idcaid"), rs.getString("address"), rs.getInt("state"), rs.getInt("roleid"), rs.getString("photo"));
					 orgEmployee.setOrgrole(orgRole);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return orgEmployee;
	}

	

	@Override
	public int updateOrgEmployee(Org_employee orgEmloyee) {
		int count = 0;
		try {
			String sql = "update org_employee set loginname=?,loginpassword=?,username=?,sex=?,email=?,telphone=?,idcaid=?,address=?,state=?,roleid=?,photo=? where id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, orgEmloyee.getLoginname());
			pst.setString(2, orgEmloyee.getLoginpassword());
			pst.setString(3, orgEmloyee.getUsername());
			pst.setInt(4, orgEmloyee.getSex());
			pst.setString(5, orgEmloyee.getEmail());
			pst.setString(6, orgEmloyee.getTelphone());
			pst.setString(7, orgEmloyee.getIdcaid());
			pst.setString(8, orgEmloyee.getAddress());
			pst.setInt(9, orgEmloyee.getState());
			pst.setInt(10, orgEmloyee.getRoleid());
			pst.setString(11, orgEmloyee.getPhoto());
			pst.setInt(12, orgEmloyee.getId());
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}

	@Override
	public int deletesOrgEmployee(int id) {
		int count=0;
		try {
			String sql="UPDATE org_employee SET state=1 WHERE id=?";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}

	@Override
	public Org_employee selectOrgEmployeesByName(String name) {
		Org_employee orge=null;
		try {
		String sql="SELECT * FROM org_employee WHERE loginname=?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			if(rs.next()) {
				orge=new Org_employee();
				orge.setId(rs.getInt("id"));
				orge.setLoginname(rs.getString("loginName"));
				orge.setUsername(rs.getString("username"));
				orge.setRoleid(rs.getInt("roleid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return orge;
	}

	@Override
	public Org_employee seleByid(int id) {
		Org_employee employee=null;
		try {
			getConnection();
			String sql="SELECT * FROM org_employee WHERE id="+id;
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				employee=new Org_employee(rs.getInt("id"), rs.getDate("createDate"), rs.getString("loginname"), rs.getString("loginpassword"), rs.getString("username"), rs.getInt("sex"), rs.getString("email"), rs.getString("telphone"), rs.getString("idcaid"), rs.getString("address"), rs.getInt("state"), rs.getInt("roleid"), rs.getString("photo"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return employee;
	}
	
	
}
