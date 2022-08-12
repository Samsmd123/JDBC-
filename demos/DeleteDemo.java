package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/traildb";
		String username="root";
		String password="root";
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		try {
			 connection=DriverManager.getConnection(url, username, password);
			statement=connection.createStatement();
			String sql="delete from policy  where policy_id=10";
			boolean result=statement.execute(sql);
			System.out.println("Row deleted"+result);
		
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
				
				if(statement!=null)
					statement.close();
				
				if(rs!=null)
					rs.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}

	}

}
