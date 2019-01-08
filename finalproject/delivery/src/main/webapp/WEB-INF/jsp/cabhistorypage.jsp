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

                    <c:if test="${requestScope.ordersPage != null}">
                        <table border="1" width="100%">
                            <thead align="center">
                            <tr>
                                <td width="5%">
                                    NUMBER
                                </td>
                                <td width="35%">
                                    CARGO
                                </td>
                                <td width="10%">
                                    COST
                                </td>
                                <td width="20%">
                                    DATE
                                </td>
                                <td width="15%">
                                    STATUS
                                </td>
                                <td width="15%">
                                    ACTION
                                </td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="invoice" items="${requestScope.userInvoices}">
                                <tr align="center">
                                    <td>
                                        <h5>${invoice.id}</h5>
                                    </td>
                                    <td>
                                        <h5>${invoice.cargoId}</h5>
                                    </td>
                                    <td>
                                        <h5>${invoice.cost*0.01}</h5>
                                    </td>
                                    <td>
                                        <h5>${invoice.dateTime}</h5>
                                    </td>
                                    <td>
                                        <h5>${invoice.statusId}</h5>
                                    </td>
                                    <td>
                                        <a href="?do=nothing" role="button" class="btn btn-primary pull-center">
                                            DO SOMETHING
                                        </a>
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
                        <c:if test="${requestScope.pageNum < requestScope.lastPage}">
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
                    <h3 class=""><fmt:message key="NAV_MENU_HISTORY"/></h3>
                    <p></p>
                    <div class="btn-toolbar text-center">
                        <a href="/home" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_HOME"/>
                        </a>

                        <a href="/order" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_CREATE"/>
                        </a>

                        <a href="/cabinet" role="button" class="btn btn-primary pull-center">
                            <fmt:message key="NAV_MENU_CABINET"/>
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
