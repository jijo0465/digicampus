$(document).ready(function(){
    var i;
    for(i=0;i<100;i++){
        $("#schemaedit"+i).click(function (e) {
        $.ajax({
            method: "POST",
            url: "/schema/edit/1",
            success: function (status) {
                if (status) {
                    $("#dc-edit-schema").html(status)
                }
            }
        });

    })
}
})