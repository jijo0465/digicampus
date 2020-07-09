$(document).ready(function(){
	$("#studentsubmit").click(function(e){
			$.ajax({
			method: "GET",
			url: "/edit/student/"+$("#admissionNumber_input").val(),
			success: function(status){
				if(status) {
					$("#dc-edit-body").html(status)
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