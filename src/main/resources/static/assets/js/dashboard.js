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
$(document).ready(function(){
	$("#addteachertimetable").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/timetableform",
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
	$("#displaystudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/studentdisplay",
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
	$("#displayteacher").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/teacherdisplay",
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
	$("#editstudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/studentupdate",
			success: function(status){
				if(status) {
					console.log(status);
					$("#results").html(status)
				}
			}
		});
	})


})




