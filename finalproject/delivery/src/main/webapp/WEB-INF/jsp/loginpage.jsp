<%@ include file="header.jsp" %>


<c:if test="${sessionScope.user == null}">

    <!-- Login logo -->
    <div class="jumbotron">
        <div class="container">
            <div class="col-xs-4">
                <!--empty-->
            </div>
            <div class="col-xs-4" align="center">
                <img src="../../img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive">
                <c:choose>
                    <c:when test="${requestScope.authorizationError}">
                        <h6><font color="red"><fmt:message key="MSG_WRONG_LOGIN_OR_PASS"/></font></h6>
                    </c:when>
                    <c:otherwise>
                        <h6><font color="red"><br></font></h6>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-xs-4">
                <!--empty-->
            </div>
        </div>
    </div>
    <!-- End Login logo -->

    <!-- Login form -->
    <div class="container thumbs">
        <div class="col-sm-4 col-md-4">
            <div>
                <!--empty-->
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <div align="center">
                <form action="" method="post">
                    <img src="../../img/menu/logicon.png" alt="logicon.png" class="img-responsive">
                    <br>
                    <input type="text" name="login" value="${requestScope.oldInput}" placeholder="enter login"/>
                    <!--img src="../../img/menu/passicon.png" alt="passicon.png" class="img-responsive"-->
                    <br>
                    <br>
                    <input type="password" name="password" placeholder="enter password"/>
                    <br>
                    <input type="image" src="../../img/menu/login_small.png"/>
                </form>
            </div>
        </div>
        <div class="col-sm-4 col-md-4">
            <div>
                <!--empty-->
            </div>
        </div>
    </div>
    <!-- End Login form -->

</c:if>


<%@ include file="footer.jsp" %>