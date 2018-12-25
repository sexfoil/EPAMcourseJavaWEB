<%@ include file="WEB-INF/jsp/header.jsp" %>

<!-- Empty block -->
<div class="jumbotron">
    <div class="container">
        <div class="col-xs-4">
            <!--empty-->
        </div>
        <div class="col-xs-4" align="center">
            <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
        </div>
        <div class="col-xs-4">
            <!--empty-->
        </div>
    </div>
</div>
<!-- End empty block -->


<!-- Thumbnails -->
<div class="container thumbs">
    <div class="col-sm-4 col-md-4">
        <div class="thumbnail">
            <img src="img/menu/prices.png" alt="info" class="img-responsive">
            <div class="caption" align="center">
                <h3 class=""><fmt:message key="NAV_MENU_PRICES" /></h3>
                <p>Our prices and tariffs...</p>
                <div class="btn-toolbar text-center">
                    <a href="/info?page=prices" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="BODY_BTN_EXPLORE" />
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4 col-md-4">
        <div class="thumbnail">
            <img src="img/menu/directions.png" alt="calc" class="img-responsive">
            <div class="caption" align="center">
                <h3 class=""><fmt:message key="NAV_MENU_DIRECTIONS" /></h3>
                <p>Directions of delivering...</p>
                <div class="btn-toolbar text-center">
                    <a href="/info?page=directions" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="BODY_BTN_EXPLORE" />
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4 col-md-4">
        <div class="thumbnail">
            <img src="img/menu/calculator.png" alt="order" class="img-responsive">
            <div class="caption" align="center">
                <h3 class=""><fmt:message key="NAV_MENU_CALCULATOR" /></h3>
                <p>Calculate your order...</p>
                <div class="btn-toolbar text-center">
                    <a href="/calculator" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="BODY_BTN_EXPLORE" />
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Thumbnails -->


<%@ include file="WEB-INF/jsp/footer.jsp" %>
