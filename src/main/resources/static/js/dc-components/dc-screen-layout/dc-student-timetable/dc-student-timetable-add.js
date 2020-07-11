$('#grade_input').change(function(){
    var tcid=$(this).val();
    console.log(tcid);
    $.ajax({
        method: "GET",
        url: "/classwiseschema/"+$("#grade_input").val(),

        success: function(status){
            $("#schema_input").empty();
            status.forEach(function(item, i) {
                var option = "<option value = " + item.id + ">" + item.schemaName +  "</option>";
                $("#schema_input").append(option);
            });
        }
    });
})
$(document).ready(function(){
    $(".nav-tabs a").click(function(e){
        e.preventDefault();
        $(this).tab('show');
    });
});
$(document).ready(function(){
    $("#timetablesubmit").click(function(e){
        $.ajax({
            method: "POST",
            url: "/saveTimeTable",
            data: $('#saveTimeTable').serialize(),
            success: function(status){
                if(status) {
                    $("#dc-Student-Timetable").html(status);
                }
            }
        });

    })
})
$(document).ready(function(){
    $("#back").click(function(e){
        $.ajax({
            method: "GET",
            url: "/mydashboard",
            success: function(status){
                if(status) {
                    $("body").html(status);
                }
            }
        });

    })
})