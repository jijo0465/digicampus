$(document).ready(function(){
    $("#teacherupdate").click(function(e){
        $.ajax({
            method: "POST",
            url: "/updateteacher",
            data: $('#updateteacherform').serialize(),
            success: function(status){
                if(status) {
                    console.log(status);
                    $("#formBody").html(status)
                }
            }
        });

    })
})