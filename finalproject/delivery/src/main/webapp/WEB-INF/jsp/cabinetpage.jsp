<%@ include file="header.jsp" %>

<c:if test="${sessionScope.user != null}">

    <c:set var="history" value="history" scope="page"/>
    <c:set var="settings" value="settings" scope="page"/>

    <!-- Empty block -->
    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-4">
                <!--empty-->
            </div>
            <div class="col-xs-4" align="center">
                <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
                ${requestScope.displayMain}
            </div>
            <div class="col-xs-4">
                <!--empty-->
            </div>
        </div>
    </div>
    <!-- End empty block -->

    <c:choose>
        <c:when test="${sessionScope.cabinetPage == history}" >
            <div class="jumbotron">
                <div class="container">
                    <div class="col-xs-4">
                        <!--empty-->
                    </div>
                    <div class="col-xs-4" align="center">
                        SHOW HISTORY (Page=${sessionScope.cabinetPage})
                        <br>
                        <a href="/cabinet" role="button" class="btn btn-primary pull-center">
                            BACK <fmt:message key="BODY_BTN_GET" />
                        </a>
                    </div>
                    <div class="col-xs-4">
                        <!--empty-->
                    </div>
                </div>
            </div>
        </c:when>
        <c:when test="${sessionScope.cabinetPage == settings}" >
            <div class="jumbotron">
                <div class="container">
                    <div class="col-xs-4">
                        <!--empty-->
                    </div>
                    <div class="col-xs-4" align="center">
                        SHOW SETTINGS
                        <br>
                        <a href="/cabinet" role="button" class="btn btn-primary pull-center">
                            BACK <fmt:message key="BODY_BTN_SET" />
                        </a>
                    </div>
                    <div class="col-xs-4">
                        <!--empty-->
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>

            <!-- Thumbnails -->
            <div class="container thumbs">
                <div class="col-sm-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../../img/menu/ordering.png" alt="info" class="img-responsive">
                        <div class="caption" align="center">
                            <h3 class=""><fmt:message key="NAV_MENU_CREATE" /></h3>
                            <p>Create new order...</p>
                            <div class="btn-toolbar text-center">
                                <a href="/order" role="button" class="btn btn-primary pull-center">
                                    <fmt:message key="BODY_BTN_ACT" />
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../../img/menu/myorders.png" alt="calc" class="img-responsive">
                        <div class="caption" align="center">
                            <h3 class=""><fmt:message key="NAV_MENU_HISTORY" /></h3>
                            <p>View my orders...</p>
                            <div class="btn-toolbar text-center">
                                <form action="" method="get">
                                    <input type="hidden" name="page" value="history" />

                                    <input role="button" class="btn btn-primary pull-center"
                                           type="submit" value="<fmt:message key="BODY_BTN_GET" />" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../../img/menu/settings.png" alt="order" class="img-responsive">
                        <div class="caption" align="center">
                            <h3 class=""><fmt:message key="NAV_MENU_SETTINGS" /></h3>
                            <p>Change some data...</p>
                            <div class="btn-toolbar text-center">
                                <a href="/cabinetsettings" role="button" class="btn btn-primary pull-center">
                                    <fmt:message key="BODY_BTN_SET" />
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Thumbnails -->

            <div align="center">
                <h2><font color="blue">Welcome ${sessionScope.user.login}!</font></h2>
                <h3><font color="blue">Name: ${sessionScope.user.firstName} ${sessionScope.user.lastName}</font></h3>
                <h3><font color="blue">Cabinet: ${sessionScope.cabinetPage}</font></h3>
                <h3><font color="blue">History: ${pageScope.history}</font></h3>
                <h3><font color="blue">E-mail: ${sessionScope.user.userData.eMail}</font></h3>
            </div>

        </c:otherwise>
    </c:choose>

</c:if>

<%@ include file="footer.jsp" %>
