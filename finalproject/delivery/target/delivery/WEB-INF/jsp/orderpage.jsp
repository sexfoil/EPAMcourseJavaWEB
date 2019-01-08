<%@ include file="header.jsp" %>

<datalist id="streetsNamesFromDB">
    <c:forEach var="streetName" items="${sessionScope.streetsList}">
    <option value="${streetName.name}">
        </c:forEach>
</datalist>

<datalist id="cargoTypesFromDB">
    <c:forEach var="cargo" items="${sessionScope.cargoTypes}">
    <option value="${cargo.type}">
        </c:forEach>
</datalist>


<c:if test="${sessionScope.user != null}">
    <!-- Empty block -->
    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-4">
                <!--empty-->
            </div>
            <div class="col-xs-4" align="center">
                <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
                <h6><font color="red">
                    <fmt:message key="NAV_MENU_CREATE"/><br>
                </font></h6>
            </div>
            <div class="col-xs-4">
                <!--empty-->
            </div>
        </div>
    </div>
    <!-- End empty block -->

    <!-- Thumbnails -->
    <div class="container thumbs">
        <div class="col-sm-6 col-md-3">
            <!--empty-->
        </div>
        <div class="col-sm-6 col-md-6">
            <div align="center">
                <form action="" method="post">

                    <table border="1">
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_pass.png" alt="reg_pass.png">
                            </td>
                            <td>
                                <input type="number" min="1" step="1" name="weight"
                                       placeholder="weight" value="${requestScope.oldWeight}" required/>
                                <h5><font color="red">${requestScope.weightError}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                            </td>
                            <td>
                                <input list="streetsNamesFromDB" name="street" placeholder="street"
                                       value="${requestScope.oldStreet.name}" required/>
                                <h5><font color="red">${requestScope.streetError}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                            </td>
                            <td>
                                <input type="datetime-local" name="date" placeholder="street"
                                       value="${requestScope.oldDate}"/>
                                <h5><font color="red">${requestScope.dateError}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="<fmt:message key="NAV_MENU_CREATE"/>"
                                       role="button" class="btn btn-primary pull-center"/>
                            </td>
                        </tr>

                    </table>

                </form>
                <br>
                <br>

                <div class="btn-toolbar text-center">

                    <a href="/info_prices" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="NAV_MENU_PRICES"/>
                    </a>

                    <a href="/info_directions" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="NAV_MENU_DIRECTIONS"/>
                    </a>

                    <a href="/cabinet" role="button" class="btn btn-primary pull-center">
                        <fmt:message key="NAV_MENU_CABINET"/>
                    </a>

                </div>

            </div>
        </div>
        <div class="col-sm-6 col-md-3">
            <!--empty-->
        </div>
    </div>
    <!-- End Thumbnails -->
</c:if>

<%@ include file="footer.jsp" %>

