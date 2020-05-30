$(document).ready(function(){
	$("#addstudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/add_student",
			success: function(status){
				if(status) {
					console.log(status);
					$("#results").html(status)
				}
			}
		});
	})
})
$(document).ready(function(){
	$("#addteacher").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/teacher",
			success: function(status){
				if(status) {
					console.log(status);
					$("#results").html(status)
				}
			}
		});
	})
})

