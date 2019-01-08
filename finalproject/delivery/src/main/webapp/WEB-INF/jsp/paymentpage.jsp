<%@ include file="header.jsp" %>

<c:if test="${sessionScope.user != null}">


    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-2">
                <!--empty-->
            </div>
            <div class="col-xs-8" align="center">
                <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
                <h6><font color="orange">

                    <c:if test="${requestScope.ordersPage == null}">
                        <table border="1" width="100%">
                            <thead align="center">
                            <tr>
                                <td width="5%">
                                    NUMBER
                                </td>
                                <td width="50%">
                                    CARGO
                                </td>
                                <td width="10%">
                                    COST
                                </td>
                                <td width="15%">
                                    STATUS
                                </td>
                                <td width="20%">
                                    ACTION
                                </td>
                            </tr>
                            </thead>
                            <tbody>

                                <tr align="center">
                                    <td>
                                        # 123
                                    </td>
                                    <td>
                                        type
                                    </td>
                                    <td>
                                        100$
                                    </td>
                                    <td>
                                        create
                                    </td>
                                    <td>
                                        need to pay
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                        <br>

                    </c:if>

                </font></h6>

            </div>
            <div class="col-xs-2">
                <!--empty-->
            </div>
        </div>
    </div>


    <!-- Thumbnails -->
    <div class="container thumbs">
        <div class="col-sm-3 col-md-3">
            <!--empty-->
        </div>
        <div class="col-sm-6 col-md-6">
            <div class="thumbnail">
                <!--img src="../../img/menu/prices.png" alt="prices.png" class="img-responsive"-->
                <div class="caption" align="center">
                    <h3 class=""><fmt:message key="NAV_MENU_PAYMENT"/></h3>
                    <p></p>
                    <div class="btn-toolbar text-center">

                        <a href="/home" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="BODY_BTN_PAY"/>
                        </a>

                        <a href="/order" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="BODY_BTN_CANCEL"/>
                        </a>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-md-3">
            <!--empty-->
        </div>
    </div>
    <!-- End Thumbnails -->


</c:if>

<%@ include file="footer.jsp" %>
