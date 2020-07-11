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
$(document).ready(function(){
            $("#back").click(function(e){
                $.ajax({
                    method: "GET",
                    url: "/edit/teacher",
                    success: function(status){
                        if(status) {
                            $("body").html(status);
                        }
                    }
                });

            })
        })