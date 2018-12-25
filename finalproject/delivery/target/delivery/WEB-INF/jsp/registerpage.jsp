<%@ include file="header.jsp" %>

<!-- Register header -->
<div class="jumbotron">
    <div class="container">
        <div class="col-xs-5">
            <!--<img src="img/menu/loginbutton.jpg" alt="buy" class="img-responsive">-->
        </div>
        <div class="col-xs-2" align="center">
            <img src="../../img/menu/registration.png" alt="register.png" class="img-responsive">
            <br>
            <h3> <font color="red">${requestScope.registerError}</font></h3>
        </div>
        <div class="col-xs-5">
            <!--<img src="img/menu/loginbutton.jpg" alt="buy" class="img-responsive">-->
        </div>
    </div>
</div>
<!-- End Register header -->


<!-- Register form -->
<div class="container thumbs">
    <div class="col-sm-1 col-md-1">
        <div>
            <!--empty-->
        </div>
    </div>
    <div class="col-sm-10 col-md-10">
        <div align="center">

            <c:if test="${sessionScope.user == null}">

                <form action="" method="post" >

                    <table border="0">
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_name.png" alt="reg_name.png">
                            </td>
                            <td>
                                <input type="text" name="firstName" value="${requestScope.prevFirstName}" placeholder="first name"/><br>
                                <input type="text" name="lastName" value="${requestScope.prevLastName}" placeholder="last name"/><br>
                                <h5><font color="red">${requestScope.nameError}</font></h5>
                            </td>
                            <td>
                                <img src="../../img/menu/reg_login.png" alt="reg_login.png" class="img-responsive">
                            </td>
                            <td>
                                <input type="text" name="login" value="${requestScope.prevLogin}" placeholder="login"/>
                                <h5><font color="red">${requestScope.loginError}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_pass.png" alt="reg_pass.png">
                            </td>
                            <td>
                                <input type="password" name="password" placeholder="password"/>
                                <h5><font color="red">${requestScope.passError}</font></h5>

                            </td>
                            <td>
                                <img src="../../img/menu/reg_pass_confirm.png" alt="reg_pass_confirm.png">
                            </td>
                            <td>
                                <input type="password" name="password2" placeholder="confirm password"/>
                                <h5><font color="red">${requestScope.pass2Error}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_email.png" alt="reg_email.png">
                            </td>
                            <td>
                                <input type="text" name="email" value="${requestScope.prevEmail}" placeholder="your@mail.com"/>
                                <h5><font color="red">${requestScope.emailError}</font></h5>
                            </td>
                            <td>
                                <img src="../../img/menu/reg_age.png" alt="reg_age.png">
                            </td>
                            <td>
                                <input type="number" name="age" min="1" value="${requestScope.prevAge}" placeholder="age" required/>
                                <h5><font color="red">${requestScope.ageError}</font></h5>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../../img/menu/reg_sex.png" alt="reg_sex.png" class="img-responsive">
                            </td>
                            <td>
                                <input type="radio" name="sex" value="f" checked/> Female<br>
                                <input type="radio" name="sex" value="m"/> Male &emsp;<br>
                                <h5><font color="red">${requestScope.sexError}</font></h5>
                            </td>
                            <td>
                                <img src="../../img/menu/reg_agree.png" alt="reg_agree.png" class="img-responsive">
                            </td>
                            <td>
                                <input type="hidden" name="agree"/>
                                <input type="checkbox" name="agree" value="yes"/>&emsp; I agree!<br>
                                <h5><font color="red">${requestScope.agreeError}</font></h5>
                            </td>
                        </tr>
                    </table>

                    <input type="image" src="../../img/menu/signup.png"/>

                </form>
            </c:if>

        </div>
    </div>
    <div class="col-sm-1 col-md-1">
        <div>
            <!--empty-->
        </div>
    </div>
</div>
<!-- End Register form -->


<%@ include file="footer.jsp" %>