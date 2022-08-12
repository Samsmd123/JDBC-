package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreResultDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/traildb";
		String username="root";
		String password="root";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		try {
			connection=DriverManager.getConnection(url, username, password);
			String type="Non-veg";
			String sql="select * from food where type=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,"Nonveg");
			rs=preparedStatement.executeQuery();
			while(rs.next()) {
				String name=rs.getString("nmae");
				int foodId=rs.getInt("food_id");
				float cost=rs.getFloat("cost");
				//String type=rs.getString("type");
			
				System.out.println(name+"\t"+foodId+"\t"+type+"\t"+cost);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
				
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(rs!=null)
					rs.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
	}

}
