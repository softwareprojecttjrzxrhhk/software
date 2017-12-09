package DomainMessage;

import java.sql.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;
import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;
import java.util.Random;
import DomainMessage.randomstring;

public class updateurlAction {
    private String email;
    private String url;
    private String checkbox_toggle;
    private String start_interval;
    public ResultSet result5;
    public HttpServletRequest request;
    DB Mysql = new DB();
    ArrayList listName =null;
    
    private String UrlName;
    private String urlcode;
    private String rowid;
    private String state;
    private String oldurl;
    private String oldstate;
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
            System.out.println(result5.getString("state"));
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
    
    public String upurl()
    {
      String sure = null;
      rowid = email+urlcode+UrlName; 
      //oldstate;
      
      sure = Mysql.updateurl1(request,email,UrlName,urlcode,rowid,oldurl,oldstate);
      
      return sure;
    }
    public String getUrlName() {
      return UrlName;
    }
    public void setUrlName(String urlName) {
      UrlName = urlName;
    }
    public String getUrlcode() {
      return urlcode;
    }
    public void setUrlcode(String urlcode) {
      this.urlcode = urlcode;
    }
    public String getState() {
      return state;
    }
    public void setState(String state) {
      this.state = state;
    }
    public String getOldurl() {
      return oldurl;
    }
    public void setOldurl(String oldurl) {
      this.oldurl = oldurl;
    }
    public String getOldstate() {
      return oldstate;
    }
    public void setOldstate(String oldstate) {
      this.oldstate = oldstate;
    }
    public String getCheckbox_toggle() {
      return checkbox_toggle;
    }
    public void setCheckbox_toggle(String checkbox_toggle) {
      this.checkbox_toggle = checkbox_toggle;
    }
    public String upstate()
    {
      System.out.println("5");
      String sure = null;
      String tag = randomstring.getRandomString(8);
      String abc = null;
      
      //sure = myMessagestate(request,email,url);
      System.out.println(state);
      abc = Mysql.updateurl(request,email,url,state,tag);
      return abc;
    }
    
    public String myMessagestate(HttpServletRequest request,String mail,String url)
    {
      String result = null;
      try{
        
        //HttpSession session =request.getSession();
        listName=new ArrayList();     
        result5=Mysql.selectstate(request,mail,url);
        if(result5.next())
        {
          result5 = Mysql.selectstate(request,mail,url);
          while(result5.next()){
            MyMessBean mess = new MyMessBean();
            //mess.setMail(rs.getString("mail"));
            
            mess.setState(result5.getString("state"));
            //mess.setRowid(result5.getString("rowid"));
            System.out.println(result5.getString("state"));
            result = result5.getString("state");
            listName.add(mess);
            //session.setAttribute("Message", listName);
          }
        }
        else{
          //session.setAttribute("Message", listName);
        }
        
          
       
        return result; 
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }  
    }
    public String getStart_interval() {
      return start_interval;
    }
    public void setStart_interval(String start_interval) {
      this.start_interval = start_interval;
    }
}
