<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
    <div class="container">
        <div>Welcome to the todo list page!</div>
        <div>Your name: ${name}</div>
        <h1>Todo details: </h1>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">

            <form:label path="description">Description</form:label>
            <form:input type="text"  path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="mb-3">

                <form:label path="targetDate">target Date</form:label>
                <form:input type="text"  path="targetDate" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>
            <form:input type="hidden"  path="done" />
            <form:input type="hidden"  path="id" />
            <input type="submit" class="btn btn-success "/>
        </form:form>




    </div>
    <%@include file="common/footer.jspf" %>
    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    </script>

<%--webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js--%>
<%--webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css--%>