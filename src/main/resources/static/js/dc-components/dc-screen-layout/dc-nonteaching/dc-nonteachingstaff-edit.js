$(document).ready(function(){
	$("#nonteachingstaffsubmit").click(function(e){
			$.ajax({
			method: "GET",
			url: "/edit/nonteachingstaff/"+$("#staffid_input").val(),
			success: function(status){
				if(status) {
					console.log(status);
					$("#dc-nonteachingstaff-edit").html(status)
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