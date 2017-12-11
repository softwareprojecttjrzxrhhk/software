package webCl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodayHIT {
	private String sec_add; //1_27.html
	private String date_time;
	private static String charset = "gb2312";
	TodayHIT(String sec_add) {
		this.sec_add = sec_add;
	}
	private String htmlS(String sec_add) {
		return WebC.httpRequest("http://today.hit.edu.cn/classList/" + sec_add, charset);
	}
	public String saveCtt() {
		String sql = "select * from urlsdb.urls where url = " + "'http://today.hit.edu.cn/classList/" + sec_add + "'";
		Connection conn = SqlCon.con();
		boolean existThis = false;
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);  
			while (rs.next()) {
				existThis = true;
				date_time = rs.getString("cur");
			}
			rs.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if (existThis == false) {
			date_time = "0";
		}
		StringBuffer ctt = new StringBuffer();
		String html = htmlS(sec_add);
        Pattern p = Pattern.compile("class=red>.*?</font></a>]&nbsp;<a href='/news/(.*?)' title='' target='_blank'>(.*?)</a>(.*?)</li");
        Matcher m = p.matcher(html);
        Pattern p_title = Pattern.compile("id=\"maincontenttitle\">(.*?)</div>");
        Matcher m_title = p_title.matcher(html);
        while (m_title.find()) {
        	ctt.append(m_title.group(1) + "<hr>");
        	System.out.println("ssss" + m_title.group(1));
        }
        String max_d = "0";
        int cnt = 0;
        while (m.find()) {
        	String href = m.group(1);
        	String t_tile = m.group(2);
        	String t_time = m.group(3);
        	if (date_time != null && href.compareTo(date_time) <= 0) {
        		continue;
        	}
        	System.out.println(href);
        	System.out.println(date_time);
        	ctt.append( "<a href='http://today.hit.edu.cn/news/" + href + "'>" +  t_tile + "</a><br>");
        	if (max_d.compareTo(href) < 0) {
        		max_d = href;
        	}
        }
        date_time = max_d;
        
        conn = SqlCon.con();
		String svCtt = Main.filterUtf8mb4(ctt.toString());
		Main.textWrite("svC.html", svCtt);
		String svUrl = "http://today.hit.edu.cn/classList/" + sec_add;
		String svCur = date_time;
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
        
        return "su";
	}
}
