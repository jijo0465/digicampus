function myFunction(){
    var keyword = document.getElementById("search").value;
    if(keyword!== "" && keyword !== undefined) {
        $.ajax({
            method: "GET",
            url: "/student/search/" + keyword,
            success: function (status) {
                if (status) {
                    $("#dc-search").html(status)
                }
            }
        });
    }

}
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
            var studentid = value.match(/\d+/)[0];
            $.ajax({
                method: "POST",
                url: "/student/profile/"+studentid,
                success: function (status) {
                    if (status) {
                        $("#dc-form-body").html(status)
                    }
                }
            });

        })
    }
})