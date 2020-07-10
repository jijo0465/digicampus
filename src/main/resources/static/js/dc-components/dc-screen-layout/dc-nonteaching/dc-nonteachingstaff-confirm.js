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
    $("#addanotherstaff").click(function(e){
        console.log("wekdad")
        $.ajax({
            method: "GET",
            url: "/addnonteaching",
            success: function(status){
                if(status) {
                    $("#dc-nonteachingstaff-add").html(status);
                }
            }
        });

    })
})
