<%-- 
    Document   : infoprodotti
    Created on : 4-nov-2014, 9.44.33
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${prodotti}" var="prodotto">
        <li>${prodotto.nome}</li>
    </c:forEach>
</ul>
