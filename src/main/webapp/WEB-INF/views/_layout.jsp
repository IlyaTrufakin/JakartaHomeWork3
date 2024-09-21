<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="itstep.learning.filters.StatusCodeInfo" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    String contextPath = request.getContextPath();
    String contentPage = (String) request.getAttribute("ContentPage");
    if (contentPage == null) {
        contentPage = "noPageFound.jsp";
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=contextPath%>/img/favicon.ico" type="image/x-icon">
    <title>Java Web Jakarta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=contextPath%>/css/site.css" type="text/css">
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <!-- Основной контент -->
        <div class="col main-content">
            <jsp:include page="_header.jsp"/>
            <jsp:include page="<%= contentPage %>"/>
            <jsp:include page="_footer.jsp"/>
        </div>

        <!-- Окно диагностики -->
        <div class="col diagnostics">
            <h5>Debug Terminal</h5>
            <!--
            <button id="update-debug-info" class="btn btn-primary mb-2">Update Debug Info</button>
            -->
            <div id="debug-terminal">
                <div id="terminal-content"></div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    var contextPath = '<%=request.getContextPath()%>';
    //   let paramFromJSP = "<%= contextPath %>";
</script>
<script src="<%=contextPath%>/js/site.js"></script>

<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js">
</script>

<script src="<%=contextPath%>/js/debug.js">

</script>
</body>
</html>
