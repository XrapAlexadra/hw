<%@ page import="com.gmail.xrapalexandra.model.Role" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product List</title>
    <link href="${pageContext.request.contextPath}/pages/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<table>
    <caption>Спикок товаров на складе</caption>
    <tr>
        <th>Номер</th>
        <th>Название</th>
        <th>Цена</th>
        <th>Количество</th>
    </tr>
    <c:forEach items="${requestScope.productlist}" var="item" varStatus="infdex">
        <tr>
            <th><c:out value="${infdex.count}"/></th>
            <th><c:out value="${item.name}"/></th>
            <th><c:out value="${item.price}"/></th>
            <th><c:out value="${item.quantity}"/></th>
        </tr>
    </c:forEach>
</table>
<br>


<c:if test="${sessionScope.user.role == Role.ADMIN}">
    <form method="get" action=${pageContext.request.contextPath}/addproduct>
        <fieldset style="width: 50px">
            <legend>Добавить товар</legend>
            <label>
                <input type="text" name="name" required pattern="^[A-Za-zА-Яа-яЁё\s]+$" maxlength="30" size="33">
            </label>
            <br>
            <label>
                <input type="text" name="price" required placeholder="0" pattern="[0-9]{1,7}" maxlength="7" size="10">
            </label>
            <label>
                <input type="text" name="quantity" required placeholder="0" pattern="[0-9]{1,7}" maxlength="7"
                       size="10">
            </label>
            <br>
            <input type="submit" value="Добавить">
            <input type="reset" value="Сбросить">
        </fieldset>
    </form>
</c:if>
</body>
</html>
