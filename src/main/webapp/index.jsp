<% String user=request.getParameter("user"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="js/data.js"></script>
    <title>Cartimmo</title>

    <!-- Bootstrap core CSS -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/unslider.css">
    <!-- Custom styles for this template -->
    <link href="css/starter-template.css" rel="stylesheet">
</head>

<body>

<%@ include file="header.jspf" %>

<div class="container container-full">

    <div class="row">
        <div id="map-container" class="col-md-8">
            <div id="toolbar" class="row">
                <form class="form-inline" onsubmit="return false;">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">Loyer</div>
                            <input type="text" class="form-control" id="inputMinRent" placeholder="Max">
                            <div class="input-group-addon">Ville</div>
                            <input type="text" class="form-control typeahead" id="inputCity" placeholder="ex. Paris" data-provide="typeahead">
                        </div>
                    </div>
                    <button id="searchButton" class="btn btn-primary">Voir les annonces</button>
                </form>
            </div>

            <div id="map"></div>
        </div>

        <div id="listing-container" class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Paris / IDF</h3>
                </div>
                <div class="panel-body">

                    <!-- ADDRESS + PRICE -->
                    <div class="row">
                        <div id="apt_address" class="col-md-8">389 N Adams Avenue</div>
                        <div id="apt_price" class="col-md-4">800 £</div>
                    </div>

                    <!-- PHOTOS
                    <div class="row photos">
                        <ul><li>This is my slider.</li><li>Pretty cool, huh?</li></ul>
                    </div>-->
                    <div class="row" style="text-align: center">
                    <img src="img/no-picture.gif" />
                    </div>
                    <!-- SPECS-->
                    <div class="row">
                        <div id="apt_rooms" class="col-md-4">2 Chambres</div>
                        <div id="apt_area" class="col-md-4">65 m²</div>
                        <div class="col-md-4"><button id="addFavorisButton" class="btn btn-primary"><span class="glyphicon glyphicon-star" aria-hidden="true"></span></button></div>
                    </div>

                    <!-- Equipements -->
                    <div class="row">
                        <div class="col-md-12"><h4>Equipements</h4>
                            <ul id="listeEq"></ul>
                        </div>

                    </div>
                    <!-- Contact -->
                    <div class="row">
                    <div class="col-md-12">
                    <h4>Contacter le bailleur</h4>
                    <form class="form">
                    	<textarea id="message" style="display: block; margin-bottom:10px; width: 100%; min-height: 100px">Bonjour,
                    	
J'aimerais prendre rendez-vous pour le visiter.

Cordialement.</textarea>
                    	<button class="btn btn-primary">Envoyer</button>
                    </form>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEJXY0rT2TT2ZR8IdYAhuEvj18DJahQ50&callback=initMap"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js" integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY" crossorigin="anonymous"></script>
<script src="js/unslider-min.js"></script>
<script src="app.js"></script>
<script src="maps.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js" integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/typeahead.min.js"></script>
<script>
    jQuery(document).ready(function($) {
        $('.photos').unslider();
    });

    $('.typeahead').typeahead({source : villes});
</script>
</body>
</html>
