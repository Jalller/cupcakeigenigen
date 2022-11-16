<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pagetemplate>
    <jsp:attribute name="header">
         Edit item
    </jsp:attribute>

    <jsp:attribute name="footer">
        Edit item
    </jsp:attribute>

    <jsp:body>

        <h3>Rediger vare her</h3>
        <input type="text" value="${requestScope.name}" name="name"/>


    </jsp:body>

</t:pagetemplate>