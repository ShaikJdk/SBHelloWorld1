<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
    <h1>Order List</h1>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Order ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Order Status</th>
            <th>Delivery Date</th>
            <th>Tracking ID</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.orderName}</td>
                <td>${order.price}</td>
                <td>${order.orderStatus}</td>
                <td>${order.delivaryDate}</td>
                <td>${order.trackingId}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="${pageContext.request.contextPath}/mysql/index">Back Home</a> |
    <a href="${pageContext.request.contextPath}/mysql/add-order">Add Product</a>
</body>
</html>