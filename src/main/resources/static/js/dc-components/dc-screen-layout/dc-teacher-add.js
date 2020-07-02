$(document).ready(function(){
            $("#teachersubmit").click(function(e){
                e.preventDefault();
                console.log("hai");
                var formElements  = document.getElementById('addteacher').elements;
                var hasError = false;
                for(var i=0; i < formElements.length; i++){
                    var element = formElements[i];

                    console.log(element.id+"="+element.value);
                    if((element.hasAttribute('required'))&&element.value==''){
                        element.classList.add("is-invalid")
                        hasError = true;
                    }else{
                        element.classList.add("is-valid")
                    }
                }
                if(hasError){
                    console.log('error')
                    $('#errorPanel').show();
                }else{
                $.ajax({
                    method: "POST",
                    url: "/addteacher",
                    data: $('#addteacher').serialize(),
                    success: function(status){
                        if(status) {
                           $("#teacherconfirmbody").html(status)
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
                console.log(inputText);
                if($('#'+inputElementId).prop('required') && inputText==''){
                    errorMessage = 'Field cannot be empty';
                }
                $('#'+errorMessageElementId).text(errorMessage);
            });  
        });