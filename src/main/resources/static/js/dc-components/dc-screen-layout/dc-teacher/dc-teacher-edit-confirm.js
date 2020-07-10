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
    $("#editanotherteacher").click(function(e){
        $.ajax({
            method: "GET",
            url: "/edit/teacher",
            success: function(status){
                if(status) {
                    $("#student").html(status);
                }
            }
        });

    })
})
