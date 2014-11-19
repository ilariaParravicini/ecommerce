<%-- 
    Document   : carrello
    Created on : 18-ott-2014, 21.13.44
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordini</title>
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
                    <br/>
                    <br/>       
                    <ul class="nav nav-tabs">
                        <li><a href="logout.aspx">Logout</a></li>
                        <li><a href="listaprodotti.aspx"><span class="glyphicon glyphicon-list-alt"></span> <spring:message code="listaprodotti" /></a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="lista" class="container-fluid">
            <c:choose>
                <c:when test="${ordini.size() > 0}">
                    <h2><spring:message code="ordini" /></h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th><spring:message code="numero" /></th>
                                <th><spring:message code="totale" /></th>
                                <th><spring:message code="stato" /></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ordini}" var="ordine">
                                <tr>
                                    <td>${ordine.idOrdine}</td>
                                    <%--<td>${ordine.dataOrdine}</td>--%>
                                    <td>${ordine.totale}</td>
                                    <td>${ordine.statoOrdine}</td>
                                    <td>
                                        <a href="annullaordini.aspx?idOrdine=${ordine.idOrdine}">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    Non ci sono ordini
                </c:otherwise>
            </c:choose>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
