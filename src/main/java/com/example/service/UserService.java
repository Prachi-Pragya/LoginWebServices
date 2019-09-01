package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.controller.UserController;
import com.example.model.UserBean;
import com.example.util.ConnectionUtil;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Value("${mysql.user}")
	private String mySqlUser;
	
	@Value("${mysql.password}")
	private String mySqlPassword;
	
	@Autowired
	private ConnectionUtil connectionUtil;
	
	public UserBean getUser(String userId, String password)
	{
		LOGGER.info("Database call started");
		Connection con =null;
		Statement stmt = null;
		UserBean user=null;
		try
		{
			con = connectionUtil.getConnection();
			stmt=con.createStatement();
			ResultSet rd = stmt.executeQuery("SELECT * FROM usertable WHERE user_id="+userId);
			
			while(rd.next()) {
				user = new UserBean();
				user.setUser_id(rd.getString("user_id"));
				user.setUser_name(rd.getString("user_name"));
				user.setUser_password(rd.getString("user_password"));
				
			}
			LOGGER.info("Database call end");
       }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			connectionUtil.closeConnection();
		}
		return user;
		
	}

}
