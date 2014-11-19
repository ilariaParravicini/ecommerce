<%-- 
    Document   : registrazione
    Created on : 17-ott-2014, 14.14.36  id="userName"  id="password"
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registrazione</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/site.css">
    </head>
    <body>
        <div id="header" class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Ilababa <small>Registrazione</small></h3> 
                    <br/>
                    <br/> 
                </div>
            </div>
        </div>

        <div id="main" class="container-fluid"> 
            <div class="row">
                <form:form commandName="utente" action="registrazione.aspx">
                    <div class="form-group col-md-4 col-md-offset-8 ">
                        <label for="userName">Nome Utente</label>
                        <form:input path="userName" class="form-control"  placeholder="userName" />
                        <form:errors path="userName" />
                    </div>
                    <div class="form-group col-md-4 col-md-offset-8">
                        <label for="password">Password</label>
                        <form:password path="password" class="form-control"  placeholder="Password" />
                        <form:errors path="password" />
                    </div>
                    <div class="form-group col-md-4 col-md-offset-8">
                        <button type="submit" class="btn btn-default">Registra</button>                        
                    </div>
                     <div class="form-group col-md-4 col-md-offset-8">
                    ${messaggio}
                    </div>
                 </form:form>  
            </div>
        </div>
        <script src="js/jquery-2.0.3.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
