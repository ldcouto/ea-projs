<%-- 
    Document   : addItem
    Created on : Jun 10, 2010, 6:58:35 PM
    Author     : fork
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
            <title>JSP Page</title>
        </head>
        <body>
            <h:form id="artigoForm">
                <h:outputText value="Insert Item Code"/>
                <br/>
                <h:inputText id="codigo" value="#{sBean.itemCode}"/>
                <h:commandButton action="#{sBean.addItemToCart}" value="showCart" />
            </h:form>
        </body>
    </html>
</f:view>
