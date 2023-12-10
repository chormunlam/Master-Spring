<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>


<div class="container">
<div>Welcome to the todo list page!</div>
<div>Your nameee: ${name}</div>
<div>Your todos are: </div>
<table class="table">
    <thead>
    <tr>
<%--        <th>id</th>--%>
        <th>description</th>
        <th>target date</th>
        <th>is done?</th>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
<%--            <td><c:out value="${todo.id}" /></td>--%>
            <td><c:out value="${todo.description}" /></td>
            <td><c:out value="${todo.targetDate}" /></td>
            <td><c:out value="${todo.done}" /></td>
            <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">update ${todo.id}</a></td>

            <td><a href="delete-todo?id=${todo.id}" class="btn btn-success">dekkleite ${todo.id}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

    <a href="add-todo" class="btn btn-success">Add todo</a>

</div>
<%@include file="common/footer.jspf" %>