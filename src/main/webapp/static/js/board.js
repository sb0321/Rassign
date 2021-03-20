var main = {

    init : function() {

        var _this = this;

        $('#back').on('click', function() {
            window.location.href='/';
        });

        $('#create-board-btn').on('click', function() {
            window.location.href='/board/create'
        });

        $('#submit').on('click', function() {
            event.preventDefault();
            _this.makeBoard();
        });

    },

    makeBoard : function() {
        var formData = new FormData();

        var files = $('#files')[0].files;

        for(var i = 0; i < files.length; i++) {
            formData.append('uploadFiles', files[i]);
        }

        var title = $('#title').val();
        var content = $('#content').val();

        formData.append("title", title);
        formData.append("content", content);

        $.ajax({
            type : "POST",
            enctype : 'multipart/form-data',
            url : '/board/create',
            processData : false,
            contentType : false,
            async : true,
            data : formData,
            success : function(data) {
            },
            error: function (e) {
                alert('문제가 발생하였습니다.');
            }
        });

    }
}

main.init();
