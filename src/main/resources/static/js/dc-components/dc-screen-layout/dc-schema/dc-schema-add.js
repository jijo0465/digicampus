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
        })