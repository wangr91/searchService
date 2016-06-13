package com.test.mysql;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class MysqlConnImpl implements MysqlConService{

	@Override
	public void mysqlconn(String sqltext) throws Exception {

		Connection conn;
		String sql;
		String fishname;
		String url="jdbc:mysql://192.168.116.100:3306/dubbo?"+"user=dubbo&password=dubbo&useUnicode=true&characterEncoding=UTF8";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mysql驱动加载成功");
			conn=DriverManager.getConnection(url);
			Statement stmt=conn.createStatement();
			sql=sqltext;
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("鱼的名字");
			while(rs.next()){
				fishname=rs.getString(2);
				System.out.println(fishname);
			}
			
		}
		catch (SQLException e)
		{
			System.out.println("mysql操作错误");
			e.printStackTrace();
		}
		
	
		
	}

	
}
