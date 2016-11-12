var map;
var geocoder;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: new google.maps.LatLng(48.8566, 2.3522),
        mapTypeId: 'roadmap',
        disableDefaultUI: true
    });
    
    geocoder = new google.maps.Geocoder();



    var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
    var icons = {
        parking: {
            icon: iconBase + 'parking_lot_maps.png'
        },
        library: {
            icon: iconBase + 'library_maps.png'
        },
        info: {
            icon: iconBase + 'info-i_maps.png'
        }
    };

    function addMarker(feature) {
        var marker = new google.maps.Marker({
            position: feature.position,
            icon: icons[feature.type].icon,
            map: map
        });
    }


    getAppartments();
}