$(document).ready(function(){
    $("#back").click(function(e){
        $.ajax({
            method: "GET",
            url: "/mydashboard",
            success: function(status){
                if(status) {
                    $("body").html(status);
                }
            }
        });

    })
    $("#addanotherteacher").click(function(e){
        $.ajax({
            method: "GET",
            url: "/teacher",
            success: function(status){
                if(status) {
                    $("#add-teacher").html(status);
                }
            }
        });

    })
})
