package webCl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiduTieba {
	public String id;
	public int page;
	public StringBuffer ctt;
	public int floor;
	BaiduTieba(String id, String page, String floor) {
		this.id = id;
		this.page = Integer.parseInt(page);
		this.floor = Integer.parseInt(floor);
	}
	BaiduTieba(String id) {
		this.id = id;
	}
	public void saveCtt() {
		String sql = "select * from urlsdb.urls where url = " + "'https://tieba.baidu.com/p/" + id + "'";
		Connection conn = SqlCon.con();
		boolean existThis = false;
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);  
			while (rs.next()) {
				existThis = true;
				String mes = rs.getString("cur");
				String[] spt = mes.split(",");
				page = Integer.parseInt(spt[0]);
				floor = Integer.parseInt(spt[1]);
			}
			rs.close();
			conn.close(); 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if (!existThis) {
			page = 1;
			floor = 1;
		}
		///
		calCtt(page);
		System.out.println(page + " " + floor);
		///
		conn = SqlCon.con();
		String svCtt = Main.filterUtf8mb4(ctt.toString());
		Main.textWrite("wr54.txt", svCtt);
		String svUrl = "https://tieba.baidu.com/p/" + id;
		String svCur = page + "," + floor;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			if (existThis) {
				sql = "UPDATE `urlsdb`.`urls` SET `contt`=?, `cur`=? WHERE `url`=?";
				statement = conn.prepareStatement(sql);
				statement.setString(1, svCtt);
				statement.setString(2, svCur);
				statement.setString(3, svUrl);
			} else {
				sql = "INSERT INTO `urlsdb`.`urls` (`url`, `contt`, `cur`) VALUES (?, ?, ?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, svUrl);
				statement.setString(2, svCtt);
				statement.setString(3, svCur);
			}
			statement.executeUpdate();
			conn.close(); 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public String StrCtt(int page) {
		calCtt(page);
		return ctt.toString();
	}
	public String htmlS(String id, int page) {
		return WebC.httpRequest("https://tieba.baidu.com/p/" + id + "?pn=" + page);
	}
	public void calCtt(int page) {
		//this function will change the floor and page, so it can be called at most once
		System.out.println("calCtt begin");
		String html = htmlS(id, page);
		Main.textWrite("html.txt", html);
		boolean hasBegin = true;
		if (page <= this.page) {
			hasBegin = false;
			ctt = new StringBuffer(); 
		}
        Pattern p = Pattern.compile("<cc>            <div id=.*?>(.*?)</div><br>            </cc>.*<span class=\"tail-info\">(.*?)Â¥</span><span class=\"tail-info\">(.*?)</span>");
        Matcher m = p.matcher(html);
        if (floor == 1) {
        	hasBegin = true;
        }
        while (m.find()) {
        	if (hasBegin) {
        		ctt.append(m.group(1) + "  " + m.group(2) + "  " +  m.group(3) + "<br/>\r\n");
        		this.floor = Integer.parseInt(m.group(2));
        	}
        	if (Integer.parseInt(m.group(2)) == floor) {
        		hasBegin = true;
        	}
        }
        
        Pattern np = Pattern.compile("<a href=\"/p/" + id + "\\?pn=(.*?)\">ÏÂÒ»Ò³</a>");
        m = np.matcher(html);
        if (m.find()) {
        	calCtt(Integer.parseInt(m.group(1)));
        	System.out.println(m.group(1) + "aaaaaaaaaaaaa");
        } else {
        	this.page = page;
        }
        System.out.println("calCtt end");
	}
	public void showUpgr(String id, int page, int floor) {
		this.id = id;
		this.page = page;
		this.floor = floor;
		calCtt(page);
		System.out.println(ctt.toString());
	}
}
