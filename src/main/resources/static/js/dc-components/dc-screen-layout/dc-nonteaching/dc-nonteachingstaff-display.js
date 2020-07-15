$(document).ready(function(){
    var ID = [];
    $("*").each(function() {
        if (this.id.startsWith("view")) {
            ID.push(this.id);
        }
    });
    console.log(ID);
    ID.forEach(myFunction);
    function myFunction(value)
    {
        $("#"+value).click(function (e) {
        	console.log(value);
            var staffid = value.match(/\d+/)[0];
            $.ajax({
                method:"POST",
                url: "/nonteachingstaff/profile/"+staffid,
                success: function (status) {
                	console.log("hello");
                    if (status) {
                    	console.log("hello");
                        $("#dc-form-body").html(status)
                    }
                }
            });

        })
    }
})