<%@ include file="header.jsp" %>


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
        <!--empty-->
    </div>
    <div class="col-sm-4 col-md-4">
        <div class="thumbnail">
            <img src="../../img/menu/info.png" alt="calc" class="img-responsive">
            <div class="caption" align="center">
                <h3 class="">${sessionScope.infoPage}</h3>
                <p>SOME INFO</p>
                <div class="btn-toolbar text-center">
                    <a href="?language=wtf" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="BODY_BTN_EXPLORE" />
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4 col-md-4">
        <!--empty-->
    </div>
</div>
<!-- End Thumbnails -->


<%@ include file="footer.jsp" %>
