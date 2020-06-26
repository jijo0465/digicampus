function myFunction(){
    var keyword = document.getElementById("searching").value;
    $.ajax({
        method: "GET",
        url: "/teacher/search/"+keyword,
        success: function(status){
            if(status) {
                $("#dc-search").html(status)
            }
        }
    });

}