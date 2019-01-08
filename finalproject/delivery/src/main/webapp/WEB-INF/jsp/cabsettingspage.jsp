<%@ include file="header.jsp" %>

<datalist id="streetsNamesFromDB">
    <c:forEach var="street" items="${sessionScope.streetsList}">
    <option value="${street.name}">
        </c:forEach>
</datalist>


<c:if test="${sessionScope.user != null}">


    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-3">
                <!--empty-->
            </div>
            <div class="col-xs-6" align="center">

                <!--img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive"-->
                <a href="/cabinet" role="button" class="btn btn-primary pull-center">
                    BACK TO CABINET <fmt:message key="BODY_BTN_SET"/>
                </a>

                <h4>
                    <font color="orange">
                        <form action="" method="post">

                            <table border="1" width="100%">
                                <!--address-->
                                <thead>

                                <tr align="center">
                                    <td colspan="3">
                                        USER DATA
                                    </td>
                                </tr>

                                </thead>
                                <tbody align="center">
                                <tr>
                                    <td>
                                        USER
                                    </td>
                                    <td colspan="2">
                                            ${sessionScope.user.firstName} ${sessionScope.user.lastName}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        E-mail
                                    </td>
                                    <td colspan="2">
                                            ${sessionScope.user.email}
                                    </td>
                                </tr>


                                <tr>
                                    <td>
                                        PHONE
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
                                        <input list="streetsNamesFromDB" name="street"
                                               value="${requestScope.oldStreet}"/>
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
                                </tbody>
                            </table>

                            <input role="button" class="btn btn-primary pull-center" type="submit"
                                   value="<fmt:message key="BODY_BTN_SAVE"/>"
                            />

                        </form>
                    </font>
                </h4>
            </div>
            <div class="col-xs-3">
                <!--empty-->
            </div>
        </div>
    </div>


</c:if>

<%@ include file="footer.jsp" %>
