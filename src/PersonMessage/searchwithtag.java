package PersonMessage;

import DBJavaBean.DB;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;


import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;


public class searchwithtag {
  private String email;
  ArrayList listName =null;
  DB Mysql = new DB();
  private HttpServletRequest request;
  private String tagname;
  public ResultSet result3;
  public ResultSet result2;
  public ResultSet result1;
  public String Str = null;
  
  public String searchhref()
  {
    String Str =null;
    result2 = Mysql.selectMess(request,email);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  public String search(){
    
    result1 = Mysql.selectsearch(request,email,tagname);
    System.out.println(tagname);
    System.out.println(email);
    String Str = myMessage(request,email,tagname);
    return Str;
  }
  
  public String myMessage(HttpServletRequest request,String mail,String tagname)
  {
    if(tagname.length()== 0 || tagname == null)
    {
      //System.out.println(tagname);
      return "notag";
    }
    else{
      try{
        
        //HttpSession session =request.getSession();
        listName=new ArrayList();     
        result1=Mysql.selectsearch(request,mail,tagname);
        if(result1.next())
        {
          result1 = Mysql.selectsearch(request,mail,tagname);
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
          Str = "success";
        }
        else{
          Str = "noresult";
          //session.setAttribute("Message", listName);
        }
        
          
       
        return Str; 
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }  
    }
  }
 
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTagname() {
    return tagname;
  }

  public void setTagname(String tagname) {
    this.tagname = tagname;
  }
  public ArrayList getListName() {
    return listName;
  }
  public void setListName(ArrayList listName) {
    this.listName = listName;
  }
  
  
}
