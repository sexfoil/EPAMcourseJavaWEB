<%@ include file="header.jsp" %>

<c:if test="${sessionScope.user != null}">


    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-3">
                <!--empty-->
            </div>
            <div class="col-xs-6" align="center">
                <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
                <h6><font color="orange">

                    <c:if test="${requestScope.ordersPage != null}">
                        <table border="1" width="100%">
                            <thead align="center">
                            <tr>
                                <td width="40%">
                                    NUMBER
                                </td>
                                <td width="30%">
                                    ACTION
                                </td>
                                <td width="30%">
                                    STATUS
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

            <c:set var="displayMain" value="true" scope="request" />
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
                                <form action="" method="get">
                                    <input type="hidden" name="page" value="settings" />

                                    <input role="button" class="btn btn-primary pull-center"
                                           type="submit" value="<fmt:message key="BODY_BTN_SET" />" />
                                </form>
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
