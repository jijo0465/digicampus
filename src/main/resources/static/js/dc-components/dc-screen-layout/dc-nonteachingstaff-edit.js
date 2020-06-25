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