function myFunction(){
    var keyword = document.getElementById("search").value;
    if(keyword!== "" && keyword !== undefined) {
        $.ajax({
            method: "GET",
            url: "/student/search/" + keyword,
            success: function (status) {
                if (status) {
                    $("#dc-search").html(status)
                }
            }
        });
    }
    else{
        $.ajax({
            method: "GET",
            url: "/student/search/null",
            success: function (status) {
                if (status) {
                    $("#dc-search").html(status)
                }
            }
        });

    }
}