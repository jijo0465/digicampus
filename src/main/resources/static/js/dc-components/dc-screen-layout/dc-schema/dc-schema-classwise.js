$(document).ready(function(){
    $('#std').change(function(){
        var tcid=$(this).val();
        $.ajax({
            method: "GET",
            url: "/schema/classwise/"+$("#std").val(),
            success: function(status){
                if(status) {
                    $("#stdbody").html(status)
                }
            }
        });

    })
})