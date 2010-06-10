<%-- 
    Document   : cartContents
    Created on : Jun 10, 2010, 7:21:29 PM
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
            <h:dataTable id="ttid" value="#{sBean.cartContents}" var="items">
                <h:column>
                    <f:facet name="header"><h:outputText value="Item" /></f:facet>
                    <h:outputText value="#{items.nome}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Código" /></f:facet>
                    <h:outputText value="#{items.codigo}" />
                </h:column>
            </h:dataTable>

        </body>
    </html>
</f:view>
