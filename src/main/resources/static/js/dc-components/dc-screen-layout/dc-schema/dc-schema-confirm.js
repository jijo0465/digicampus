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
    $("#addanotherschema").click(function(e){
        console.log("wekdad")
        $.ajax({
            method: "GET",
            url: "/addschemas",
            success: function(status){
                if(status) {
                    $("#dc-schema-add").html(status);
                }
            }
        });

    })
})
