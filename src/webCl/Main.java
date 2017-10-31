package webCl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void textWrite(final String fileName, final String cont) {
		try {
			File fileText = new File(fileName);
			FileWriter fwr = new FileWriter(fileText);
			fwr.write(cont);
			fwr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String filterUtf8mb4(String str) {
        final int LAST_BMP = 0xFFFF;
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            if (codePoint < LAST_BMP) {
                sb.appendCodePoint(codePoint);
            } else {
                i++;
            }
        }
        return sb.toString();
    }
	public static void saveCtt(String url) {
		String doUrl;
		if (url.substring(0, 7).equals("http://")) {
			doUrl = url.substring(7);
		} else if (url.substring(0, 8).equals("https://")) {
			doUrl = url.substring(8);
		} else {
			doUrl = url;
		}
		String[] ana = doUrl.split("/");
		System.out.println(ana.length);
		if (ana[0].equals("tieba.baidu.com")) {
			System.out.println(ana[1]);
			BaiduTieba aaa = new BaiduTieba(ana[2]);
			aaa.saveCtt();
		}
		
	}
	public static void crawlWeb() {
		String sql = "select * from urlsdb.mails order by url";
		Connection conn = SqlCon.con();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);  
			String lastUrl = "xx";
			String url;
			while (rs.next()) {
				url = rs.getString("url");
				if (!url.equals(lastUrl)) {
					saveCtt(url);
					lastUrl = url;
				}
			}
			rs.close(); 
			conn.close(); 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void sendMail() {
		String sql = "select * from urlsdb.mails order by mail";
		Connection conn = SqlCon.con();
		User curSendUser = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);  
			String lastMail = "hh996896116@163.com";
			String mail;
			while (rs.next()) {
				mail = rs.getString("mail");
				if (!mail.equals(lastMail)) {
					if (curSendUser != null) {
						curSendUser.send();
					}
					curSendUser = new User(mail);
					lastMail = mail;
				}
				curSendUser.addCtt(rs.getString("url"));
			}
			if (curSendUser != null) {
				curSendUser.send();
			}
			rs.close(); 
			conn.close(); 
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void myGo() {
		crawlWeb();
		sendMail();
	}
	public static void main(String[] args) {
	  Timer time=new Timer();
	  
		//myGo();
		time.scheduleAtFixedRate(new Task(), 0, 5000);

		System.out.println("main finish");
	}
}
class Task extends TimerTask {

  @Override
  public void run() {
    //System.out.println("dddd");
    Main.myGo();


  }

}
