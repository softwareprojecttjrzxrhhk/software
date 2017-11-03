package LogAction;

import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;
import DBJavaBean.DB;

public class registerAction {
    private String email;
    private String password;
    private HttpServletRequest request;
    
    public String Str;
    public ResultSet result;
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
    
    
    public String register()
    {
      String sure = null;
      DB Mysql = new DB();     
      sure = Mysql.selectregister(request,email,password);
      //sure = "success"; 
      return sure;
    }
}
   
