<%-- 
    Document   : listcds
    Created on : Jun 8, 2010, 4:35:27 PM
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
            <title>Search for an Artist</title>
        </head>
        <body>
            <h:form id="artistForm">
                <h:outputText value="Insert Artist Name"/>
                <br/>
                <h:inputText id="name" value="#{sBean.artistName}"/>
                <h:commandButton action="#{sBean.findArtists}" value="search" />
                <br/>
                <br/>
                <h2><h:outputLink value="cartContents.jsp"><h:outputText value="Show Cart"/></h:outputLink></h2>
            </h:form>
        </body>
    </html>
</f:view>
