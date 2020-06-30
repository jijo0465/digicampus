$(document).ready(function(){
    var ID = [];
    $("*").each(function() {
        if (this.id.startsWith("schemaedit")) {
            ID.push(this.id);
        }
    });
    console.log(ID);
    ID.forEach(myFunction);
    function myFunction(value)
    {
        $("#"+value).click(function (e) {
            var schemaid = value.match(/\d+/)[0];
            $.ajax({
                method: "POST",
                url: "/schema/edit/"+schemaid,
                success: function (status) {
                    if (status) {
                        $("#dc-edit-schema").html(status)
                    }
                }
            });

        })
    }
})