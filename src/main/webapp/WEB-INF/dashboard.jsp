<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formatting (dates) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- form:form -->
<%@ page isErrorPage="true"%>
<!-- for rendering errors on PUT routes -->



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- //// CSS LINKS //////////////////////////////////////// -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Login and Registration</title>
</head>
<body>
<!-- //// HEADER /////////////////////////////////////////// -->
<header>
    <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
            <a href="/" class="col-8 navbar-brand"> <strong
                    class="text-warning">LOGIN AND REGISTRATION</strong>
            </a>
            <div class="col-4 row align-items-center">
                <p class="col text-white m-2">${ loggedInUser.userName }</p>
                <button class="col btn btn-info btn-sm round m-2" onclick="window.location.href='/dashboard';">Home</button>
                <button class="col btn btn-danger btn-sm round" onclick="window.location.href='/logout';">Log-Out</button>
            </div>
        </div>
    </div>
</header>

<!-- //// MAIN AREA //////////////////////////////////////// -->
<main role="main">
    <div class="container mt-4">
        <div class="row">
            <h1>Welcome to Dashboard ${ loggedInUser.userName }</h1>
        </div>
    </div>
</main>

<!-- //// JAVASCRIPT LINKS ///////////////////////////////// -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>