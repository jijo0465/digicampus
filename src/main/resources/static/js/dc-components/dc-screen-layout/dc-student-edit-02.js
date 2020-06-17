$(document).ready(function(){
	$("#studentupdate").click(function(e){
			$.ajax({
			method: "POST",
			url: "/updatestudent",
			 data: $('#updatestudform').serialize(),
			success: function(status){
				if(status) {
					console.log(status);
					$("#updatestudentid").html(status)
				}
			}
		});
		
	})
})