<%@ include file="header.jsp" %>

<datalist id="streetsNamesFromDB">
    <c:forEach var="street" items="${sessionScope.streetsList}">
    <option value="${street.name}">
        </c:forEach>
</datalist>

<datalist id="cargoTypesFromDB">
    <c:forEach var="cargo" items="${sessionScope.cargoTypes}">
    <option value="${cargo.type}">
        </c:forEach>
</datalist>


<!-- Calculator block -->
<div class="jumbotron">
    <div class="container">
        <div class="col-xs-3">
            <!--empty-->
        </div>
        <div class="col-xs-6" align="center">
            <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
            <h6><font color="orange">

                <form action="" method="post">

                    <table border="1">
                        <tr>
                            <td colspan="2" align="center">
                                <h4>
                                    <c:if test="${sessionScope.calculatedCargo != null}">
                                        <fmt:message key="${sessionScope.calculatedCargo}"/><br>
                                        $ <fmt:formatNumber type="number" value="${sessionScope.calculatedCost}"/>
                                    </c:if>
                                </h4>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_pass.png" alt="reg_pass.png">
                            </td>
                            <td>
                                <input type="number" min="1" step="1" name="weight"
                                       placeholder="weight" value="${sessionScope.oldWeight}" required/>
                                <h5><font color="red">${sessionScope.weightError}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                            </td>
                            <td>
                                <input list="streetsNamesFromDB" name="street" placeholder="street"
                                       value="${sessionScope.oldStreet.name}" required/>
                                <h5><font color="red">${sessionScope.streetError}</font></h5>
                            </td>
                        </tr>
                        <!--tr>
                            <td>
                                <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                            </td>
                            <td>
                                <input type="datetime-local" name="date" placeholder="street"
                                        value="${requestScope.oldDate}"/>
                                <h5><font color="red">${requestScope.dateError}</font></h5>
                            </td>
                        </tr-->
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="<fmt:message key="BODY_BTN_COMPUTE"/>"
                                       role="button" class="btn btn-primary pull-center"/>
                            </td>
                        </tr>

                    </table>

                </form>

            </font></h6>

        </div>
        <div class="col-xs-3">
            <!--empty-->
        </div>
    </div>
</div>
<!-- End Calculator block -->


<!-- Thumbnails -->
<div class="container thumbs">
    <div class="col-sm-3 col-md-3">
        <!--empty-->
    </div>

    <div class="col-sm-6 col-md-6">
        <div class="thumbnail">
            <!--img src="../../img/menu/directions.png" alt="directions.png" class="img-responsive"-->
            <div class="caption" align="center">
                <h3 class=""><fmt:message key="NAV_MENU_CALCULATOR"/></h3>
                <p></p>
                <div class="btn-toolbar text-center">
                    <a href="/home" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="NAV_MENU_HOME"/>
                    </a>

                    <a href="/info_prices" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="NAV_MENU_PRICES"/>
                    </a>

                    <a href="/info_directions" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="NAV_MENU_DIRECTIONS"/>
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


<%@ include file="footer.jsp" %>

