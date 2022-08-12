package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreScanDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/traildb";
		String username="root";
		String password="root";
		Connection connection=null;
		Statement statement=null;
		Scanner scanner=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=DriverManager.getConnection(url, username, password);
			String sql="insert into food values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			
		 scanner=new Scanner(System.in);
		for(int i=0;i<4;i++) {
			System.out.print("ENTER food NAME:");
			String name=scanner.next();
			
			System.out.print("ENTER food id:");
			int foodId=scanner.nextInt();
			
			System.out.print("ENTER cost of food:");
			float cost=scanner.nextFloat();
			
			System.out.print("ENTER food type:");
			String type=scanner.next();
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2,foodId);
			preparedStatement.setFloat(3,cost);
			preparedStatement.setString(4,type);
			preparedStatement.execute();
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
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		}
		

	}


