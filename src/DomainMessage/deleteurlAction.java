package DomainMessage;

//
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;
import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;

public class deleteurlAction {
  private String email;
  private String url;
  
  private HttpServletRequest request;
  DB Mysql = new DB();
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String deleteurl()
  {
    //System.out.println(email);
    //System.out.println(url);
    String sure = null;
    DB Mysql = new DB();   
    //System.out.println(UrlName);
    //System.out.println(urlcode);
    //System.out.println(rowid1);
    //System.out.println(email);
    sure = Mysql.deleteurl(request,email,url);
    //sure = "success"; 
    return sure;
  }
}
