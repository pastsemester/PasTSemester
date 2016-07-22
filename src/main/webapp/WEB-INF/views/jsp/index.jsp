<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Pastsemester</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet" />

    <link href='http://fonts.googleapis.com/css?family=Abel|Open+Sans:400,600' rel='stylesheet'>

    <style>

        body {
            padding-top: 20px;
            font-size: 16px;
            font-family: "Open Sans",serif;
        }

        h1 {
            font-family: "Abel", Arial, sans-serif;
            font-weight: 400;
            font-size: 40px;
        }

        .margin-base-vertical {
            margin: 40px 0;
        }

    </style>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="margin-base-vertical">Welcome to pastsemester.com!</h1>

            <p>
                We provide services for finding and reviewing classes, textbooks, professors - you know, the crucial information students need to survive!
            </p>
            <p>
                We are currently working on updating our website. You can sign up with your email to follow our progress.
            </p>


            <form class="margin-base-vertical">
                <p class="input-group">
                    <span class="input-group-addon"><span class="icon-envelope"></span></span>
                    <input type="text" class="form-control input-lg" name="email" placeholder="jonsnow@knowsnothi.ng" />
                </p>
                <p class="help-block text-center"><small>We won't send you spam. Unsubscribe at any time.</small></p>
                <h1>${title}</h1>
                <p>
                    <c:if test="${not empty msg}">
                    Hello ${msg}
                    </c:if>
                <p class="text-center">
                    <button type="submit" class="btn btn-success btn-lg">Keep me posted</button>
                </p>
                </span>
            </form>
        </div>
    </div>
</div>

</body>

<%--<head>--%>
    <%--<title>PasTSemester</title>--%>

    <%--<spring:url value="/resources/core/css/hello.css" var="coreCss"/>--%>
    <%--<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>--%>
    <%--<link href="${bootstrapCss}" rel="stylesheet"/>--%>
    <%--<link href="${coreCss}" rel="stylesheet"/>--%>
<%--</head>--%>

<%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
    <%--<div class="container">--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="#">Project Name</a>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>

<%--<div class="jumbotron">--%>
    <%--<div class="container">--%>
        <%--<h1>${title}</h1>--%>
        <%--<p>--%>
            <%--<c:if test="${not empty msg}">--%>
            <%--Hello ${msg}--%>
            <%--</c:if>--%>

            <%--<c:if test="${empty msg}">--%>
            <%--Welcome Welcome!--%>
            <%--</c:if>--%>
        <%--<p>--%>
            <%--<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>--%>
        <%--</p>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<div class="container">--%>

    <%--<div class="row">--%>
        <%--<div class="col-md-4">--%>
            <%--<h2>Heading</h2>--%>
            <%--<p>ABC</p>--%>
            <%--<p>--%>
                <%--<a class="btn btn-default" href="#" role="button">View details</a>--%>
            <%--</p>--%>
        <%--</div>--%>
        <%--<div class="col-md-4">--%>
            <%--<h2>Heading</h2>--%>
            <%--<p>ABC</p>--%>
            <%--<p>--%>
                <%--<a class="btn btn-default" href="#" role="button">View details</a>--%>
            <%--</p>--%>
        <%--</div>--%>
        <%--<div class="col-md-4">--%>
            <%--<h2>Heading</h2>--%>
            <%--<p>ABC</p>--%>
            <%--<p>--%>
                <%--<a class="btn btn-default" href="#" role="button">View details</a>--%>
            <%--</p>--%>
        <%--</div>--%>
    <%--</div>--%>


    <%--<hr>--%>
    <%--<footer>--%>
        <%--<p>&copy; Mkyong.com 2015</p>--%>
    <%--</footer>--%>
<%--</div>--%>

<%--<spring:url value="/resources/core/css/hello.js" var="coreJs"/>--%>
<%--<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs"/>--%>

<%--<script src="${coreJs}"></script>--%>
<%--<script src="${bootstrapJs}"></script>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>

<%--</body>--%>
</html>