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
    $("#editanotherstaff").click(function(e){
    	console.log("sss")
        $.ajax({
            method: "GET",
            url: "/editnonteachingstaff",
            success: function(status){
                if(status) {
                    $("#nonteachingstaff").html(status);
                }
            }
        });

    })
})
