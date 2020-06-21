$(document).ready(function(){
	$("#addstudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/add_student",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#editstudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/edit/student",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#displaystudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/studentdisplay",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#addteacher").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/teacher",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#displayteacher").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/teacherdisplay",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#editteacher").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/edit/teacher",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#addteachertimetable").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/addteachertimetable",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#addnonteaching").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/addnonteaching",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})


})





