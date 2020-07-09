$(document).ready(function(){
	$("#show").click(function(e){
		e.preventDefault();
		$.ajax({
			method: "POST",
			url: "/displaycls",
			
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
	$('#std').change(function(){
		var tcid=$(this).val();
		$.ajax({
			method: "GET",
			url: "/displaystd/"+$("#std").val(),
			success: function(status){
				if(status) {
					console.log(status);
					$("#stdbody").html(status)
				}
			}
		});
		
	})
})