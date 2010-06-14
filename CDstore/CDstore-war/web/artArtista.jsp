<%-- 
    Document   : artArtista
    Created on : Jun 11, 2010, 11:41:33 AM
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
            <title>Catálogo Artista</title>
        </head>
        <body>
            <h:dataTable id="ttid" value="#{sBean.artigos}" var="artigo">
                <f:facet name="header"><h:outputText value="Catalog Details for #{sBean.artistName}" /></f:facet>
                <h:column>
                    <f:facet name="header"><h:outputText value="Nome" /></f:facet>
                    <h:outputText value="#{artigo.nome}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Stock" /></f:facet>
                   <h:outputText value="#{artigo.stock}" />
                </h:column>
                <h:column>
                    <f:facet name="header"><h:outputText value="Comprar" /></f:facet>
                   <h:form>
                        <h:commandLink action="#{sBean.addItemToCart}">
                            <h:outputText value="Comprar" />
                            <f:param name="codDisco" value = "#{artigo.codigo}" />
                        </h:commandLink>
                    </h:form>
                </h:column>
            </h:dataTable>
        </body>
    </html>
</f:view>
