package DBJavaBean;


import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.struts2.interceptor.ServletRequestAware;

import JavaBean.MyMessBean;
import JavaBean.UserNameBean;

//import JavaBean.MyDayBean;

public class DB implements ServletRequestAware{
  private String driverName="com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://127.0.0.1:3306/urlsdb";//?useUnicode=true&characterEncoding=gbk
  private String user ="root";
  private String password="tjr19970907";
  private Connection con = null;
  private Statement st =null;
  private ResultSet rs = null;
  private HttpServletRequest request;
  
  public DB(){
    
  }
  public String getDriverName(){
    return driverName;
  }
  public void setDriverName(String driverName)
  {
    this.driverName = driverName;
  }
  
  public String getUrl()
  {
    return url;
  }
  public void setUrl(String url)
  {
    this.url = url;
  }
  
  public String getUser()
  {
    return user;
  }
  public void setUser(String user)
  {
    this.user = user;
  }
  
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public void setServletRequest(HttpServletRequest hsr)
  {
    request = hsr;
  }
  
  //完成数据库链接，生成容器并返回
  public Statement getStatement()
  {
    try{
      Class.forName(getDriverName());
      con = DriverManager.getConnection(getUrl(),getUser(),getPassword());
      return con.createStatement();
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  public String selectregister(HttpServletRequest request,String userName,String password)
  {
    try{
      String sure = null;
      rs = selectLogin(request,userName,password);
      if(rs.next())
      {
        sure = "error";
      }
      else{
        String sql ="insert into logindb"+" (mail,password)"+" values("+"'"+userName+"'"+","+"'"+password+"'"+")";
        st = getStatement();
        int row=st.executeUpdate(sql);
        sure = "success";
      }
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
              
  }
  
  public String deleteurl(HttpServletRequest request,String userName,String url)
  {
    try{
      String sure = null;
      String sql ="delete from mail where mail='"+userName+"' and url='"+url+"'";
      st = getStatement();
      int row=st.executeUpdate(sql);
      sure = "success";    
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
              
  }
  
  public String inserturl(HttpServletRequest request,String email,String tag,String url,String rowid)
  {
    
    try{
      String sure = null;
      rs = selecturl(request,email,url);
      if(rs.next())
      {
        //已经有一个了
        sure = "one";
      }
      else{
        String sql ="insert into mail"+" (mail,rowid,url,tag,state)"+" values("+"'"+email+"'"+","+"'"+rowid+"'"+","+"'"+url+"'"+","+"'"+tag+"'"+","+"'open'"+")";
        st = getStatement();
        int row=st.executeUpdate(sql);
        sure = "success";
      }
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
              
  }
  
  public ResultSet selecturl(HttpServletRequest request,String userName,String url)  
  {
    try{
      String sql = "select * from mail where mail='"+userName+"'"+" and url='"+url+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public ResultSet selectLogin(HttpServletRequest request,String userName,String password)
  {
    //System.out.println(userName);
    try{
      String sql = "select * from logindb where mail='"+userName+"'"+" and password='"+password+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  public ResultSet selectsearch(HttpServletRequest request,String userName,String tagname)
  {
    //System.out.println(userName);
    try{
      String sql = "select * from mail where mail='"+userName+"'"+" and tag='"+tagname+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public ResultSet selectupdate(HttpServletRequest request,String userName,String url)
  {
    //System.out.println(userName);
    try{
      String sql = "select * from mail where mail='"+userName+"'"+" and url='"+url+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public ResultSet selectLog(HttpServletRequest request,String userName)
  {
    //System.out.println(userName);
    try{
      String sql = "select * from logindb where mail='"+userName+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public ResultSet selectMess(HttpServletRequest request,String mail)
  {
    try{
      String sql = "select * from mail where mail='"+mail+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  
  
 

  
  
}