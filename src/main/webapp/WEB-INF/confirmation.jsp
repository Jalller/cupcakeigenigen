<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pagetemplate>
    <jsp:attribute name="header">
         Confirmation
    </jsp:attribute>

    <jsp:attribute name="footer">
        Confirmation page
    </jsp:attribute>

    <jsp:body>

        <h1>Kvittering</h1>

       <p>Tak for din bestilling. Du kan hente den om 1 time i Olsker.</p>


        <h3>Indhold i kurv:</h3>

        ${cart}


        <table class="table table-striped">
            <tr>
                <th>Top</th>
                <td>
                    <c:forEach var="item" items="${sessionScope.cart.cupcakeList}">
                        <br>Type: ${item.top.name} Price: ${item.top.price} </c:forEach>
                </td>

                <th>Bund</th>
                <td>
                    <c:forEach var="item" items="${sessionScope.cart.cupcakeList}">
                        <br>Type: ${item.bottom.name} Price: ${item.bottom.price}
                    </c:forEach>
                </td>

                <th>Antal</th>
                <td>
                    <c:forEach var="item" items="${sessionScope.cart.cupcakeList}">
                        <br>Antal: ${item.quantity}
                    </c:forEach>
                </td>
            </tr>
        </table>
        </table>



    </jsp:body>

</t:pagetemplate>