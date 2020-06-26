$(document).ready(function(){
    $("#teachersearch").click(function(e){
        $.ajax({
            method: "GET",
            url: "/teacher/search/"+$("#keyword_input").val(),
            success: function(status){
                if(status) {
                    $("#dc-searching").html(status)
                }
            }
        });

    })
})