package com.training.prepared;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreInsertDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/traildb";
		String username="root";
		String password="root";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Statement statement=null;
		try {
			 connection=DriverManager.getConnection(url, username, password);
			String sql="insert into food values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,"Briyani");
			preparedStatement.setInt(2,10);
			preparedStatement.setFloat(3,150);
			preparedStatement.setString(4,"Non-Veg");
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
				
				if(statement!=null)
					statement.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
	}

}
