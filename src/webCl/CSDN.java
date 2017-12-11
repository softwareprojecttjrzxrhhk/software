package webCl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSDN {
  public String id;
  public int page;
  public StringBuffer ctt;
  public int floor;
  CSDN(String id, String page, String floor) {
    this.id = id;
    this.page = Integer.parseInt(page);
    this.floor = Integer.parseInt(floor);
  }
  CSDN(String id) {
    this.id = id;
  }
  
  public String CSDN_getTitle() {
		String str = "Title:<br/>";
		String html = htmlS(id, 1);
		Pattern p = Pattern.compile("<title>(.*?)</title>");
      Matcher m = p.matcher(html);
      if (m.find()) {
      	str += m.group(1);
      }
		return str + "<br/>";
	}
  
  public void saveCtt() {
    String sql = "select * from urlsdb.urls where url = " + "'http://bbs.csdn.net/topics/" + id + "'";
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
    String title = CSDN_getTitle();
    String svCtt = Main.filterUtf8mb4(title + ctt.toString());
    //Main.textWrite("wr54.txt", svCtt);
    String svUrl = "http://bbs.csdn.net/topics/" + id;
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
    return WebC.httpRequest("http://bbs.csdn.net/topics/" + id + "?page=" + page, "utf-8");
  }
  public void calCtt(int page) {
    //this function will change the floor and page, so it can be called at most once
    System.out.println("calCtt begin floor =" + floor);
    String html = htmlS(id, page);
    boolean hasBegin = true;
    if (page <= this.page) {
      hasBegin = false;
      ctt = new StringBuffer(); 
    }
        Pattern p = Pattern.compile("<td valign=\"top\" class=\"post_info \" data-username=.*? data-floor=\"(.*?)\">\r\n" + 
        		"        \r\n" + 
        		"        <div class=\"post_body\">\r\n" + 
        		"\r\n" + 
        		"                  (.*?)\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"        </div>\r\n" + 
        		"\r\n" + 
        		"      </td>\r\n" + 
        		"    </tr>\r\n" + 
        		"    <tr>\r\n" + 
        		"      <td valign=\"bottom\">\r\n" + 
        		"          \r\n" + 
        		"<div class=\"control\">\r\n" + 
        		"\r\n" + 
        		"  <span class=\"time\">\r\n" + 
        		"              回复于：\r\n" + 
        		"    (.*?)\r\n" + 
        		"  </span>");//题主问题为空层
        Matcher m = p.matcher(html);//原 ：内容 楼书 时间
        Main.textWrite("html"+page+".txt", html);
        if (floor == 1) {
          hasBegin = true;
        }
        while (m.find()) {
        	System.out.println("find");
          if (hasBegin) {
        	  System.out.println("hasbegin");
        	  ctt.append("<hr>" + m.group(2) + "<br/>--              ---  " + m.group(1) + "楼  " +  m.group(3) + "   ---<br/>\r\n");
           // System.out.println(m.group(1)); // floor
           // System.out.println(m.group(2)); // ctt
           // System.out.println(m.group(3)); // time
            this.floor = Integer.parseInt(m.group(1));
          }
          if (Integer.parseInt(m.group(1)) == floor) {
            hasBegin = true;
          }
        }
        
        Pattern np = Pattern.compile("<a href=\"/topics/" + id + "\\?page=(.*?)\" class=\"next\">下一页</a>");
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
