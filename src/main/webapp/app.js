
function getRandomInRange(from, to, fixed) {
    return (Math.random() * (to - from) + from).toFixed(fixed) * 1;
    // .toFixed() returns string, so ' * 1' is a trick to convert to number
}


function addMarkerByAptObject(obj) {
    var marker = new google.maps.Marker({
        map: map,
        position: new google.maps.LatLng(obj.location.lat, obj.location.lng),
        icon : "img/house.png"});

    marker.addListener('click',function(){
        $("#apt_address").html(obj.address);
        $("#apt_area").html(obj.area + " m²");
        $("#apt_price").html(obj.rent  + " €");
        $("#apt_rooms").html(obj.type);
    });
}


function getAppartments() {
    $.ajax({
        url: "apt", success: function (result) {
            var apps =  result.apps;
            for (var i in apps) {
                addMarkerByAptObject(apps[i]);
                console.log("[" + i + "] Marker added for: " + apps[i].address);
            }
        }
    });
}

function randomMarkers() {
    for (var i = 0; i < 500; i++) {
        var marker = new google.maps.Marker({
            map: map,
            position: new google.maps.LatLng(getRandomInRange(-180, 180, 3), getRandomInRange(-180, 180, 3))
        });
    }
}

function addCard() {
    var infowindow = new google.maps.InfoWindow({
        content: '<div id="content">' +
        '<div id="siteNotice">' +
        '</div>' +
        '<h1 id="firstHeading" class="firstHeading">Uluru</h1>' +
        '<div id="bodyContent">' +
        '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
        'sandstone rock formation in the southern part of the ' +
        'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) ' +
        'south west of the nearest large town, Alice Springs; 450&#160;km ' +
        '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major ' +
        'features of the Uluru - Kata Tjuta National Park. Uluru is ' +
        'sacred to the Pitjantjatjara and Yankunytjatjara, the ' +
        'Aboriginal people of the area. It has many springs, waterholes, ' +
        'rock caves and ancient paintings. Uluru is listed as a World ' +
        'Heritage Site.</p>' +
        '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">' +
        'https://en.wikipedia.org/w/index.php?title=Uluru</a> ' +
        '(last visited June 22, 2009).</p>' +
        '</div>' +
        '</div>'
    });
}


function openAppartment(obj){
    $("#apt_address").html(obj.address);
    $("#apt_area").html(obj.area + " m²");
    $("#apt_price").html(obj.rent  + " €");
    $("#apt_rooms").html(obj.type);
}


function favoriteAppartment(id){
    data = {idapp : id};
    $.post("Favoris", function(data, status){
        console.log("favorited apt:" + id);
    });
}