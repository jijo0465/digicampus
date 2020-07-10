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