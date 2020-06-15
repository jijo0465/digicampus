
        $(document).ready(function(){
            $("#studentsubmit").click(function(e){
                e.preventDefault();
                console.log("hai");
                $.ajax({
                    method: "POST",
                    url: "/addstudent",
                    data: $('#addstudform').serialize(),
                    success: function(status){
                        if(status) {
                        	 console.log(status);
                           $(".body").html(status)
                        }
                    }
                });
            })
        })
$(document).ready(function(){
	$("#home").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/login",
			success: function(status){
				if(status) {
					console.log(status);
					$("#body").html(status)
				}
			}
		});
	})
})