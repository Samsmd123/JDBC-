package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreUpdateDemo {

	public static void main(String[] args) {
	
			String url="jdbc:mysql://localhost:3306/traildb";
			String username="root";
			String password="root";
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			
			try {
				connection=DriverManager.getConnection(url, username, password);
				
				String sql="update food set nmae=? where type=?";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1,"idly");
				preparedStatement.setString(2,"Non-veg");
			
				preparedStatement.executeUpdate();
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(connection!=null)
						connection.close();
					
					if(preparedStatement!=null)
						preparedStatement.close();
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			}
	}

}
