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
    $("#addstudenttimetable").click(function(e){
        $.ajax({
            method: "GET",
            url: "/addstudenttimetable",
            success: function(status){
                if(status) {
                    $("#dc-studenttimetable-add").html(status);
                }
            }
        });

    })
})
