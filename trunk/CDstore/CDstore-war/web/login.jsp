<%-- 
    Document   : login
    Created on : Jun 11, 2010, 11:57:12 AM
    Author     : ldc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head><title>Login Page</title></head>

        <h2>Hello, please login:</h2>
        <br><br><form action="j_security_check" method=post>
            <p><strong>Please Enter Your User Name: </strong>
                <input type="text" name="j_username" size="25">
            <p><p><strong>Please Enter Your Password: </strong>
                <input type="password" size="15" name="j_password">
            <p><p>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
        </form>

    </html>
</f:view>
