$(document).on('change', 'input', function(event) {

    const eventClassList = event.target.parentNode.classList;
    const lettersAndSpaceRegex = /^[A-Za-z ]+$/;

    if (eventClassList.contains("js-firstName")) {
        let $input = $('.js-firstName input');

        //Replace extra spaces with one space, and trim trailing spaces
        $input.val($input.val().replace(/\s+/g, ' ').trim());
        if (!$input.val().match(lettersAndSpaceRegex)) {
            $('.js-firstName .error').show();
            disableSubmitButton();
        } else {
            $('.js-firstName .error').hide();
            enableSubmitButton();
        }
    }

    if (eventClassList.contains("js-lastName")) {
        let $input = $('.js-lastName input');

        //Replace extra spaces with one space, and trim trailing spaces
        $input.val($input.val().replace(/\s+/g, ' ').trim());
        if (!$input.val().match(lettersAndSpaceRegex)) {
            $('.js-lastName .error').show();
            disableSubmitButton();
        } else {
            $('.js-lastName .error').hide();
            enableSubmitButton();
        }
    }

    if (eventClassList.contains("js-email")) {
        let $input = $('.js-email input');

        //Replace extra spaces with one space, and trim trailing spaces
        $input.val($input.val().replace(/\s+/g, '').trim());

        if (!$input.val().match(/^[A-Za-z0-9._@]+$/) && $input.val() != "") {
            $('.js-email .inputError').show();
            disableSubmitButton();
        } else {
            $('.js-email .inputError').hide();

            $.ajax({
                url: "/verify-email?email=" + $input.val()
            }).done(function (data){
                if(data.emailAlreadyTaken){
                    $('.js-email .emailTakenError').show();
                    disableSubmitButton();
                }
                else{
                    $('.js-email .emailTakenError').hide();
                    enableSubmitButton();
                }
            });
        }
    }

    if (eventClassList.contains("js-password")) {
        let $input = $('.js-password input');

        if ($input.val().length < 8) {//!$input.val().match(lettersAndSpaceRegex)) {
            $('.js-password .error').show();
            disableSubmitButton();
        } else {
            $('.js-password .error').hide();
            enableSubmitButton();
        }
    }

    if (eventClassList.contains("js-confirm-password")) {
        let $input = $('.js-confirm-password input');

        if ($input.val() !== $('.js-password input').val()) {
            $('.js-confirm-password .error').show();
            disableSubmitButton();
        } else {
            $('.js-confirm-password .error').hide();
            enableSubmitButton();
        }
    }

    if (eventClassList.contains("js-phoneNumber")) {
        let $input = $('.js-phoneNumber input');

        if ($input.val().length !== 10) {
            $('.js-phoneNumber .error').show();
            disableSubmitButton();
        } else {
            $('.js-phoneNumber .error').hide();
            enableSubmitButton();
        }
    }

/*
    switch (eventClassList) {
        case eventClassList.contains('js-firstName'):
            $('.js-firstName .error').show();
            alert("class");
            break;
    }
 */
   // event.target.parentNode.classList.contains('js-firstName')
});

function disableSubmitButton() {
    $('.btn[name=submit]').addClass("disabled");
}

function enableSubmitButton() {
    $('.btn[name=submit]').removeClass("disabled");
}