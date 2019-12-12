$(document).on('change', '.js-password-input', function(event) {
    let $input = $('.js-password-input');

    if ($input.val().length < 8) {//!$input.val().match(lettersAndSpaceRegex)) {
        $('.error').show();
        disableSubmitButton();
    } else {
        $('.error').hide();
        enableSubmitButton();
    }
});

function disableSubmitButton() {
    $('.submit-btn').addClass("disabled");
}

function enableSubmitButton() {
    $('.submit-btn').removeClass("disabled");
}