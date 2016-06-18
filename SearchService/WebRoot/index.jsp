<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%!
 public static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
 public static final String userName = "sonar";   
 public static final String userPasswd = "sonar";  
 public static final String dbName = "sonar";  
 public static final String tableName="userinfo"; 
 public static final String DBURL = "jdbc:mysql://192.168.116.100:3306/"+dbName+"?user="+userName+"&password="+userPasswd;
%>

<%
  Connection conn = null ;
  PreparedStatement pstmt = null ;
  ResultSet rs = null ;
  boolean flag = false ; // 
%>

<%
 String userid = request.getParameter("userid") ; 
 String password = request.getParameter("password") ; 
 try{
   Class.forName(DBDRIVER) ;
   conn = DriverManager.getConnection(DBURL) ;
   String sql = "SELECT userid,password FROM userinfo WHERE userid=? AND password=?" ;
   pstmt = conn.prepareStatement(sql) ;
   pstmt.setString(1,userid) ;
   pstmt.setString(2,password) ;
   rs = pstmt.executeQuery() ;
   while(rs.next()){
   
        flag = true ;
  }
 }catch(Exception e){
 }finally{
  try{
   conn.close() ; 
  }catch(Exception e){}
 }
%>
<%
 if(flag){ 
%>
  <jsp:forward page="success.jsp"/>
<%
 }else{  
%> 
  
<%
 }
%>