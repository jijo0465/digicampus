$(document).ready(function(){
    $("#studentsearch").click(function(e){
        $.ajax({
            method: "GET",
            url: "/student/search/"+$("#keyword_input").val(),
            success: function(status){
                if(status) {
                    $("#dc-search").html(status)
                }
            }
        });

    })
})