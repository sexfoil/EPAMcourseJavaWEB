<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" %>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="${sessionScope.bundle}" />

<!DOCTYPE html>
<html>
<head>
    <title>Delivery Service (EPAM JavaWEB course final project by Slava Poliakov)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="../../img/favicon.png" type="image/png">

    <!-- Bootstrap -->
    <link href="../../css/bootstrap.css" rel="stylesheet">

    <!--Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Belgrano|Courgette&subset=latin,latin-ext' rel='stylesheet'
          type='text/css'>


    <!--Bootshape-->
    <link href="../../css/bootshape.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Navigation bar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home"><fmt:message key="NAV_NAME" /></a>
        </div>
        <nav role="navigation" class="collapse navbar-collapse navbar-right">
            <ul class="navbar-nav nav">

                <!-- language -->
                <li class="dropdown">
                    <a data-toggle="dropdown" href="" class="dropdown-toggle">
                        <c:if test="${sessionScope.activeLang == 0}">
                            <fmt:message key="ENG" />
                        </c:if>
                        <c:if test="${sessionScope.activeLang == 1}">
                            <fmt:message key="UKR" />
                        </c:if>
                        <c:if test="${sessionScope.activeLang == 2}">
                            <fmt:message key="RUS" />
                        </c:if>
                        <b class="caret"></b>
                    </a>

                    <ul class="dropdown-menu">
                        <c:if test="${sessionScope.activeLang != 0}">
                            <li>
                                <a href="?lang=0">
                                    <fmt:message key="ENG" />
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.activeLang != 1}">
                            <li>
                                <a href="?lang=1">
                                    <fmt:message key="UKR" />
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.activeLang != 2}">
                            <li>
                                <a href="?lang=2">
                                    <fmt:message key="RUS" />
                                </a>
                            </li>
                        </c:if>
                    </ul>

                </li>
                <!-- end language -->


                <li class="dropdown">
                    <a data-toggle="dropdown" href="" class="dropdown-toggle">
                        <fmt:message key="NAV_MENU_INFO" />
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="/info_prices">
                                <fmt:message key="NAV_MENU_PRICES" />
                            </a>
                        </li>
                        <li>
                            <a href="/info_directions">
                                <fmt:message key="NAV_MENU_DIRECTIONS" />
                            </a>
                        </li>
                        <li class="divider">
                            <!-- empty -->
                        </li>
                        <li>
                            <a href="/calculator">
                                <fmt:message key="NAV_MENU_CALCULATOR" />
                            </a>
                        </li>
                    </ul>
                </li>

                <c:choose>
                    <c:when test="${sessionScope.user != null}">

                        <li class="dropdown">
                            <a data-toggle="dropdown" href="" class="dropdown-toggle">
                                <strong>
                                    ${sessionScope.user.login}
                                    <c:if test="${sessionScope.activeInvoiceAmount > 0}">
                                        (${sessionScope.activeInvoiceAmount})
                                    </c:if>
                                </strong>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="active">
                                    <a href="/home">
                                        <fmt:message key="NAV_MENU_HOME" />
                                    </a>
                                </li>
                                <li>
                                    <a href="/cabinet">
                                        <fmt:message key="NAV_MENU_CABINET" />
                                    </a>
                                </li>

                                <li class="divider"><!-- DIVIDER --></li>

                                <li>
                                    <a href="/home?logout=true">
                                        <fmt:message key="NAV_MENU_LOG_OUT" />
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </c:when>
                    <c:otherwise>

                        <li class="dropdown">
                            <a data-toggle="dropdown" href="" class="dropdown-toggle">
                                <fmt:message key="NAV_MENU_USER" />
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="active">
                                    <a href="/home">
                                        <fmt:message key="NAV_MENU_HOME" />
                                    </a>
                                </li>
                                <li>
                                    <a href="/registration">
                                        <fmt:message key="NAV_MENU_REGISTER" />
                                    </a>
                                </li>

                                <li class="divider"><!-- DIVIDER --></li>

                                <li>
                                    <a href="/login">
                                        <fmt:message key="NAV_MENU_LOG_IN" />
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </div>
</div>
<!-- End Navigation bar -->
