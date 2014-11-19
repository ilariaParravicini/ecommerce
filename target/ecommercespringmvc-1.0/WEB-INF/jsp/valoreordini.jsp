<%-- 
    Document   : valoreordini
    Created on : 18-ott-2014, 21.46.56
    Author     : utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="valoreordini" /></title>
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
                    <ul class="nav nav-tabs" role="tablist">
                        <a href="logout.aspx">Logout</a>
                    </ul>
                </div>
            </div>
        </div>
                    
        <div id="guadagno" class="container-fluid">
            <spring:message code="valoreordini30" />: <h3>${guadagno}</h3>
        </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
