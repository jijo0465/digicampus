$(document).ready(function(){
    $("#removestudent").click(function(e){
        $.ajax({
            method: "GET",
            url: "/nonteachingstaff/delet/"+$("#id").val(),
            success: function(status){
                if(status) {
                    $("body").html(status)
                }
            }
        });

    })
})