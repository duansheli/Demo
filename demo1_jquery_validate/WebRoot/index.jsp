<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="" id="userInfo">
  	 <table>
	 <tr>
  		<td>path路径</td>
  		<td>${path}</td>
  	</tr>
	<tr>
  		<td>basePath路径</td>
  		<td>${basePath}</td>
  	</tr>
  	<tr>
  		<td>用户名</td>
  		<td><input type="text" name="username" /></td>
  		<td><label for="username" class="error"></label> </td>
  	</tr>
  	<tr>
  		<td><input type="submit" value="提交" />111</td>
  	</tr>
  	</table>
  	</form>
    This is my JSP page. <br>
    <script type="text/javascript" src="<%=basePath%>/jslib/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/jslib/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=basePath%>/jslib/messages_zh.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
  </body>
</html>