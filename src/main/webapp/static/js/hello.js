var main = {

    init : function() {

        $('#login-btn').on('click', function() {
            window.location.href="/login";
        });

        $('#register-btn').on('click', function() {
            window.location.href='/register';
        });

        $('#board-btn').on('click', function() {
            window.location.href='/board';
        });

        $('#logout-btn').on('click', function() {
            window.location.href='/logout';
        });
    }
}

main.init();
