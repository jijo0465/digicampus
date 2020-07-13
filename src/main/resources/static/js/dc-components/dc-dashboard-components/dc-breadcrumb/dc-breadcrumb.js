$(document).ready(function() {
    $("#breadhome").click(function (e) {
        e.preventDefault();
        $.ajax({
            method: "GET",
            url: "/mydashboard",
            success: function (status) {
                if (status) {
                    $("body").html(status)
                }
            }
        });
    })
})