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
                SETTINGS
            </div>
            <div class="col-xs-4">
                <!--empty-->
            </div>
        </div>
    </div>
    <!-- End empty block -->


    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-1">
                <!--empty-->
            </div>
            <div class="col-xs-10" align="center">

                <form action="" method="post">

                    <table border="0">
                        <!--address-->
                        <tr>
                            <th>

                            </th>
                            <th width="50%">

                            </th>
                            <th>

                            </th>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_name.png" alt="reg_name.png">
                            </td>
                            <td>
                                    ${sessionScope.user.userData.address}
                            </td>
                            <td>
                                <input type="text" name="street" value="${requestScope.st}"
                                       placeholder="change street"/><br>
                                <input type="text" name="building" value="${requestScope.bi}"
                                       placeholder="change building"/><br>
                                <input type="text" name="section" value="${requestScope.se}"
                                       placeholder="change section"/><br>
                                <input type="text" name="apartment" value="${requestScope.ap}"
                                       placeholder="change apartment"/><br>
                                <h5><font color="red">${requestScope.userError}</font></h5>
                            </td>
                        </tr>

                        <!--e-mail-->
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                            </td>
                            <td>
                                    ${sessionScope.user.firstName}
                            </td>
                            <td>
                                <input type="text" name="email" value="${requestScope.prevEmail}"
                                       placeholder="change e-mail"/>
                                <h5><font color="red">${requestScope.emailError}</font></h5>
                            </td>
                        </tr>

                        <!--password-->
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_pass.png" alt="reg_pass.png">
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

                    </table>

                    <input role="button" class="btn btn-primary pull-center"
                           type="submit" value="<fmt:message key="BODY_BTN_SET"/> CHANGES"/>

                </form>

            </div>
            <div class="col-xs-1">
                <!--empty-->
            </div>
        </div>
    </div>


</c:if>

<%@ include file="footer.jsp" %>
