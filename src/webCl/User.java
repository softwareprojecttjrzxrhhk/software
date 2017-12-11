package webCl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	public String addr;
	public StringBuffer ctt;
	User(String addr) {
		this.addr = addr;
		ctt = new StringBuffer();
	}
	public void send() throws Exception {
		MailSend.sendMail(addr, ctt.toString());
	}
	public void addCtt(String url) {
		String sql = "SELECT * FROM urlsdb.urls where url = '" + url + "'";
		Connection conn = SqlCon.con();
		String cttFromSql = "";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				cttFromSql = rs.getString("contt");
			}
			rs.close();
			conn.close(); 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if (cttFromSql.equals("")) {
			cttFromSql = "^there isn't any new message in this url";
		}
		ctt.append(url + "<br/>" + cttFromSql + "\r\n------------end this url------------\r\n");
	}
}
