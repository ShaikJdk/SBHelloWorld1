<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Order (via JSON)</title>
    <script>
        function submitOrder(event) {
            event.preventDefault(); // Stop normal form submit

            const order = {
                orderId: document.getElementById("orderId").value,
                orderName: document.getElementById("orderName").value,
                orderStatus: document.getElementById("orderStatus").value,
                price: parseFloat(document.getElementById("price").value),
                delivaryDate: document.getElementById("delivaryDate").value,
                trackingId: document.getElementById("trackingId").value
            };

            fetch("${pageContext.request.contextPath}/mysql/add-order", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(order)
            })
            .then(response => response.text())
            .then(message => {
                alert(message);
                window.location.href = "${pageContext.request.contextPath}/mysql/orders";
            })
            .catch(error => console.error("Error:", error));
        }
    </script>
</head>
<body>
    <h1>Add New Order</h1>
    <form onsubmit="submitOrder(event)">
        <label>Order ID:</label>
        <input type="number" id="orderId" required><br><br>

        <label>Order Name:</label>
        <input type="text" id="orderName" required><br><br>

        <label>Order Status:</label>
        <input type="text" id="orderStatus" required><br><br>

        <label>Price:</label>
        <input type="number" step="0.01" id="price" required><br><br>

        <label>Delivery Date:</label>
        <input type="date" id="delivaryDate" required><br><br>

        <label>Tracking ID:</label>
        <input type="text" id="trackingId" required><br><br>

        <button type="submit">Save</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/mysql/index">Back to Orders</a>
</body>
</html>
