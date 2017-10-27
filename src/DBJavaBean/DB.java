package DBJavaBean;
/*
import JavaBean.UserNameBean;
import JavaBean.MyDayBean;
import JavaBean.MyFriBean;
import JavaBean.MyMessBean;
*/
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.struts2.interceptor.ServletRequestAware;

public class DB implements ServletRequestAware{
  private String driverName="com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://localhsot:3306/bookmanagementsystem";//?useUnicode=true&characterEncoding=gbk
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
  
  /*
  public String insertau(HttpServletRequest request,String userName,String authorname,String authornumber,String authorid,String authorage,String country)
  {
    //System.out.println("insert");
    try{
      String sure = null;
      rs = selectauthor(request,userName,authorid);
      if(rs.next())
      {
        sure = "one";
      }
      else{
        String sql ="insert into aythorinformation"+" (AuthorNumber,AuthorName,Authorid,Age,Country)"+" values("+"'"+authornumber+"'"+","+"'"+authorname+"'"+","+"'"+authorid+"'"+","+"'"+authorage+"'"+","+"'"+country+"'"+")";
        st = getStatement();
        int row=st.executeUpdate(sql);
        if(row==1)
        {
          //调用myfriend方法，更新session中书籍信息
          String fri = myDayAuthor1(request,userName);
          if(fri.equals("ok"))
          {
            sure = "ok";
          }
          else
          {
            sure = null;
          }
        }
        else
        {
          sure = null;
        }
      }
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
              
  }
  
  //增加
  //public String insertMess(HttpServletRequest request,String uesrName,String password,String name,String sex)
  public String insertFri(HttpServletRequest request,String userName,String newBookName,String Price,String Date,String authorid,String publisher,String ISBN,String bookNumber)
  {
    //System.out.println("insert");
    try{
      String sure = null;
      rs = selectFri(request,userName,ISBN);
      if(rs.next())
      {
        sure = "one";
      }
      else{
        String sql ="insert into bookinformation"+" (userName,BookName,ISBN,publisher,Date,Price,Authorid,idbookinformation)"+" values("+"'"+userName+"'"+","+"'"+newBookName+"'"+","+"'"+ISBN+"'"+","+"'"+publisher+"'"+","+"'"+Date+"'"+","+"'"+Price+"'"+","+"'"+authorid+"'"+","+"'"+bookNumber+"'"+")";
        st = getStatement();
        int row=st.executeUpdate(sql);
        if(row==1)
        {
          //调用myfriend方法，更新session中书籍信息
          String fri = myFriends(request,userName);
          if(fri.equals("ok"))
          {
            sure = "ok";
          }
          else
          {
            sure = null;
          }
        }
        else
        {
          sure = null;
        }
      }
      return sure;
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
              
  }
  
  
  
  //删除
  public String deleteFri(HttpServletRequest request,String userName,String ISBN)
  {
    try{
      String sure=null;
      String sql = "delete from bookinformation where ISBN='"+ISBN+"'";
      st = getStatement();
      int row = st.executeUpdate(sql);
      if(row==1)
      {
        //调用myfriend方法，更新session中书籍信息
        String fri = myFriends(request,userName);
        if(fri.equals("ok"))
        {
          sure = "ok";
        }
        else
        {
          sure = null;
        }
      }
      else
      {
        sure = null;
      }
    
    return sure;
      
    }catch(Exception e){
      e.printStackTrace();
      return null;
          }
  }
  
  //修改
  public String updateFri(HttpServletRequest request,String userName,String bookName,String Price,String Date,String authorid,String publisher,String ISBN,String bookNumber)
  {
    try{
      String sure = null;
      //先删除信息
      String del = deleteFri(request,userName,ISBN);
      
      if(del.equals("ok")){
        //System.out.println(del+"1");
        String in = insertFri(request,userName,bookName,ISBN,publisher,Date,Price,authorid,bookNumber);
        if(in.equals("ok"))
        {
          //System.out.println(del+"1");
          //调用myfriends方法，更新session
          String fri= myFriends(request,userName);
          if(fri.equals("ok")){
            sure = "ok";
          }else{
            sure = null;
          }
        }
        else
        {
          sure = null;
        }
      }
      else
      {
        sure = null;
      }
      return null;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  //查询按人头
  public ResultSet selectauthor(HttpServletRequest request,String userName,String authorid) 
  {
    try{
      String sql = "select * from aythorinformation where Authorid='"+authorid+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public ResultSet selectauthor444(HttpServletRequest request,String userName,String authorid)  
  {
    try{
      String sql = "select * from bookinformation where Authorid='"+authorid+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  public ResultSet selectauthorID(HttpServletRequest request,String userName,String authorname) 
  {
    try{
      String sql = "select * from aythorinformation where AuthorName='"+authorname+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  public String myFriendssearchID(HttpServletRequest request,String userName,String authorname)
  {
    try{
      ArrayList listName =null;
      HttpSession session =request.getSession();
      listName=new ArrayList();
      rs=selectauthorID(request,userName,authorname);
      
      if(rs.next())
      {
        rs=selectauthorID(request,userName,authorname);
        while(rs.next())
        {
          MyDayBean mess = new MyDayBean();
          
          mess.setauthorid(rs.getString("Authorid"));
          //System.out.println();
          //
          listName.add(mess);
          //listName.add(rs.getString("Authorid"));
          //System.out.println("2");
          session.setAttribute("friendsearchID",listName);
        }
      }
      else
      {
        session.setAttribute("friendsearchID", listName);
      }
      //System.out.println(listName);
      return "ok";
      
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }
    
  }
  
  public ResultSet selectauthor446(HttpServletRequest request,String userName,String authorid,String authorname)  
  {
    try{
      String sql = "select * from bookinformation where Authorid='"+authorid+"'"+" and AuthorName='"+authorname+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  //查询书籍
  public ResultSet selectFri(HttpServletRequest request,String userName,String ISBN)  
  {
    try{
      String sql = "select * from bookinformation where ISBN='"+ISBN+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }

  //获取全部书籍信息
  public ResultSet selectFriAll(HttpServletRequest request,String userName)
  {
    try{
      //String sql="select * from bookinformation where userName = '"+userName+"'";
      String sql="select * from bookinformation ";
      st = getStatement();
      return st.executeQuery(sql);
      
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }
  }
  
  //获取所有信息并保存到session
  public String myFriends(HttpServletRequest request,String userName)
  {
    try{
      ArrayList listName =null;
      HttpSession session =request.getSession();
      listName=new ArrayList();
      rs=selectFriAll(request,userName);
      if(rs.next())
      {
        rs=selectFriAll(request,userName);
        while(rs.next())
        {
          MyFriBean mess = new MyFriBean();
          mess.setNumber(rs.getString("idbookinformation"));
          mess.setName(rs.getString("BookName"));
          mess.setISBN(rs.getString("ISBN"));
          mess.setpublisher(rs.getString("Publisher"));
          mess.setauthor(rs.getString("Authorid"));
          mess.setdate(rs.getString("Date"));
          mess.setprice(rs.getString("Price"));
          //
          listName.add(mess);
          //System.out.println("2");
          session.setAttribute("friends",listName);
        }
      }
      else
      {
        session.setAttribute("friends", listName);
      }
      return "ok";
      
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }
    
  }
  
  public String myFriends345(HttpServletRequest request,String userName)
  {
    try{
      ArrayList listName =null;
      HttpSession session =request.getSession();
      listName=new ArrayList();
      rs=selectFriAll(request,userName);
      if(rs.next())
      {
        rs=selectFriAll(request,userName);
        while(rs.next())
        {
          MyFriBean mess = new MyFriBean();
          mess.setNumber(rs.getString("idbookinformation"));
          mess.setName(rs.getString("BookName"));
          mess.setISBN(rs.getString("ISBN"));
          mess.setpublisher(rs.getString("Publisher"));
          mess.setauthor(rs.getString("Authorid"));
          mess.setdate(rs.getString("Date"));
          mess.setprice(rs.getString("Price"));
          //
          listName.add(mess);
          //System.out.println("2");
          session.setAttribute("friends345",listName);
        }
      }
      else
      {
        session.setAttribute("friends345", listName);
      }
      return "ok";
      
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }
    
  }
  
  //获取所有作者作品并保存到session
    public String myFriendssearch(HttpServletRequest request,String userName,String authorid)
    {
      try{
        ArrayList listName =null;
        HttpSession session =request.getSession();
        listName=new ArrayList();
        rs=selectauthor444(request,userName,authorid);
        if(rs.next())
        {
          rs=selectauthor444(request,userName,authorid);
          while(rs.next())
          {
            MyFriBean mess = new MyFriBean();
            mess.setName(rs.getString("BookName"));
            mess.setISBN(rs.getString("ISBN"));
            mess.setpublisher(rs.getString("Publisher"));
            mess.setauthor(rs.getString("Authorid"));
            mess.setdate(rs.getString("Date"));
            mess.setprice(rs.getString("Price"));
            //
            listName.add(mess);
            //System.out.println("2");
            session.setAttribute("friendsearch",listName);
          }
        }
        else
        {
          session.setAttribute("friendsearch", listName);
        }
        return "ok";
        
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }
      
    }
    
    public String myFriendssearch446(HttpServletRequest request,String userName,String authorid,String authorname)
    {
      try{
        ArrayList listName =null;
        HttpSession session =request.getSession();
        listName=new ArrayList();
        rs=selectauthor446(request,userName,authorid,authorname);
        if(rs.next())
        {
          rs=selectauthor446(request,userName,authorid,authorname);
          while(rs.next())
          {
            MyFriBean mess = new MyFriBean();
            mess.setName(rs.getString("BookName"));
            mess.setISBN(rs.getString("ISBN"));
            mess.setpublisher(rs.getString("Publisher"));
            mess.setauthor(rs.getString("Authorid"));
            mess.setdate(rs.getString("Date"));
            mess.setprice(rs.getString("Price"));
            //
            listName.add(mess);
            //System.out.println("2");
            session.setAttribute("friendsearch446",listName);
          }
        }
        else
        {
          session.setAttribute("friendsearch446", listName);
        }
        return "ok";
        
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }
      
    }
    
    public String myresultsearch(HttpServletRequest request,String userName,String ISBN)
    {
      try{
        ArrayList listName =null;
        HttpSession session =request.getSession();
        listName=new ArrayList();
        rs=selectFri(request,userName,ISBN);
        if(rs.next())
        {
          rs=selectFri(request,userName,ISBN);
          while(rs.next())
          {
            MyFriBean mess = new MyFriBean();
            mess.setNumber(rs.getString("idbookinformation"));
            mess.setName(rs.getString("BookName"));
            mess.setISBN(rs.getString("ISBN"));
            mess.setpublisher(rs.getString("Publisher"));
            mess.setauthor(rs.getString("Authorid"));
            mess.setdate(rs.getString("Date"));
            mess.setprice(rs.getString("Price"));
            //
            listName.add(mess);
            //System.out.println("2");
            session.setAttribute("friends90",listName);
          }
        }
        else
        {
          session.setAttribute("friends90", listName);
        }
        return "ok";
        
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }
      
    }
    
  //查询所有日程信息并保存在session中
  
  
  //查询所有日程信息并保存在session中
    public String myDayAuthor(HttpServletRequest request,String userName,String authorid)
    {
      try{
        ArrayList listName =null;
        HttpSession session =request.getSession();
        listName=new ArrayList();
        //System.out.println("1");
        rs=selectDayAll(request,authorid);
        if(rs.next())
        {
          rs=selectDayAll(request,authorid);
          while(rs.next())
          {
            MyDayBean mess = new MyDayBean();
            mess.setName(rs.getString("AuthorName"));
            mess.setauthorid(rs.getString("Authorid"));
            mess.setauthorage(rs.getString("Age"));
            mess.setcountry(rs.getString("Country"));
            mess.setNumber(rs.getString("AuthorNumber"));
            //
            listName.add(mess);
            session.setAttribute("day",listName);
          }
        }
        else
        {
          session.setAttribute("day", listName);
        }
        return "ok";
        
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }
      
    }
    
    
    public String myDayAuthor1(HttpServletRequest request,String userName)
    {
      try{
        ArrayList listName =null;
        HttpSession session =request.getSession();
        listName=new ArrayList();
        //System.out.println("1");
        rs=selectDayAlltrue(request);
        if(rs.next())
        {
          rs=selectDayAlltrue(request);
          while(rs.next())
          {
            MyDayBean mess = new MyDayBean();
            mess.setName(rs.getString("AuthorName"));
            mess.setauthorid(rs.getString("Authorid"));
            mess.setauthorage(rs.getString("Age"));
            mess.setcountry(rs.getString("Country"));
            mess.setNumber(rs.getString("AuthorNumber"));
            //
            listName.add(mess);
            session.setAttribute("day1",listName);
          }
        }
        else
        {
          session.setAttribute("day1", listName);
        }
        return "ok";
        
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
      }
      
    }
    
    
    public ResultSet selectDayAlltrue(HttpServletRequest request)
    {
      try{
        String sql ="select * from aythorinformation ";
        //System.out.println("2");
        st = getStatement();
        return st.executeQuery(sql);
        
      }catch(Exception e)
      {
        e.printStackTrace();
        return null;
        
      }
    }
  //查询所有日程信息（作者）
  public ResultSet selectDayAll(HttpServletRequest request,String authorid)
  {
    try{
      String sql = "select * from aythorinformation where Authorid='"+authorid+"'";
      //System.out.println("2");
      st = getStatement();
      return st.executeQuery(sql);
      
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
      
    }
  }
  
  //查询登录和密码是否存在
  public ResultSet selectLogin(HttpServletRequest request,String userName,String password)
  {
    try{
      String sql = "select*from loginname where username=' "+userName+"' and password='"+password+"'";
      st = getStatement();
      return st.executeQuery(sql);
      
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
      
    }
  }
  
  //返回登录用户的用户名
  public String returnLogin(HttpServletRequest request)
  {
    String LoginName = null;
    HttpSession session = request.getSession();
    ArrayList login = (ArrayList)session.getAttribute("username");
    if(login == null || login.size() == 0)
    {
      LoginName = null;
    }
    else
    {
      for(int i= login.size()-1;i>=0;i--)
      {
        UserNameBean nm=(UserNameBean)login.get(i);
        LoginName = nm.getUserName();
      }
    }
    return LoginName;
  }
  
  //登陆用户信息保存到session
  public String myLogin(HttpServletRequest request,String userName)
  {
    try{
      ArrayList listName = null;
      HttpSession session = request.getSession();
      listName = new ArrayList();
      rs=selectMess(request,userName);
      if(rs.next())
      {
        rs = selectMess(request,userName);
        while(rs.next())
        {
          UserNameBean mess = new UserNameBean();
          mess.setPassword(rs.getString("password"));
          listName.add(mess);
          session.setAttribute("userName", listName);
          
        }
      }
      else
      {
        session.setAttribute("userName", listName);
      }
      return "ok";
      
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  
  //调用四大方法
  public String addList(HttpServletRequest request,String userName)
  {
    String sure = null;
    String login = myLogin(request,userName);
    String mess = myMessage(request,userName);
    String fri = myFriends(request,userName);
    //String day = myDayTime(request,userName);
    //if(login.equals("ok") && mess.equals("ok") && fri.equals("ok") && day.equals("ok"))
    if(login.equals("ok") || mess.equals("ok") || fri.equals("ok")  )
    {
      sure = "ok";
    }
    else
    {
      sure = null;
    }
    return sure;
    
  }
  
  //查询个人信息并返回结果集rs
  public ResultSet selectMess(HttpServletRequest request,String userName)
  {
    try{
      String sql="select* from loginname where loginname='"+userName+"'";
      st = getStatement();
      return st.executeQuery(sql);
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
      
    }
  }
  
  //个人信息
  public String myMessage(HttpServletRequest request,String userName)
  {
    try{
      ArrayList listName = null;
      HttpSession session = request.getSession();
      listName = new ArrayList();
      rs=selectMess(request,userName);
      while(rs.next())
      {
        rs = selectMess(request,userName);
        while(rs.next())
        {
          MyMessBean mess = new MyMessBean();
          //mess.setName(rs.getString(""));
          //
          listName.add(mess);
          session.setAttribute("MyMess", listName);
          
        }
      }
      
      return "ok";
      
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  
  }
  //查找联系人。将信息保存到session中
  public String findFri(HttpServletRequest request,String userName,String name)
  {
    try{
      ArrayList listName = null;
      HttpSession session = request.getSession();
      listName = new ArrayList();
      rs=selectFri(request,userName,name);
      if(rs.next())
      {
        rs = selectFri(request,userName,name);
        while(rs.next())
        {
          MyFriBean mess = new MyFriBean();
          mess.setName(rs.getString("BookName"));
          mess.setISBN(rs.getString("ISBN"));
          mess.setpublisher(rs.getString("Publisher"));
          mess.setauthor(rs.getString("Author(ID"));
          mess.setdate(rs.getString("Date"));
          mess.setprice(rs.getString("Price"));
          listName.add(mess);
          session.setAttribute("findfriend", listName);
          
        }
      }
      else
      {
        session.setAttribute("findfriend", listName);
      }
      return "ok";
      
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  //从查找的联系人session对象中获取联系人姓名，并返回
  public String returnFri(HttpServletRequest request)
  {
    String FriendName = null;
    HttpSession session =request.getSession();
    ArrayList login =(ArrayList)session.getAttribute("findfriend");
    if(login == null || login.size() == 0)
      FriendName = null;
    else
    {
      for(int i=login.size()-1;i>=0;i--)
      {
        MyFriBean nm =(MyFriBean)login.get(i);
        FriendName = nm.getName();
      }
    }
    return FriendName;
  }
  
  */
}