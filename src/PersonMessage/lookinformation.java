package PersonMessage;


import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;
import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;

public class lookinformation extends ActionSupport{
  private String email;
  private String password;
  public HttpServletRequest request;
  public ResultSet result1;
  ArrayList listName =null;
  DB Mysql = new DB();
  public ResultSet result10010;
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String mainhref()
  {
    String Str =null;
    result10010 = Mysql.selectMess(request,email);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  
  public String helphref()
  {
    String Str =null;
    result10010 = Mysql.selectMess(request,email);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  public String getinformation(){
    
    result1 = Mysql.selectMess(request,email);
    String Str = myMessage(request,email);
    return Str;
  }
  
  public String myMessage(HttpServletRequest request,String mail)
  {
    try{
      
      //HttpSession session =request.getSession();
      listName=new ArrayList();     
      result1=Mysql.selectMess(request,mail);
      if(result1.next())
      {
        result1 = Mysql.selectMess(request,mail);
        while(result1.next()){
          MyMessBean mess = new MyMessBean();
          //mess.setMail(rs.getString("mail"));
          mess.setUrl(result1.getString("url"));
          mess.setTag(result1.getString("tag"));
          mess.setState(result1.getString("state"));
          //System.out.println(result1.getString("url"));
          listName.add(mess);
          //session.setAttribute("Message", listName);
        }
      }
      else{
        //session.setAttribute("Message", listName);
      }
      
        
     
      return "success"; 
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }  
  }
  public ArrayList getListName() {
    return listName;
  }
  public void setListName(ArrayList listName) {
    this.listName = listName;
  }
}
