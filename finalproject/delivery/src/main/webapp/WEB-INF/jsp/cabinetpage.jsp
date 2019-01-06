<%@ include file="header.jsp" %>

<c:if test="${sessionScope.user != null}">

    <!-- Empty block -->
    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-4">
                <!--empty-->
            </div>
            <div class="col-xs-4" align="center">
                <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
                    ${requestScope.displayMain}SOME TEXT
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
                <img src="../../img/menu/ordering.png" alt="info" class="img-responsive">
                <div class="caption" align="center">
                    <h3 class=""><fmt:message key="NAV_MENU_CREATE"/></h3>
                    <p>Create new order...</p>
                    <div class="btn-toolbar text-center">
                        <a href="/order" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="BODY_BTN_ACT"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <div class="thumbnail">
                <img src="../../img/menu/myorders.png" alt="calc" class="img-responsive">
                <div class="caption" align="center">
                    <h3 class=""><fmt:message key="NAV_MENU_HISTORY"/></h3>
                    <p>View my orders...</p>
                    <div class="btn-toolbar text-center">
                        <a href="/cabinet_history" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="BODY_BTN_SET"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <div class="thumbnail">
                <img src="../../img/menu/settings.png" alt="order" class="img-responsive">
                <div class="caption" align="center">
                    <h3 class=""><fmt:message key="NAV_MENU_SETTINGS"/></h3>
                    <p>Change some data...</p>
                    <div class="btn-toolbar text-center">
                        <a href="/cabinet_settings" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="BODY_BTN_SET"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Thumbnails -->


</c:if>

<%@ include file="footer.jsp" %>
