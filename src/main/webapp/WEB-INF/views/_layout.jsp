<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="itstep.learning.filters.StatusCodeInfo" %>

<%
    String contextPath = request.getContextPath();
    String contentPage = (String) request.getAttribute("ContentPage");
    if (contentPage == null) {
        contentPage = "noPageFound.jsp";
    }

    // Получаем объект StatusCodeInfo из атрибутов запроса
    StatusCodeInfo statusCodeInfo = (StatusCodeInfo) request.getAttribute("StatusCodeInfo");

    String statusCodeMessage;
    if (statusCodeInfo != null) {
        statusCodeMessage = statusCodeInfo.toString();
    } else {
        statusCodeMessage = "Ошибка при получении статуса выполнения запроса";
    }
%>





<html>
<head>
    <meta charset="UTF-8">
    <title>Java Web</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=contextPath%>/css/site.css">
</head>

<body>

<p><strong><%= statusCodeMessage %></strong></p>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="<%=contextPath%>/img/images.webp" alt="logo" class="d-inline-block align-text-top">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<%=contextPath%>">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath%>/db">DataBase</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath%>/logging">Logging</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath%>/ErrorPage">ErrorPage</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main class="container">
    <jsp:include page="<%= contentPage %>"/>
</main>

<div class="spacer"></div>

<footer class="text-center text-lg-start bg-body-tertiary text-muted">
    <!-- Section: Social media -->
    <section class="d-flex flex-column text-center justify-content-center p-4 border-bottom">
        <section class="mb-3 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
        </section>
        <section>
            <!-- Facebook -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1" style="background-color: #3b5998;" href="#!"
               role="button"><i class="fab fa-facebook-f"></i></a>
            <!-- Twitter -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1" style="background-color: #55acee;" href="#!"
               role="button"><i class="fab fa-twitter"></i></a>
            <!-- Google -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1" style="background-color: #dd4b39;" href="#!"
               role="button"><i class="fab fa-google"></i></a>
            <!-- Instagram -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1" style="background-color: #ac2bac;" href="#!"
               role="button"><i class="fab fa-instagram"></i></a>
            <!-- Linkedin -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1" style="background-color: #0082ca;" href="#!"
               role="button"><i class="fab fa-linkedin-in"></i></a>
            <!-- Github -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1" style="background-color: #333333;" href="#!"
               role="button"><i class="fab fa-github"></i></a>
        </section>
    </section>

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>Company name
                    </h6>
                    <p>В футере сайта традиционно указывают копирайт, условия использования и распространения контента, информацию о разработчике ресурса.</p>
                </div>
                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">Products</h6>
                    <p><a href="#!" class="text-reset">Angular</a></p>
                    <p><a href="#!" class="text-reset">React</a></p>
                    <p><a href="#!" class="text-reset">Vue</a></p>
                    <p><a href="#!" class="text-reset">Laravel</a></p>
                </div>
                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
                    <p><a href="<%=contextPath%>/db" class="text-reset">DataBase</a></p>
                    <p><a href="#!" class="text-reset">Settings</a></p>
                    <p><a href="#!" class="text-reset">Orders</a></p>
                    <p><a href="#!" class="text-reset">Help</a></p>
                </div>
                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                    <p><i class="fas fa-envelope me-3"></i> info@example.com</p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2024 Copyright:
        <a class="text-reset fw-bold" href="#!">Copyright</a>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="<%=contextPath%>/js/site.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"></script>
</body>
</html>
