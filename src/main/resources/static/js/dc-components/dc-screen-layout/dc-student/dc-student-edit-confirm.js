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
    $("#editanotherstudent").click(function(e){
        console.log("wekdad")
        $.ajax({
            method: "GET",
            url: "/edit/student",
            success: function(status){
                if(status) {
                    $("#student").html(status);
                }
            }
        });

    })
})
