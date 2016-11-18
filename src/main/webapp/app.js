
var selected_id = 0;
var apparts = [];

function addMarkerByAptObject(obj) {
    var marker = new google.maps.Marker({
        map: map,
        position: new google.maps.LatLng(obj.location.lat, obj.location.lng),
        icon : "img/house.png"});


    function openAppartment(obj){
        $("#apt_address").html(obj.address);
        $("#apt_area").html(obj.area + " m²");
        $("#apt_price").html(obj.rent  + " €");
        $("#apt_rooms").html(obj.type);
        console.log(obj.location);
        console.log("sdsdsdsd");
        getEquippement(obj.location);
    }

    marker.addListener('click',function(){
        selected_id = obj.id;
        openAppartment(obj);
    });
}


function getAppartments() {
    $.ajax({
        url: "apt", success: function (result) {
            var apps =  result.apps;
            apparts = apps;
            for (var i in apps) {
                addMarkerByAptObject(apps[i]);
                console.log("[" + i + "] Marker added for: " + apps[i].address);
            }
        }
    });
}

function getEquippement(coord){
        $.ajax({
            url: ("SearchEq?laltitude="+ coord.lat+"&longitude="+ coord.lng), success: function (result) {
                var apps =  result.apps;
                res = "";
                for (var i in result) {
                    res += "<li>"+result[i].type+" : "+result[i].name+" ("+ result[i].distance +")"+"</li>"
                }

                $("#listeEq").html(res);
            }
        });
}

var elements =




function favoriteAppartment(id){
    data = {idapp : id};
    $.post("Favoris", function(data, status){
        console.log("favorited apt:" + id);
    });
}


$("#searchButton").on('click', function(){


});
