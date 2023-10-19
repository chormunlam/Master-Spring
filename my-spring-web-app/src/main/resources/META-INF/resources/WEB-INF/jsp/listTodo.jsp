<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>List Todos page</title>
</head>
<body>
Welcome to the todo list page!
<div>Your nameee: ${name}</div>
<div>Your todos are: </div>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>description</th>
        <th>target date</th>
        <th>is done?</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td><c:out value="${todo.id}" /></td>
            <td><c:out value="${todo.description}" /></td>
            <td><c:out value="${todo.targetDate}" /></td>
            <td><c:out value="${todo.done}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>
