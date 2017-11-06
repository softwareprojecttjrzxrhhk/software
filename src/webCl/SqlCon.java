package webCl;

import java.sql.*;

public class SqlCon {//
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String url = "jdbc:mysql://localhost:3306/bookdb?useSSL=true";
	private static String password = "1234";
	//sina 
	//private static String password = "123456";
	//private static String url = "jdbc:mysql://jackerpjhjcl.mysql.sae.sina.com.cn:10624/bookdb";
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
	public static String quer(String sql, int ch) {
		// ch = 1, author; ch = 2, book
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())
				System.out.println("connecting to the database successfully!");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);  
			if (ch == 1) {
				//ansAuthors = new ArrayList();
				while (rs.next()) {
					/*
					Author tmp = new Author(
							rs.getString("AuthorID"),
							rs.getString("Name"),  
							rs.getString("Age"),
							rs.getString("Country"));
					ansAuthors.add(tmp);
					*/
					System.out.print(rs.getString("AuthorID") + 
							rs.getString("Name") + 
							rs.getString("Age") + 
							rs.getString("Country"));
				}
			}
			rs.close(); 
			conn.close(); 
			return "success";
		} catch(ClassNotFoundException e) {  
			System.out.println("sorry, can't find the driver!");  
			//e.printStackTrace();
			return "error";
		}  catch(SQLException e) {
			e.printStackTrace();
			return "error";
		} catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	public static void main(String[] args) {
		quer("select * from bookdb.author", 1);
	}
}