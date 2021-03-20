var main = {

    init : function() {

        $('#login-btn').on('click', function() {
            window.location.href="/login";
        });

        $('#register-btn').on('click', function() {
            window.location.href='/register';
        });

        $('#folder-btn').on('click', function() {
            window.location.href='/myfolder';
        });

        $('#logout-btn').on('click', function() {
            window.location.href='/logout';
        });
    }
}

main.init();
