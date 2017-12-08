package DBJavaBean;


import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

//import JavaBean.MyDayBean;

public class DB implements ServletRequestAware{
  private String driverName="com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://127.0.0.1:3306/urlsdb?useSSL=true";//?useUnicode=true&characterEncoding=gbk
  private String user ="root";
  //private String password="tjr19970907";
  private String password = "1234";
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
      String sql1 ="delete from mail where mail='"+userName+"' and url='"+url+"'";
      String sql2 ="delete from mails where mails='"+userName+"' and url='"+url+"'";
      st = getStatement();
      int row1=st.executeUpdate(sql1);
      int row2=st.executeUpdate(sql2);
      sure = "success";    
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
              
  }
  
  public String updateurl1(HttpServletRequest request,String email,String UrlName,String urlcode,String rowid,String oldurl,String state)
  {
    try{
      String sure = null;
        String sql1 ="update mail SET mail='"+email+"', tag='"+UrlName+"', url='"+urlcode+"', rowid='"+rowid+"' where mail='"+email+"' and url='"+oldurl+"'";
        st = getStatement();
        int row1=st.executeUpdate(sql1);
        if(state == null || state.equals("close"))
        {
          
        }
        else
        {
          String sql2 ="update mails SET mail='"+email+"', url='"+urlcode+"', rowid='"+rowid+"' where mail='"+email+"' and url='"+oldurl+"'";
          st = getStatement();
          int row2=st.executeUpdate(sql2);
        }
        /*
        if (!urlcode.equals(oldurl)) {
        	System.out.println("the same");
        	String sql3 = "DELETE FROM `urlsdb`.`mails` WHERE `mails`='" + email + "' and url = '" + oldurl + "'";

        	String sql2 ="update mails SET mail='"+email+"', url='"+urlcode+"', rowid='"+rowid+"' where mail='"+email+"' and url='"+oldurl+"'";
            st = getStatement();
            System.out.println(rowid);
            int row2=st.executeUpdate(sql2);
            st.executeUpdate(sql3);
        }
        */
        sure = "success";
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
  }
              
  }
  public String updateurl(HttpServletRequest request,String email,String urlcode,String state,String tag)
  {
      
    try{
      String sure = null;
      //rs = selecturl(request,email,oldurl);
      //if(rs.next())
      //{
        //已经有一个了
        //sure = "one";
      //}
      //else{
      //String sql = "select state from mail where mail='"+email+"'"+" and url='"+urlcode+"'";
        
//        st = getStatement();
//        int row1=st.executeUpdate(sql);
     String rowid = email+urlcode+tag;   
        if(state.equals("open"))
        {
          System.out.println("2");
          String sql1 ="update mail SET state='close' where mail='"+email+"' and url='"+urlcode+"'";
          st = getStatement();
          int row1=st.executeUpdate(sql1);
          String sql2 ="delete from mails where mails='"+email+"' and url='"+urlcode+"'";
          
          st = getStatement();
          int row2=st.executeUpdate(sql2);
        }
        else
        {
          System.out.println("3");
          String sql1 ="update mail SET state='open' where mail='"+email+"' and url='"+urlcode+"'";
          st = getStatement();
          int row1=st.executeUpdate(sql1);
          String sql2 ="insert into mails"+" (mails,rowid,url)"+" values("+"'"+email+"'"+","+"'"+rowid+"'"+","+"'"+urlcode+"'"+")";
          st = getStatement();
          int row2=st.executeUpdate(sql2);
        }
        
        sure = "success";
      //}
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
      //if(rs.next())
      //{
        //已经有一个了
        //sure = "one";
      //}
      //else{
        String sql1 ="insert into mail"+" (mail,rowid,url,tag,state)"+" values("+"'"+email+"'"+","+"'"+rowid+"'"+","+"'"+url+"'"+","+"'"+tag+"'"+","+"'open'"+")";
        String sql2 ="insert into mails"+" (mails,rowid,url)"+" values("+"'"+email+"'"+","+"'"+rowid+"'"+","+"'"+url+"'"+")";
        st = getStatement();
        System.out.println(rowid);
        int row1=st.executeUpdate(sql1);
        int row2=st.executeUpdate(sql2);
        sure = "success";
      //}
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
  
  public ResultSet selectstate(HttpServletRequest request,String userName,String url)  
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