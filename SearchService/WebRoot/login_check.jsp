<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.sql.*"%>


<html>
<head>
</head>

<body>
    <center>
        <h1>登陆操作</h1>
    </center>
    <hr>
    <%!//定义若干个数据库连接常量
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://192.168.116.100:3306/sonar";
    public static final String DBUSER = "sonar";
    public static final String DBPASS = "sonar";
    boolean flag = false;
    String name = null;
 %>
    <%
     Connection conn = null;  //数据库连接
     PreparedStatement pstmt = null;    //数据库预处理操作
     ResultSet rs = null;    //查询要处理结果集
  %>
    <%
 
  try{
  
  %>
    <%
       Class.forName(DBDRIVER);
       conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
      
       String sql = "select * from userinfo where userid = ? and password = ?";
         pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, request.getParameter("id"));
      

       pstmt.setString(2, request.getParameter("password"));

       rs = pstmt.executeQuery();

       if(rs.next()){//如果有数据就执行

           flag = true;//表示登陆成功
           name = rs.getString(1);
           
       }
        System.out.println("如果有数据就执行22");
   %>

    <%
   }catch(Exception e){
       e.printStackTrace();
   }finally{
       try{
           rs.close();
           pstmt.close();
           conn.close();
       }catch(Exception e){
       
       e.printStackTrace();
       }
   
   }
   
    %>

    <%
        if(flag == true){
    %>
    <jsp:forward page="login_success.jsp">
        <jsp:param name="uname" value="<%=name %>" />
    </jsp:forward>

    <%    
        }else{
         %>


    <jsp:forward page="login_failure.jsp"/>


    <%    
         
        }
        
     %>

</body>
</html>