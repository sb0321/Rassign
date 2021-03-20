var main = {

    init : function() {

        var _this = this;

        $('#duchk-btn').on('click', function() {
            _this.registerCheck();
        });

        $('#reg-btn').on('click', function() {
            _this.registerMember();
        });

        $('#name').on("propertychange change keyup paste input", function() {
            _this.resetButton();
        });

    },

    registerCheck : function() {

        var successComment = '<div class="msg">사용 가능한 이름입니다.</div>';
        var failComment = '<div class ="msg">사용 불가능한 이름입니다.</div>';

        var notExist;

        $.ajax({
            type:"POST",
            url:"/register/check",
            async:false,
            data: {
                "memberID" : $('#name').val()
            },

            success:function(data) {
                notExist = data;
            },
            error:function(data) {
                alert("error");
            }
        });

        if(notExist == 'false') {
            $('#duchk-btn').prop("disabled", true);
            $('div').remove(".msg");
            $('#register-form').after(successComment);
            $('#reg-btn').attr("disabled", false);
        } else {
            console.log("불가능!");
            $('div').remove(".msg");
            $('#register-form').after(failComment);
            $('#reg-btn').attr("disabled", true);
        }

    },

    registerMember : function() {

        $.ajax({
            type:"POST",
            url:"/register",
            data: {
                "memberID" : $('#name').val(),
                "password" : $('#password').val(),
                "nickname" : $('#nickname').val()
            },

            success:function(data) {
                console.log("가입완료!" + data);
                $('#reg-btn').attr("disabled", false);
                window.location.href='/';
            },
            error:function() {
                console.log("불가능!");
            }


        });

    },

    resetButton : function() {
        $('#duchk-btn').prop("disabled", false);
        $('#reg-btn').attr("disabled", true);
    }
}

main.init();
