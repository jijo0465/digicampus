$(document).ready(function(){
            $("#schemasubmit").click(function(e){
                e.preventDefault();
                console.log("hai");
                var formElements  = document.getElementById('nonteachingstaff').elements;
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
                    url: "/nonteachingstaff",
                    data: $('#nonteachingstaff').serialize(),
                    success: function(status){
                        if(status) {
                           $(".body").html(status)
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