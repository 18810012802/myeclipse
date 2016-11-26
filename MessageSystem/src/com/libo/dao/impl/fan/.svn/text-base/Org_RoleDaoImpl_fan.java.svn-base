package com.libo.dao.impl.fan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.fan.Org_RoleDao_fan;
import com.libo.entity.Org_employee;
import com.libo.entity.Org_role;


import com.libo.util.BaseDao;

public class Org_RoleDaoImpl_fan extends BaseDao implements Org_RoleDao_fan {

	@Override
	public List<Org_role> getAll() {
			List<Org_role> list = new ArrayList<Org_role>();
			Org_role orgRole = null;
			try {
				String sql = "select * from org_role where state=1";
				getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()){
					orgRole = new Org_role(rs.getInt("id"), rs.getInt("org_id"), rs.getDate("createDate"), rs.getString("roleName"), rs.getInt("state"));
					list.add(orgRole);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				close();
			}
	
		return list;
	}

	@Override
	public List<Org_role> getRoleByRoName(String roleName) {
		List<Org_role> list = new ArrayList<Org_role>();
		Org_role orgRole = null;
		try{
		String sql = "select * from org_role";
		getConnection();
		if(roleName!=null){
		 sql+=" where roleName like ? ";
		}
		
			pst = conn.prepareStatement(sql);
			if(roleName!=null){
			pst.setString(1, "%"+roleName+"%");
			}
			rs = pst.executeQuery();
			while(rs.next()){
				orgRole = new Org_role(rs.getInt("id"), rs.getInt("org_id"), rs.getDate("createDate"), rs.getString("roleName"), rs.getInt("state"));
				list.add(orgRole);
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
	public int deleteByid(int id) {
		int count = 0;
		
		try {
		String sql = "delete from org_role where id=? ";
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
	public int addRole(Org_role role) {
		int id =0;
		try {
		String sql = "insert into org_role(org_id,createDate,roleName,state) values(?,now(),?,?)";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, role.getId());
			pst.setString(2, role.getRoleName());
			pst.setInt(3, role.getState());
			pst.executeUpdate();
			String sqls = "SELECT DISTINCT LAST_INSERT_ID() FROM org_role";
			pst = conn.prepareStatement(sqls);
			rs = pst.executeQuery();
			if(rs.next()){
				id=rs.getInt("LAST_INSERT_ID()");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return id;
	}

	@Override
	public int addPerm(int menuId, int roleId) {
		int count = 0 ;
		try {
		String sql = "insert into org_rolemenumember(menuId,roleId) values(?,?)";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, menuId);
			pst.setInt(2, roleId);
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
	public Org_role getRoleByid(int id) {
		Org_role orgRole =null;
		try {
		String sql = "select * from org_role where id=?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				orgRole = new Org_role(rs.getInt("id"), rs.getInt("org_id"), rs.getDate("createDate"), rs.getString("roleName"), rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orgRole;
	}

	@Override
	public int deletePerm(int id) {
		int count = 0;
		try {
		String sql = "delete from org_rolemenumember where roleId=?";
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
	public int updateRole(Org_role orgRole) {
		int count = 0;
		try {
		String sql = "update org_role set roleName=?,state=? where id=?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, orgRole.getRoleName());
			pst.setInt(2, orgRole.getState());
			pst.setInt(3, orgRole.getId());
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return count ;
	}

	@Override
	public int updateOrgEmployee(Org_employee orgEmloyee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(String rolename) {
		int count =0;
		try {
		String sql = "select count(*) from org_role";
                if(rolename!=null){
			sql=sql+" where roleName like ?";
		}
            getConnection();
			pst = conn.prepareStatement(sql);
			if(rolename!=null){
				pst.setString(1, "%"+rolename+"%");
			}
			rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}


	@Override
	public List<Org_role> getAllByPage(int pageNum, int pageSize,
			String rolename) {
		List<Org_role> list = new ArrayList<Org_role>();
		Org_role orgRole = null;
		try {
	     String sql = "select * from org_role";
	    if(rolename!=null){
	    	sql=sql+" where roleName like ? ";
	    }
	    sql=sql+" limit ?,?";
	    getConnection();
			pst = conn.prepareStatement(sql);
			if(rolename!=null){
				pst.setString(1, "%"+rolename+"%");
				pst.setInt(2, (pageNum-1)*pageSize);
				pst.setInt(3, pageSize);
			}
			else{
				pst.setInt(1, (pageNum-1)*pageSize);
				pst.setInt(2, pageSize);
			}
			rs = pst.executeQuery();
			while(rs.next()){
				orgRole = new Org_role(rs.getInt("id"), rs.getInt("org_id"), rs.getDate("createDate"), rs.getString("roleName"), rs.getInt("state"));
				list.add(orgRole);
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
	public int updateOrgRoleById(int id) {
		int count = 0;
		try {
		String sql = "update org_role set state=1 where id=?";
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
		return count ;
	}
	
}