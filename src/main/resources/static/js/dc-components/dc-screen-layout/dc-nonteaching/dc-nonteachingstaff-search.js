function myFunction(){
    var keyword = document.getElementById("search").value;
    if(keyword!== "" && keyword !== undefined) {
        $.ajax({
            method: "GET",
            url: "/nonteachingstaff/search/" + keyword,
            success: function (status) {
                if (status) {
                    $("#dc-search").html(status)
                }
            }
        });
    }

}