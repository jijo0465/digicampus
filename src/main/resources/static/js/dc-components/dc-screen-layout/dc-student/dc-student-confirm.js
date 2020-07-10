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
    $("#addanotherstudent").click(function(e){
        $.ajax({
            method: "GET",
            url: "/add_student",
            success: function(status){
                if(status) {
                    $("#dc-student-add").html(status);
                }
            }
        });

    })
})
