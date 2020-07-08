$(document).ready(function(){
	$("#teachersubmit").click(function(e){
			$.ajax({
			method: "GET",
			url: "/edit/teacher/"+$("#teacherid_input").val(),
			success: function(status){
				if(status) {
					console.log(status);
					$("#dc-teacher-edit").html(status)
				}
			}
		});
		
	})
})