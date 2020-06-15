$(document).ready(function(){
	$("#studentsubmit").click(function(e){
			$.ajax({
			method: "GET",
			url: "/edit/student/"+$("#admissionNumber_input").val(),
			success: function(status){
				if(status) {
					console.log(status);
					$("#dc-edit-body").html(status)
				}
			}
		});
		
	})
})