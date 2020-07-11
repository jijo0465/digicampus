$(document).ready(function(){
	$("#addstudent").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
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
			method: "GET",
			url: "/schemadisplay",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#addstudenttimetable").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "GET",
			url: "/addstudenttimetable",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})

$("#searchnonteachingstaff").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "GET",
			url: "/searchnonteaching",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#editstudenttimetable").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "GET",
			url: "/edit/studenttimetable",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
	$("#displaystudenttimetable").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "GET",
			url: "/display/studenttimetable",
			success: function(status){
				if(status) {
					$("#results").html(status)
				}
			}
		});
	})
})





