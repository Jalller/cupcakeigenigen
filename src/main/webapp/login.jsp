<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <form action="login" method="post">
            <label class="formular" for="username">Brugernavn: </label>
            <input type="text" id="username" name="username"/>
            <br>
            <label class="formular" for="password">Kodeord: </label>
            <input type="password" id="password" name="password"/>
            <br>
            <input type="submit" value="Login"/>
        </form>

        <br>
        <a href="index.jsp">Tilbage til forside</a>

    </jsp:body>
</t:pagetemplate>