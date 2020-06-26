function myFunction(){
    var keyword = document.getElementById("search").value;
    $.ajax({
        method: "GET",
        url: "/student/search/"+keyword,
        success: function(status){
            if(status) {
                $("#dc-search").html(status)
            }
        }
    });

}