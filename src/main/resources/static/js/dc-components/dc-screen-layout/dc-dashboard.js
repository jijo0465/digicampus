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
	$("#searchstudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/searchstudent",
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
	$("#searchteacher").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/searchteacher",
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
	$("#editnonteachingstaff").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/editnonteachingstaff",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#displaynonteachingstaff").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/nonteachingdisplay",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#addschemas").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/addschemas",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#editschemas").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/edit/schema",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})

	
	$("#displayschemas").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/schemadisplay",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})


})





