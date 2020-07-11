$(document).ready(function(){
    $("#nonteachingstaffupdate").click(function(e){
        $.ajax({
            method: "POST",
            url: "/updatenonteachingstaff",
            data: $('#updatenonteachingform').serialize(),
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
                    url: "/editnonteachingstaff",
                    success: function(status){
                        if(status) {
                            $("body").html(status);
                        }
                    }
                });

            })
        })