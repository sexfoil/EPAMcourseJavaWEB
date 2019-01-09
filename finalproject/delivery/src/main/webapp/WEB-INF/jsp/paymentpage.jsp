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

                    <c:if test="${requestScope.invoice != null}">

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
                                <td width="30%">
                                    DATE
                                </td>
                                <td width="20%">
                                    STATUS
                                </td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr align="center">
                                <td>
                                    <h5>${requestScope.invoice.id}</h5>
                                </td>
                                <td>
                                    <c:forEach var="entry" items="${requestScope.cargoes}">
                                        <c:if test="${entry.key == invoice.cargoId}">
                                            <c:forEach var="type" items="${sessionScope.cargoTypes}">
                                                <c:if test="${entry.value.weight <= type.maxWeight
                                                     && entry.value.weight >= type.minWeight}">
                                                        <h5>${type.type}</h5>
                                                </c:if>
                                            </c:forEach>

                                                        <h5>(${entry.value.weight / 1000} kg)</h5>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <h5>${requestScope.invoice.cost*0.01}</h5>
                                </td>
                                <td>
                                    <h5>${requestScope.invoice.dateTime}</h5>
                                </td>
                                <td>
                                    <c:forEach var="status" items="${sessionScope.deliveryStatuses}">
                                        <c:if test="${status.id == requestScope.invoice.statusId}">
                                            <h5>${status.statusName}</h5>
                                        </c:if>
                                    </c:forEach>
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
                        <form action="" method="post">
                            <input type="hidden" name="payment" value="${requestScope.invoice.id}"/>
                            <input role="button" class="btn btn-primary pull-center" type="submit"
                                    value="<fmt:message key="BODY_BTN_PAY"/>"
                            />
                        </form>
                        <br>
                        <br>
                        <a href="/cabinet_history" role="button" class="btn btn-primary pull-center">
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
