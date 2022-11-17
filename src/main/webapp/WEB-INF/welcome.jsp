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

        <h1>Shop amok</h1>


        <form action="addtocart" method="post">

            <select name="top">
                <c:forEach var="topItem" items="${sessionScope.topList}">
                    <option value="${topItem.id}">${topItem.name} (${topItem.price} kr)</option>
                </c:forEach>
            </select>
            <select name="bottom">
                <c:forEach var="bottomItem" items="${sessionScope.bottomList}">
                    <option value="${bottomItem.id}">${bottomItem.name} (${bottomItem.price} kr)</option>
                </c:forEach>
            </select>
            <select name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="4">5</option>
            </select>
            <button class="btn btn-primary" name="addToCart">Tilføj til kurv</button>
        </form>

        <p>Antal linier i kurven: ${requestScope.cartsize}</p>

        <h3>Indhold i kurv:</h3>

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
            <p>Pris ordre: </p>

        </table>
        </table>
        <p class="mt-4"><a class="btn btn-primary" href="order">Bestil indkøbskurv</a></p>


    </jsp:body>

</t:pagetemplate>