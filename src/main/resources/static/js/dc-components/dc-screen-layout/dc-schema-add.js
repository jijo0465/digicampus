$(document).ready(function(){
    $("#schemasubmit").click(function(e){
        $.ajax({
            method: "POST",
            url: "/saveschema",
            data: $('#addschema').serialize(),
            success: function(status){
                if(status) {
                    $("#dc-schema-add").html(status)
                }
            }
        });

    })
})