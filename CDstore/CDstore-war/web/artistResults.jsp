<%-- 
    Document   : artistResults
    Created on : Jun 8, 2010, 5:04:14 PM
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
            <title>Search Results</title>
        </head>
        <body>

            <h:dataTable id="ttid" value="#{sBean.artistas}" var="artistas">
                <f:facet name="header"><h:outputText value="Search Results for #{sBean.artistName}" /></f:facet>
                <h:column>
                    <f:facet name="header"><h:outputText value="Nome" /></f:facet>
                    <h:outputText value="#{artistas.nome}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Artigos" /></f:facet>
                    <h:form>
                        <h:commandLink action="#{sBean.showDetails}">
                            <h:outputText value="Ver" />
                            <f:param name="nomeArtista" value = "#{artistas.codigo}" />
                        </h:commandLink>
                    </h:form>

                </h:column>
            </h:dataTable>

            <br/>
            <br/>
            <h2><h:outputLink value="cartContents.jsp"><h:outputText value="Show Cart"/></h:outputLink></h2>

        </body>
    </html>
</f:view>
