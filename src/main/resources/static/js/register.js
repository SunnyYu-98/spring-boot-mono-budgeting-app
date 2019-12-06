$(document).on('change', '.js-birth-date', function () {
    //Split birthday 'YYYY-MM-DD' by '-'
    const birthdayArray = $('.js-birth-date').val().split('-');

    //.match('^([1-9]|1[012])$')
    //arr[1].match('^([0-1][0-2]|[1-9])$')
    if(birthdayArray[1] < 1 || birthdayArray[1] > 12){
        alert("Birth month cannot be less than 0 or greater than 12!");
    }
    if(birthdayArray[2] < 1 || birthdayArray[2] > 31){
        alert("Birth month cannot be less than 0 or greater than 12!");
    }
});

$(document).on('change', 'input', function(event) {

    const eventClassList = event.target.parentNode.classList;
    const lettersAndSpaceRegex = /^[A-Za-z ]+$/;

    if (eventClassList.contains("js-firstName")) {
        let $input = $('.js-firstName input');

        //Replace extra spaces with one space, and trim trailing spaces
        $input.val($input.val().replace(/\s+/g, ' ').trim());
        if (!$input.val().match(lettersAndSpaceRegex)) {
            $('.js-firstName .error').show();
        } else {
            $('.js-firstName .error').hide();
        }
    }

    if (eventClassList.contains("js-lastName")) {
        let $input = $('.js-lastName input');

        //Replace extra spaces with one space, and trim trailing spaces
        $input.val($input.val().replace(/\s+/g, ' ').trim());
        if (!$input.val().match(lettersAndSpaceRegex)) {
            $('.js-lastName .error').show();
        } else {
            $('.js-lastName .error').hide();
        }
    }

    if (eventClassList.contains("js-email")) {
        let $input = $('.js-email input');

        //Replace extra spaces with one space, and trim trailing spaces
        $input.val($input.val().replace(/\s+/g, '').trim());

        if (!$input.val().match(/^[A-Za-z0-9._@]+$/)) {
            $('.js-email .inputError').show();
        } else {
            $('.js-email .inputError').hide();
        }

        $.ajax({
            url: "/verify-email?email=" + $input.val()
        }).done(function (data){
            if(data.emailAlreadyTaken){
                $('.js-email .emailTakenError').show();
            }
            else{
                $('.js-email .emailTakenError').hide();
            }
        });
    }


    /*
    switch (eventClassList) {
        case this.contains('js-firstName'):
            $('.js-firstName .error').show();
            break;
        case this.contains('js-lastName'): $('.lastName .error').show();
    }
     */
   // event.target.parentNode.classList.contains('js-firstName')

    /*
    $.ajax({
        url: "/verify-email?email=" + $('.js-email input').val(),
        type: "GET"
    }).done(function (data){
        if(data.emailAlreadyTaken){
            $('.js-email .error').show();
        }
        else{
            $('.js-email .error').hide();
        }
    });

     */
});

function validateRegistrationForm() {
    if(!$('.js-firstName input').val().match("[a-zA-Z]*")){
        $('.js-firstName .error').show();
    }

    if(!$('.js-lastName input').val().match("[a-zA-Z]*")){
        $('.js-lastName .error').show();
    }

    $.ajax({
        url: "/verify-email?email=" + $('.js-email input').val()
    }).done(function (data){
        if(data.emailAlreadyTaken){
            $('.js-email .error').show();
        }
        else{
            $('.js-email .error').hide();
        }
    });


}




/*
//Problem: Hints are shown even when form is valid
//Solution: Hide and show them at appropriate times
var $password = $("#password");
var $confirmPassword = $("#confirm_password");

//Hide hints
$("form span").hide();

function isPasswordValid() {
  return $password.val().length > 8;
}

function arePasswordsMatching() {
  return $password.val() === $confirmPassword.val();
}

function canSubmit() {
  return isPasswordValid() && arePasswordsMatching();
}

function passwordEvent(){
    //Find out if password is valid  
    if(isPasswordValid()) {
      //Hide hint if valid
      $password.next().hide();
    } else {
      //else show hint
      $password.next().show();
    }
}

function confirmPasswordEvent() {
  //Find out if password and confirmation match
  if(arePasswordsMatching()) {
    //Hide hint if match
    $confirmPassword.next().hide();
  } else {
    //else show hint 
    $confirmPassword.next().show();
  }
}

function enableSubmitEvent() {
  $("#submit").prop("disabled", !canSubmit());
}

//When event happens on password input
$password.focus(passwordEvent).keyup(passwordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

//When event happens on confirmation input
$confirmPassword.focus(confirmPasswordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

enableSubmitEvent();

 */