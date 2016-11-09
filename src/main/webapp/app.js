

function getAppartments() {
    $.ajax({
        url: "testjson", success: function (result) {
            console.log(result.fname);
        }
    });
}