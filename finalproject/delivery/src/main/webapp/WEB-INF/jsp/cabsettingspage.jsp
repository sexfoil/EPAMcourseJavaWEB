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
                <a href="/cabinet" role="button" class="btn btn-primary pull-center">
                    BACK TO CABINET <fmt:message key="BODY_BTN_SET"/>
                </a>
            </div>
            <div class="col-xs-4">
                <!--empty-->
            </div>
        </div>
    </div>
    <!-- End empty block -->


    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-3">
                <!--empty-->
            </div>
            <div class="col-xs-6" align="center">

                <form action="" method="post">

                    <table border="1">
                        <!--address-->
                        <thead>
                        <tr align="center">
                            <td>
                                NAME
                            </td>
                            <td width="50%">
                                CURRENT
                            </td>
                            <td>
                                CHANGE
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                CELL NUMBER
                            </td>
                            <td>
                                    ${sessionScope.userData.cellNumber}
                            </td>
                            <td>
                                <input type="text" name="cell" value="${requestScope.oldCell}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                STREET
                            </td>
                            <td>
                                    ${sessionScope.userStreet}
                            </td>
                            <td>
                                <input type="text" name="street" value="${requestScope.oldStreet}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                BUILD.
                            </td>
                            <td>
                                    ${sessionScope.userAddress.building}
                            </td>
                            <td>
                                <input type="text" name="building" value="${requestScope.oldBuilding}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                SECTION
                            </td>
                            <td>
                                    ${sessionScope.userAddress.section}
                            </td>
                            <td>
                                <input type="text" name="section" value="${requestScope.oldSection}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                APART.
                            </td>
                            <td>
                                    ${sessionScope.userAddress.apartment}
                            </td>
                            <td>
                                <input type="text" name="apartment" value="${requestScope.oldApartment}"/>
                            </td>
                        </tr>

                        <!--e-mail-->
                        <tr>
                            <td>
                                E-MAIL
                            </td>
                            <td>
                                    ${sessionScope.user.email}
                            </td>
                            <td>
                                <input type="text" name="email" value="${requestScope.oldEmail}"/>
                                <h5><font color="red">${requestScope.emailError}</font></h5>
                            </td>
                        </tr>

                        <!--password-->
                        <tr>
                            <td>
                                PASSWORD
                            </td>
                            <td>
                                    ${sessionScope.user.password}
                            </td>
                            <td>
                                <input type="password" name="password" placeholder="change password"/>
                                <h5><font color="red">${requestScope.passError}</font></h5>
                                <input type="password" name="password2" placeholder="confirm new password"/>
                                <h5><font color="red">${requestScope.pass2Error}</font></h5>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <input role="button" class="btn btn-primary pull-center" type="submit"
                           value="<fmt:message key="BODY_BTN_SAVE"/>"
                    />

                </form>

            </div>
            <div class="col-xs-3">
                <!--empty-->
            </div>
        </div>
    </div>


</c:if>

<%@ include file="footer.jsp" %>
