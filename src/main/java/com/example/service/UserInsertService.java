package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserBean;
import com.example.util.ConnectionUtil;

@Service
public class UserInsertService {

	@Autowired
	private ConnectionUtil connectionUtil;

	public void insertUser(UserBean userBean) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = connectionUtil.getConnection();
			stmt = con.createStatement();
			String userId = userBean.getUser_id();
			String userName = userBean.getUser_name();
			String password = userBean.getUser_password();
			
			System.out.println("userId"+userId);
			
			int rs = stmt.executeUpdate("insert into usertable values('"+ userId +"','"+userName+"','"+password+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			connectionUtil.closeConnection();
		}

	}

}
