<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Welcome to the CD Store"/></h1>

            <h2><h:outputLink value="listarts.jsp"><h:outputText value="List Artists"/></h:outputLink></h2>

            <br/>
            <br/>
            <h2><h:outputLink value="cartContents.jsp"><h:outputText value="Show Cart"/></h:outputLink></h2>
        </body>
    </html>
</f:view>
