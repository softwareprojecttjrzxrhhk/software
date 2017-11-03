package DomainMessage;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;
import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;

public class updateurlAction {
    private String email;
    private String url;
    public ResultSet result5;
    public HttpServletRequest request;
    DB Mysql = new DB();
    ArrayList listName =null;
       
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
    
    public String uphref()
    {
      String sure = null;
      result5 = Mysql.selectupdate(request,email,url);
      sure = myMessage(request,email,url);
      return sure;
    }
    
    public String myMessage(HttpServletRequest request,String mail,String url)
    {
      try{
        
        //HttpSession session =request.getSession();
        listName=new ArrayList();     
        result5=Mysql.selectupdate(request,mail,url);
        if(result5.next())
        {
          result5 = Mysql.selectupdate(request,mail,url);
          while(result5.next()){
            MyMessBean mess = new MyMessBean();
            //mess.setMail(rs.getString("mail"));
            mess.setUrl(result5.getString("url"));
            mess.setTag(result5.getString("tag"));
            mess.setState(result5.getString("state"));
            mess.setRowid(result5.getString("rowid"));
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
    
    public String updateurl()
    {
      String sure = null;
      result5 = Mysql.selectupdate(request,email,url);
      sure = myMessage(request,email,url);
      return sure;
    }
}
