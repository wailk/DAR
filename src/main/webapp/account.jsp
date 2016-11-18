<!DOCTYPE html>
<%@page import="dar.services.ViewServices"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Account</title>
    <link href="css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%@ include file="header.jspf" %>

<div class="container">
    <h2>My Account</h2>
    <div class="row">
        <div id="myListings" class="col-md-6">
            <h4>My Listings</h4>
            <ul>
            <%= ViewServices.getAppartmentBySession(session) %>
            </ul>
        </div>
        <div id="myFavorites" class="col-md-6">
            <h4>My Favorites</h4>
            <ul>
            <%= ViewServices.getFavorisBySession(session) %>
            </ul>
        </div>
    </div>
</div>

<script src="js/bootstrap.min.js"></script>
</body>
</html>