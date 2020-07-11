$(document).ready(function(){
	$("#studentupdate").click(function(e){
			$.ajax({
			method: "POST",
			url: "/updatestudent",
			 data: $('#updatestudform').serialize(),
			success: function(status){
				if(status) {
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
                    url: "/edit/student",
                    success: function(status){
                        if(status) {
                            $("body").html(status);
                        }
                    }
                });

            })
        })