<%-- 
    Document   : login
    Created on : Oct 1, 2020, 11:31:28 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <header>Login Form</header>
        <div class="container">
            <form action="LoginServlet" method="POST">
            
            <c:set var="dto" value="${requestScope.ERR}"/>
            <input type="text" name="txtUserID" value="" />
            <label>Username</label>
            <c:if test="${not empty dto.errID}">
                <font color="red">${dto.errID}</font>
            </c:if>
            <input type="password" name="txtPassword" value="" />
            <label>Password</label>
            
            <button type="submit" value="Login" />Login
            </form>
        </div>
    </body>
</html>
