$(document).on('change', '.js-email-input', function(event) {

    let $input = $('.js-email-input');

    //Replace extra spaces with one space, and trim trailing spaces
    $input.val($input.val().replace(/\s+/g, '').trim());

    $.ajax({
        url: "/verify-email?email=" + $input.val()
    }).done(function (data){
        if(data.emailAlreadyTaken){
            //email exists
            $('.pwreset-form .js-error').hide();
            enableSubmitButton();
        }
        else{
            //email doesn't exist in database
            $('.pwreset-form .js-error').show();
            disableSubmitButton();
        }
    });


});

function disableSubmitButton() {
    $('.submit-btn').addClass("disabled");
}

function enableSubmitButton() {
    $('.submit-btn').removeClass("disabled");
}