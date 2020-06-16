$(document).ready(function(){
	$("#studentupdate").click(function(e){
			$.ajax({
			method: "POST",
			url: "/addstudent",
			 data: $('#addstudform').serialize(),
			success: function(status){
				if(status) {
					console.log(status);
					$("#updatestudentid").html(status)
				}
			}
		});
		
	})
})