$(document).ready(function(){
    $("#nonteachingstaffupdate").click(function(e){
        $.ajax({
            method: "POST",
            url: "/updatenonteachingstaff",
            data: $('#updatenonteachingform').serialize(),
            success: function(status){
                if(status) {
                    console.log(status);
                    $("#updatenonteachingstaffbody").html(status)
                }
            }
        });

    })
})