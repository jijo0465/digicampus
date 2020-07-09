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
        console.log("wekdad")
        $.ajax({
            method: "GET",
            url: "/teacher",
            success: function(status){
                if(status) {
                    $("#dc-teacher-add").html(status);
                }
            }
        });

    })
})
