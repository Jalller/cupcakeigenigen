<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pagetemplate>
    <jsp:attribute name="header">
         Shopping page
    </jsp:attribute>

    <jsp:attribute name="footer">
        Shopping page
    </jsp:attribute>

    <jsp:body>
        <h3>Her skal være en liste over ordrer + done/undone kanpper (se video 3)</h3>

        <c:forEach var="item" items="${sessionScope.orderline.orderline_id}">
            ${item.order_lines.order_line_id}
        </c:forEach>

    </jsp:body>

</t:pagetemplate>