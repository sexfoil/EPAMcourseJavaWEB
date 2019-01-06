<%@ include file="header.jsp" %>


<!-- Info block -->
<div class="jumbotron">
    <div class="container">
        <div class="col-xs-3">
            <!--empty-->
        </div>
        <div class="col-xs-6" align="center">
            <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
            <h6><font color="orange">

                <c:if test="${requestScope.pricesPage != null}">
                    <table border="1" width="100%">
                        <thead align="center">
                        <tr>
                            <td width="40%">
                                <h5><fmt:message key="PRICE_TABLE_TITLE"/></h5>
                            </td>
                            <td width="15%">
                                L &gt; 1
                            </td>
                            <td width="15%">
                                L &gt; 1000
                            </td>
                            <td width="15%">
                                L &gt; 5000
                            </td>
                            <td width="15%">
                                L &gt; 10000
                            </td>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach var="cargoes" begin="1" end="9">
                            <tr>
                                <td align="left">
                                    <h5>CARGO # ${cargoes}</h5>
                                </td>
                                <td>
                                        ${20 * cargoes} $
                                </td>
                                <td>
                                        ${18 * cargoes} $
                                </td>
                                <td>
                                        ${16 * cargoes} $
                                </td>
                                <td>
                                        ${10 * cargoes} $
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <c:if test="${requestScope.directionsPage != null}">
                    <table border="1" width="100%">
                        <thead align="center">
                        <tr>
                            <td width="70%">
                                <h5><fmt:message key="DIRECTION_TABLE_TITLE"/></h5>
                            </td>
                            <td width="30%">
                                METERS
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="direction" items="${requestScope.streetsListPage}">
                            <tr align="center">
                                <td align="left">
                                    <h5>${direction}</h5>
                                </td>
                                <td>
                                    1234
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <!-- Pagination -->
                    <c:if test="${requestScope.pageNum > 1}">
                        <a href="?page=1" role="button" class="btn btn-primary pull-center">
                            FIRST
                        </a>
                        <a href="?page=${requestScope.pageNum - 1}" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="PAGE_PREV"/>
                        </a>
                    </c:if>
                    <c:if test="${requestScope.pageNum - 2 > 0}">
                        <a href="?page=${requestScope.pageNum - 2}" role="button" class="btn btn-primary pull-center">
                                ${requestScope.pageNum - 2}
                        </a>
                    </c:if>
                    <c:if test="${requestScope.pageNum - 1 > 0}">
                        <a href="?page=${requestScope.pageNum - 1}" role="button" class="btn btn-primary pull-center">
                                ${requestScope.pageNum - 1}
                        </a>
                    </c:if>
                    <c:if test="${requestScope.pageNum > 0}">
                        <p role="button" class="btn btn-primary pull-center">
                                <font color="red"> ${requestScope.pageNum}</font>
                        </p>
                    </c:if>
                    <c:if test="${requestScope.pageNum + 1 <= requestScope.lastPage}">
                        <a href="?page=${requestScope.pageNum + 1}" role="button" class="btn btn-primary pull-center">
                                ${requestScope.pageNum + 1}
                        </a>
                    </c:if>
                    <c:if test="${requestScope.pageNum + 2 <= requestScope.lastPage}">
                        <a href="?page=${requestScope.pageNum + 2}" role="button" class="btn btn-primary pull-center">
                                ${requestScope.pageNum + 2}
                        </a>
                    </c:if>
                    <c:if test="${requestScope.pageNum <= requestScope.lastPage}">
                        <a href="?page=${requestScope.pageNum + 1}" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="PAGE_NEXT"/>
                        </a>
                        <a href="?page=${requestScope.lastPage}" role="button" class="btn btn-primary pull-center">
                            LAST
                        </a>
                    </c:if>
                    <!-- End Pagination -->

                </c:if>

            </font></h6>

        </div>
        <div class="col-xs-3">
            <!--empty-->
        </div>
    </div>
</div>
<!-- End Info block -->


<!-- Thumbnails -->
<div class="container thumbs">
    <div class="col-sm-3 col-md-3">
        <!--empty-->
    </div>
    <c:if test="${requestScope.pricesPage != null}">
        <div class="col-sm-6 col-md-6">
            <div class="thumbnail">
                <!--img src="../../img/menu/prices.png" alt="prices.png" class="img-responsive"-->
                <div class="caption" align="center">
                    <h3 class=""><fmt:message key="NAV_MENU_PRICES"/></h3>
                    <p></p>
                    <div class="btn-toolbar text-center">
                        <a href="/home" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_HOME"/>
                        </a>

                        <a href="/info_directions" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_DIRECTIONS"/>
                        </a>

                        <a href="/calculator" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_CALCULATOR"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${requestScope.directionsPage != null}">
        <div class="col-sm-6 col-md-6">
            <div class="thumbnail">
                <!--img src="../../img/menu/directions.png" alt="directions.png" class="img-responsive"-->
                <div class="caption" align="center">
                    <h3 class=""><fmt:message key="NAV_MENU_DIRECTIONS"/></h3>
                    <p></p>
                    <div class="btn-toolbar text-center">
                        <a href="/home" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_HOME"/>
                        </a>

                        <a href="/info_prices" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_PRICES"/>
                        </a>

                        <a href="/calculator" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_CALCULATOR"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

    <div class="col-sm-3 col-md-3">
        <!--empty-->
    </div>
</div>
<!-- End Thumbnails -->


<%@ include file="footer.jsp" %>
