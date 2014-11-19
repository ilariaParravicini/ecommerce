<%-- 
    Document   : home
    Created on : 13-ott-2014, 15.18.49
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/toastr.min.css">
    </head>
    <body>
        <%--<div id="page">
        <%--header --%>
        <div id="header" class="container">
            <div class="row">
                <div class="col-md-4">                    
                    <h3>Ilababa <spring:message code="welcome" /> 
                </div>
                <div class="form-group col-md-4 col-md-offset-8">                    
                    <a href="?language=en"> <img src="${pageContext.request.contextPath}/img/uk.png" /></a>
                    <a href="?language=fr"><img src="${pageContext.request.contextPath}/img/fr.png" /></a> 
                    <a href="?language=es"> <img src="${pageContext.request.contextPath}/img/es.jpg" /></a>
                    <a href="?language=de"><img src="${pageContext.request.contextPath}/img/de.jpg" /></a> <br />
                </div>
            </div>
        </div>

        <div id="main" class="container-fluid"> 
            <div class="row">

                <form:form commandName="utente" action="login.aspx">
                    <%--<form role="form" action="login.aspx" method="post">--%>
                    <div class="form-group col-md-4 col-md-offset-8 ">
                        <label for="userName">Nome Utente</label>
                        <form:input path="userName" class="form-control" id="userName" placeholder="userName" />
                        <%--<form:errors path="userName" />--%>
                    </div>
                    <div class="form-group col-md-4 col-md-offset-8">
                        <label for="password">Password</label>
                        <form:password path="password" class="form-control" id="password" placeholder="Password" />
                        <%--<form:errors path="password" />--%>
                    </div>
                    <div class="form-group col-md-4 col-md-offset-8">
                        <button type="submit" class="btn btn-default" onclick="return (appValidazione.validazioneUsername() || appValidazione.validazionePassword());">Login</button>
                        <a href="registrazione.aspx"> <img title="registrazione" src="img/registrati.jpg" /></a>
                    </div>
                    <div class="form-group col-md-4 col-md-offset-8">
                        ${messaggio}
                    </div>
                </form:form>



            </div>  
        </div>


        <div id="myDiv" class="container-fluid"> 
            <div class="row">
                <div class="form-group col-md-4 col-md-offset-4 ">
                        <%--<form action="ajax.aspx">--%>
                        <label for="prodotto">Prodotto</label>
                        <%-- onkeyup = quando rilascio tasto --%>
                        <input name="nome" onkeyup="cercaProdotti(this.value)" class="form-control" placeholder="prodotto" />
                        <%--First name: <input type="text" id="prodotto" onkeyup="showHintASP(this.value)" />--%>
                        <%--<p>Suggestions: <span id="txtHintASP"></span></p> --%>                  
                </div>
                <div id="infoprodotti" class="col-md-4"></div>
            </div>
        </div>


        <script src="${pageContext.request.contextPath}/js/lib/jquery-2.0.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/toastr.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxprogram.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/toastr.min.js"></script>
    </body>
</html>