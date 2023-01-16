
package com.um.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.um.model.User;

public class UserDao {
	private static String url="jdbc:mysql://localhost:3306/naved";
	private static String username="root";
	private static String password="1234567";
	private static String insert="insert into user(name,email,city) values(?,?,?)";
	private static String display="select * from user";
	private static String delete="delete from user where id =? ";
	private static String selectUserById="select*from user where id=?";
	private static String updateUser="update user set name=?,email=?,city=? where id=?";
	private static Connection con=null;
	 private static PreparedStatement ps=null;
	 private static Statement s=null;
	 
	 // insert data to 
	 public static void insert(User u)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				ps=con.prepareStatement(insert);
				ps.setString(1,u.getName());
				ps.setString(2,u.getEmail());
				ps.setString(3,u.getCity());
				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					ps.close();
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			 
		}
	 public static ArrayList<User> display(){
		 ArrayList<User> al=new ArrayList<User>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				s=con.createStatement();
				ResultSet rs=s.executeQuery(display);
				while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String city=rs.getString("city");
				User u=new User(id, name, email, city);
				al.add(u);
				
				
				
				}
				}
			 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					s.close();
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			 
		
		return al;
		 
	 }
	 
	 // delete the user 
	 public  static void delete(int id) {
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				ps=con.prepareStatement(delete);
				ps.setInt(1,id);
				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					ps.close();
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		 
	 }
	 //select user by id 
	 public static User selectUserById(int id1) {
		 User u=null;
		 try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				ps=con.prepareStatement(selectUserById);
				ps.setInt(1,id1);
				ResultSet rs=ps.executeQuery();
				rs.next();
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String city=rs.getString("city");
			 u=new User(id,name,email,city);


				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(ps!=null)
					ps.close();
					if(con!=null)
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return u;
		 
		 
	 }
	 
	// updating user 
	 public static void updateUser(User u) {
		 try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				ps=con.prepareStatement(updateUser);
					ps.setString(1,u.getName());
					ps.setString(2,u.getEmail());
					ps.setString(3,u.getCity());
					ps.setInt(4,u.getId());
					ps.executeUpdate();
					
					

				

				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(ps!=null)
					ps.close();
					if(con!=null)
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
	 }

}
