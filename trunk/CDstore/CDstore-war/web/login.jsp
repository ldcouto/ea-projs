<%-- 
    Document   : login
    Created on : Jun 11, 2010, 11:57:12 AM
    Author     : ldc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Login Page</title>
        </head>
        <body>
            <h1><h:outputText value="Please Log In"/></h1>
        <body>
            <h:form id="artistForm">
                <h:outputText value="Username:   "/>
                <h:inputText id="name" value="#{sBean.user}"/>
                <br/>
                <h:outputText value ="Password:    "/>
                <h:inputSecret id = "pass" value="#{sBean.pass}"/>
                <br/>
                <h:commandButton action="#{sBean.findArtists}" value="login" />
            </h:form>

        </body>
    </html>
</f:view>
