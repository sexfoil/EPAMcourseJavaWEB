<%@ include file="header.jsp" %>

<datalist id="streetsNamesFromDB" >
    <c:forEach var="streetName" items="${requestScope.streetsList}">
        <option value="${streetName}">
    </c:forEach>
</datalist>

<!-- Empty block -->
<div class="jumbotron">
    <div class="container">
        <div class="col-xs-4">
            <!--empty-->
        </div>
        <div class="col-xs-4" align="center">
            <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
            <h6><font color="red">
                <fmt:message key="NAV_MENU_CALCULATOR"/><br>
                TYPE: ${requestScope.type}<br>
                DIRECTION: ${requestScope.direction}<br>
                DISTANCE: ${requestScope.distance}<br>
                DATE: ${requestScope.date}<br>
                COST: ${requestScope.cost} $<br>

            </font></h6>
        </div>
        <div class="col-xs-4">
            <!--empty-->
        </div>
    </div>
</div>
<!-- End empty block -->

<!-- End Thumbnails -->
<div class="container thumbs">
    <div class="col-sm-6 col-md-3">
        <!--empty-->
    </div>
    <div class="col-sm-6 col-md-6">
        <div align="center">
            <form action="" method="post">

                <input type="submit" value="<fmt:message key="BODY_BTN_COMPUTE"/>"
                       role="button" class="btn btn-primary pull-center"/>
                <br>
                <br>

                <table border="1">
                    <tr>
                        <td>
                            <img src="../../img/menu/reg_name.png" alt="reg_name.png">
                        </td>
                        <td>
                            <input type="text" name="cargoType" value="${requestScope.prevFirstName}"
                                   placeholder="type"/><br>
                            <h5><font color="red">${requestScope.nameError}</font></h5>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="../../img/menu/reg_pass.png" alt="reg_pass.png">
                        </td>
                        <td>
                            <input type="number" step="0.001" name="weight" placeholder="weight"/>
                            <h5><font color="red">${requestScope.passError}</font></h5>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                        </td>
                        <td>
                            <input list="streetsNamesFromDB" name="street" placeholder="street"/>
                            <h5><font color="red">${requestScope.passError}</font></h5>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                        </td>
                        <td>
                            <input type="date" name="date" value="${requestScope.prevEmail}" placeholder="street"/>
                            <h5><font color="red">${requestScope.emailError}</font></h5>
                        </td>
                    </tr>
                </table>

            </form>

            <br>
            <br>

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
    <div class="col-sm-6 col-md-3">
        <!--empty-->
    </div>
</div>
<!-- End Thumbnails -->


<%@ include file="footer.jsp" %>

