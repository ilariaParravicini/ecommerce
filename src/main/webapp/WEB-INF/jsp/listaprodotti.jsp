<%-- 
    Document   : listaprodotti
    Created on : 18-ott-2014, 14.19.14
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="prodotti" /></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css">
    </head>

    <body>
        <div id="header" class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Ilababa</h3> 
                </div>
            </div>
        </div>

        <div id="menu" class="container">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs">
                        <li><a href="${pageContext.request.contextPath}/logout.aspx">Logout</a></li>
                        <li><a href="${pageContext.request.contextPath}/listaordini.aspx"><span class="glyphicon glyphicon-list"></span> <spring:message code="elencoordini" /></a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="lista" class="container-fluid"> 
            <c:choose>
                <c:when test="${prodotti.size() > 0}"> 
                    <h2><spring:message code="prodotti" /></h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th><spring:message code="nome"/></th>
                                <th><spring:message code="descrizione"/></th>
                                <th><spring:message code="prezzo"/></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${prodotti}" var="prodotto">
                                <tr>
                                    <td>${prodotto.nome}</td>
                                    <td>${prodotto.descrizione}</td>
                                    <td>${prodotto.prezzo}</td>
                                    <td>
                                        <a href="aggiungialcarrello.aspx?idProdotto=${prodotto.nome}">
                                            <span class="glyphicon glyphicon-shopping-cart"></span>
                                        </a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <spring:message code="noprodotti" />
                </c:otherwise>
            </c:choose>
        </div>
        <br/>
        <br/>
        <div id="lista" class="container-fluid">
            <c:choose>
                <c:when test="${carrello.size() > 0}">
                    <h2><spring:message code="carrello"/></h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th><spring:message code="nome"/></th>
                                <th><spring:message code="descrizione"/></th>
                                <th><spring:message code="prezzo"/></th>
                                <th><spring:message code="quantita"/></th>
                                <th><spring:message code="costo"/></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${carrello.vociCarrello}" var="voce">
                                <tr>
                                    <td>${voce.prodotto.nome}</td>
                                    <td>${voce.prodotto.descrizione}</td>
                                    <td>${voce.prodotto.prezzo}</td>
                                    <td>${voce.quantita}</td>
                                    <td>${voce.calcolaCosto()}</td>
                                    <td><a href="eliminaVoce.aspx?idProdotto=${voce.prodotto.nome}">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <b><spring:message code="costocarrello"/>: ${carrello.calcolaCosto()}</b>
                    <a href="acquista.aspx">
                        <span class="glyphicon glyphicon-ok"></span>  
                    </a>
                </c:when>
                <c:otherwise>
                    <spring:message code="noprodotti"/>
                </c:otherwise>
            </c:choose>
            ${messaggio}
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
