package LogAction;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;


public class LoginAction extends ActionSupport {
    private String email;   
    private String password;
    private HttpServletRequest request;
    
    DB Mysql = new DB();
    public ResultSet result;
    public String Str;
    
    public String getUserName(){
      return email;
    }
    public void setUserName(String userName)
    {
      this.email = userName;
    }
    public void setServletRequest(HttpServletRequest hsr)
    {
      request = hsr;
    }
    
    public String search(){   
      //System.out.println(email);
      if(email== null || email.length()==0 || password == null ||password.length()==0)
      {
        System.out.println("000");
        
        //return ERROR;
        Str = ERROR;
      }
      else
      {
        try{
          result = Mysql.selectLogin(request,email,password);
          if(result.next())
          {
            Str =SUCCESS;
          }
          else{
            //System.out.println("wrong");
            Str =ERROR;
          }
        }catch(Exception e)
        {
          e.printStackTrace();
        }
      }
      return Str;
    }
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
  
}
