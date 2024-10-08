<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>
<footer class="text-center text-lg-start bg-body-tertiary text-muted">
    <!-- Section: Social media -->
    <section class="d-flex flex-column text-center justify-content-center p-4 border-bottom">
        <section class="mb-3 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
        </section>
        <section>
            <!-- Facebook -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1"
               style="background-color: #3b5998;"
               href="#!"
               role="button"><i class="fab fa-facebook-f"></i></a>
            <!-- Twitter -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1"
               style="background-color: #55acee;"
               href="#!"
               role="button"><i class="fab fa-twitter"></i></a>
            <!-- Google -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1"
               style="background-color: #dd4b39;"
               href="#!"
               role="button"><i class="fab fa-google"></i></a>
            <!-- Instagram -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1"
               style="background-color: #ac2bac;"
               href="#!"
               role="button"><i class="fab fa-instagram"></i></a>
            <!-- Linkedin -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1"
               style="background-color: #0082ca;"
               href="#!"
               role="button"><i class="fab fa-linkedin-in"></i></a>
            <!-- Github -->
            <a data-mdb-ripple-init class="btn text-white btn-floating m-1"
               style="background-color: #333333;"
               href="#!"
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
                    <p>В футере сайта традиционно указывают копирайт, условия использования и
                        распространения
                        контента, информацию о разработчике ресурса.</p>
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