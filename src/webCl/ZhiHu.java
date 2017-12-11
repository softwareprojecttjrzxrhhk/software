package webCl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhiHu {
	public String id;
	private StringBuffer ctt;
	
	
	private String htmlS() {
		return WebC.httpRequest("https://www.zhihu.com/question/" + id + "/answers/created", "utf-8");
	}
	private String getTitle(String html) {
		Pattern p = Pattern.compile("<title data-react-helmet=\"true\">(.*?)</title>");
        Matcher m = p.matcher(html);
        String title = "";
        while (m.find()) {
        	title = m.group(1);
        }
        return title;
	}
	public void calCtt() {
		String html = htmlS();
		String title = getTitle(html);
		Main.textWrite("html.txt", html);
		Pattern p = Pattern.compile("<span class=.*?>(.*?)</span>");
        Matcher m = p.matcher(html);
		while (m.find()) {
			System.out.println(m.group(1));
		}
		System.out.println(title);
	}
	
	public static void main() {
		ZhiHu a = new ZhiHu();
		a.id = "30692237";
		a.calCtt();
		Main.textWrite("tst.txt", a.ctt.toString());
	}
}
