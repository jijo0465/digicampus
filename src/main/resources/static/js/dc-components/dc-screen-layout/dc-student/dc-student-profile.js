$(document).ready(function(){
    $("#removestudent").click(function(e){
        $.ajax({
            method: "GET",
            url: "/student/delete/"+$("#studentid").val(),
            success: function(status){
                if(status) {
                    $("body").html(status)
                }
            }
        });

    })
})