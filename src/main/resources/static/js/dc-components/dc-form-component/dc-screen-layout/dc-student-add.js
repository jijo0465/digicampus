  $( document ).ready(function() {
            $('#phoneParent_info').text('Previously entered numbers are validated');
        });

        function modifySubmit() {
            $("#addstudform input").attr("disabled",false)
            $("#addstudform textarea").attr("disabled",false)
            $("#addstudform select").attr("disabled",false)
            $("#addstudform input").css("background-color","#ffffff");
            $("#addstudform select").attr("background-color","#ffffff")
            $('textarea[name ="address"]').css("background-color","#ffffff");
            $("#grade_input").css("background-color","#ffffff")
            $("#blood_input").css("background-color","#ffffff")
        }

        function confirmSubmit(){
            $('textarea[name ="address"]').attr("disabled" ,false);
            $("#addstudform input").attr("disabled",false)
            $.ajax({
                method: "POST",
                url: "/addstudent",
                data: $('#addstudform').serialize(),
                success: function (status) {
                    if (status) {
                        $(".dc-form-body").html(status)
                    }
                }
            });
        }



        $("#studentsubmit").click(function (e) {
            e.preventDefault();
            var formElements  = document.getElementById('addstudform').elements;
            var hasError = false;
            var gender = $("input[name='gender']:checked").val();
            console.log('Gender')
            console.log(gender)



            for(var i=0; i < formElements.length; i++){

                var element = formElements[i];
                console.log(element.id)
                console.log(isNaN(element.value))
                element.classList.remove("is-invalid")
                element.classList.remove("is-valid")
                if((element.hasAttribute('required'))&&(element.value==''||element.value==0)){
                    element.classList.add("is-invalid")
                    hasError = true;
                }
            }
            if (typeof gender == 'undefined'){
                console.log('not asdasd')
                document.getElementById('genderMale').classList.add("is-invalid")
                document.getElementById('genderFemale').classList.add("is-invalid")
                hasError = true;
            }else {
                document.getElementById('genderMale').classList.remove("is-invalid")
                document.getElementById('genderFemale').classList.remove("is-invalid")
                document.getElementById('genderMale').classList.remove("is-valid")
                document.getElementById('genderFemale').classList.remove("is-valid")

                if(gender == 'Male'){
                    document.getElementById('genderMale').classList.add("is-valid")
                }else{
                    document.getElementById('genderFemale').classList.add("is-valid")
                }



            }

            if(hasError){
                    console.log('error')
                    $('#errorPanel').show();

            }
            else {
                $.ajax({
                    method: "GET",
                    url: "/validateStudentId/"+$("#admissionNumber_input").val(),

                    success: function (status) {
                        if (status=='exists') {
                            $('#errorPanel').hide();
                            $('#existPanel').show();
                        }else{
                            $(".alert").hide()
                            $("html, body").animate({ scrollTop: 0 }, "fast");
                            $('textarea[name ="address"]').attr("disabled" ,true);
                            $('textarea[name ="address"]').css("background-color","#6c757d59");
                            
                            $("#blood_input").css("background-color","#6c757d59")
                            $("blood_input").attr("disabled" ,true)

                            $("#grade_input").css("background-color","#6c757d59")
                            $("grade_input").attr("disabled" ,true);
                            $(".dc-title").text('New Admission - Confirm')
                            $("#addstudform input").attr("disabled",true)
                            $("#addstudform input").css("background-color","#6c757d59")

                            $('#studentsubmit').html('Confirm');
                            $("#studentsubmit").attr("onClick" ,"confirmSubmit()");
                            $("#studentsubmit").removeAttr("id");

                            $('.btn-secondary').html('Modify');
                            $(".btn-secondary").attr("onClick" ,"modifySubmit()");
                            $(".btn-secondary").removeAttr("id");
                        }
                    }
                });
            }

        });


        $(".dc-input").focusout(function(e) {
            var errorMessageElementId = e.currentTarget.id+'_message';
            var errorMessage = '';

            var inputElementId = e.currentTarget.id+'_input';
            var inputText = $('#'+inputElementId).val();
            console.log(inputElementId.toString());
            if($('#'+inputElementId).prop('required')){
                if(inputText==''){
                    $("#"+inputElementId).removeClass("is-valid")
                    $("#"+inputElementId).addClass("is-invalid")
                    errorMessage = 'Field cannot be empty';
                    $('#'+errorMessageElementId).text(errorMessage);
                }else{
                    $("#"+inputElementId).removeClass("is-invalid")
                    $("#"+inputElementId).addClass("is-valid")
                    errorMessage = '';
                    $('#'+errorMessageElementId).text(errorMessage);
                }


            }else if(e.currentTarget.id === 'blood_input'){
                $("#"+inputElementId).removeClass("is-invalid")
                $("#"+inputElementId).addClass("is-valid")
            }else if(inputElementId === 'grade_input'){
                console.log('Entered')
                if(inputText==0){
                    console.log('asdasddasdasda')
                    $("#"+inputElementId).removeClass("is-valid")
                    $("#"+inputElementId).addClass("is-invalid")
                }else{
                    $("#"+inputElementId).removeClass("is-invalid")
                    $("#"+inputElementId).addClass("is-valid")
                }

            }

        });