package com.xadmin.usermanegemnet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.User;

public class UserDao {
	
	private static String jdbcUrl="jdbc:mysql://localhost:3306/userdb?useSSL=false";
	private static String jdbcUsername="root";
	private static String jdbcPassword="Ra2420hul";
	private static String jdbcDriver="com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL=" INSERT INTO user1 " + " (name,emial,country) Values " + " (?,?,?); ";
	
    
	
	private static final String SELECT_USER_BY_ID="select id,name,emial,country from user1 where id=?";
	private static final String SELECT_ALL_USER="select *from user1";
	private static final String DELETE_USERS_SQL="delete from user1 where id=?;";
	private static final String  UPDATE_USERS_SQL="update user1 set name=?,emial=?,country=? where id=?;";
	
	
	public UserDao() {
	}
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(jdbcDriver);
			con=DriverManager.getConnection(jdbcUrl,jdbcUsername , jdbcPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return con;
	}
	// insert user
	public static void insertUser(User user) {
		System.out.println(INSERT_USERS_SQL);
		try(Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_USERS_SQL);){
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmial());
			ps.setString(3, user.getCountry());
			System.out.println(ps);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static User selectUser(int id) {
		
		User user=null;
		try(Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(INSERT_USERS_SQL);) {
			ps.setInt(1, id);
			System.out.println(ps);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String emial=rs.getString("emial");
				String country=rs.getString("country");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return user;
	}
	
	public List<User> selectAllUsers(){
		
		
		List<User> users=new ArrayList<User>();
		try(Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement(SELECT_ALL_USER);) {
				System.out.println(ps);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String emial=rs.getString("emial");
					String country=rs.getString("country");
					
					users.add(new User(id,name,emial,country));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return users;
		
	}
	
	//Update USERS
	public boolean updateUser(User user) {
		boolean  rowUpdated = false;
		try(Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement(UPDATE_USERS_SQL);) {
				System.out.println("Update User : " + ps);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmial());
				ps.setString(3, user.getCountry());
				ps.setInt(4, user.getId());
				
				rowUpdated=ps.executeUpdate() > 0;
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return rowUpdated;
		
	}
	
	public boolean deleteUser(int id) {
		boolean  rowDeleted = false;
		try(Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement(DELETE_USERS_SQL);) {
			ps.setInt(1, id);
			
			rowDeleted=ps.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return rowDeleted;
		
	}
	
	
}
