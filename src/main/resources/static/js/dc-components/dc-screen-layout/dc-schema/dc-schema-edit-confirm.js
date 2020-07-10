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
    $("#editanotherschema").click(function(e){
        $.ajax({
            method: "GET",
            url: "/schema/edit/"+schemaid",
            success: function(status){
                if(status) {
                    $("#dc-schema-body").html(status);
                }
            }
        });

    })
})
