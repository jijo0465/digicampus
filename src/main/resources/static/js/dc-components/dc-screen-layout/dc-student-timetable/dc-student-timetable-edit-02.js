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
            url: "/update/studenttimetable",
            data: $('#timetableupdate').serialize(),
            success: function(status){
                if(status) {
                    $("#dc-Student-Timetable").html(status);
                }
            }
        });

    })
})