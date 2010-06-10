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
            <title>Add Item to shopping cart</title>
        </head>
        <body>
           <h:form id="artistForm">
           <h:outputText value="Insert Artist Name"/>
           <br/>
           <h:inputText id="name" value="#{sBean.artistName}"/>
           <h:commandButton action="#{sBean.findArtists}" value="search" />
     </h:form>
     </body>
    </html>
</f:view>
