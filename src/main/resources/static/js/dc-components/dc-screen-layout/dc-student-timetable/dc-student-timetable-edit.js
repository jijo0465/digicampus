$('#grade_input').change(function(){
    var tcid=$(this).val();
    console.log(tcid);
    $.ajax({
        method: "GET",
        url: "/classwiseschema/"+$("#grade_input").val(),

        success: function(status){
            $("#schema_input").empty();
            var select="<option value = " + 0 + ">" + "Select Schema" +  "</option>"
            $("#schema_input").append(select)
            status.forEach(function(item, i) {
                var option = "<option value = " + item.id + ">" + item.schemaName +  "</option>";
                $("#schema_input").append(option);
            });
        }
    });
})
$('#schema_input').change(function(){
    console.log("#schema_input");
    $.ajax({
        method: "POST",
        url: "edit/studenttimetable/"+$("#schema_input").val(),
        success: function(status){
            $("#edittimetable").html(status);
        }
    });
})