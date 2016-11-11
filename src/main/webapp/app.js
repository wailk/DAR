

var samples = [
    {
        area: 20,
        address: "1 IMPASSE SAINT FRANCOIS",
        furnished: true,
        user_id: 1,
        location: { },
        rent: 772,
        type: "F2"
    },
    {
        area: 940,
        address: "10 RUE COUSTOU",
        furnished: true,
        user_id: 1,
        location: { },
        rent: 363,
        type: "F5"
    },
    {
        area: 513,
        address: "10 RUE DU FAUBOURG SAINT DENIS ",
        furnished: false,
        user_id: 3,
        location: { },
        rent: 659,
        type: "F2"
    },
    {
        area: 680,
        address: "10 RUE GODEFROY CAVAIGNAC",
        furnished: true,
        user_id: 4,
        location: { },
        rent: 146,
        type: "F2"
    },
    {
        area: 880,
        address: "10 RUE JOSEPH DIJON",
        furnished: false,
        user_id: 2,
        location: { },
        rent: 687,
        type: "F3"
    }]
    ;








function getRandomInRange(from, to, fixed) {
    return (Math.random() * (to - from) + from).toFixed(fixed) * 1;
    // .toFixed() returns string, so ' * 1' is a trick to convert to number
}


function addMarkerByAddress(address) {
    geocoder.geocode({'address': address}, function (results, status) {
        if (status == 'OK') {
            //map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}

function getAppartments() {
    $.ajax({
        url: "apt", success: function (result) {

            for (var i in result) {
                addMarkerByAddress(result[i].address + "");
                console.log("[" + i + "] Marker added for: " + result[i].address);
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


function timeout() {
    setTimeout(function () {
        // Do Something Here
        // Then recall the parent function to
        // create a recursive loop.
        timeout();
    }, 1000);
}

