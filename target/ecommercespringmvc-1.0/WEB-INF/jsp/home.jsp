<%-- 
    Document   : home
    Created on : 17-ott-2014, 13.58.32
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/site.css">
    </head>
    <body>
        <div id="header" class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Ilababa</h3> 
                    <%--<br/>
                    <br/>
                    <h2>Benvenuto ${utente.userName} hai il profilo di ${utente.profilo}</h2> 
                    <button type="submit" class="btn btn-default"><a href="logout.aspx">Logout</a></button>--%>
                </div>
            </div>
        </div>

        <div id="menu" class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2><spring:message code="welcome" /> ${utentedb.userName} <spring:message code="profilo" /> ${utentedb.profilo}</h2> 
                    <button type="submit" class="btn btn-default"><a href="logout.aspx">Logout</a></button>
                </div>
            </div>
        </div>

        <div id="casa" class="container-fluid"> 
            <c:choose>
                <c:when test="${utentedb.profilo eq 'admin'}" > 
                    <button type="submit" class="btn btn-default">
                        <a href="valoreordini.aspx"><span class="glyphicon glyphicon-euro"></span> <spring:message code="valoreordini" /></a>
                    </button>
                </c:when>

                <c:when test="${utentedb.profilo eq 'user'}" > 
                    <button type="submit" class="btn btn-default">
                        <a href="listaprodotti.aspx"><span class="glyphicon glyphicon-list-alt"></span> <spring:message code="listaprodotti" /></a>
                    </button>
                    <button type="submit" class="btn btn-default">
                        <a href="listaordini.aspx"><span class="glyphicon glyphicon-list"></span> <spring:message code="elencoordini" /></a>
                    </button>


                </c:when>

                <c:otherwise>
                    Non ci sono utenti
                </c:otherwise>
            </c:choose>
        </div>
        <script src="js/jquery-2.0.3.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
