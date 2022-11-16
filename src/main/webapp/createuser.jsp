<%--
  Created by IntelliJ IDEA.
  User: Jantie
  Date: 16-11-2022
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<t:pagetemplate>

    <html>
    <head>
        <title>Opret bruger</title>
    </head>
    <body>

    <h3>Opret bruger her</h3>

    <form action="CreateUser" method="post">
        <label for="username">Username: </label>
        <input type="text" id="username" name="username"/>

        <label for="password">Password: </label>
        <input type="password" id="password" name="password"/>

        <label for="accounttype">Accounttype: </label>
        <input type="accounttype" id="accounttype" name="accounttype"/>

        <label for="balance">balance: </label>
        <input type="balance" id="balance" name="balance"/>


        <input type="submit" value="Opret"/>
    </form>

    </body>
    </html>
</t:pagetemplate>