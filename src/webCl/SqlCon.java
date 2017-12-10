package webCl;

import java.sql.*;

public class SqlCon {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	
	private static String url = "jdbc:mysql://localhost:3306/urlsdb?useSSL=true";
	private static String password = "1234";
	
	
	/* 
	 * in principle, these source codes that refer to the url and password to SQL server on sina
	 * should not just be commented but be deleted !!  
	 */
	//sina
	//private static String url = "jdbc:mysql://fmpemtltjykv.mysql.sae.sina.com.cn:10319/urlsdb";
	//private static String password = "123456";
	
	public static Connection con() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())
				System.out.println("connecting to the database successfully!");
			return conn;
		} catch(ClassNotFoundException e) {  
			System.out.println("sorry, can't find the driver!");  
			//e.printStackTrace();
			return null;
		}  catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}