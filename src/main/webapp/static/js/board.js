var main = {

    init : function() {

        var _this = this;

        $('#back').on('click', function() {
            window.location.href='/';
        });

        $('#create-board-btn').on('click', function() {
            window.location.href='/board/create'
        });

        $('#nouse-folder-btn').on('click', function() {
            window.location.href='/myfolder/nouse';
        })

    },

    makeBoard : function() {

        var boardTitle = $('#new-board-title').val();
        var boardContent = $('#new-board-content').val();

        $.ajax({
            type : "POST",
            url : "/board/create",
            data : {
                "title" : boardTitle,
                "content" : boardContent
            },
            success : function(data) {
                alert('성공');
                window.location.href='/board';
            }

        });

    }
}

main.init();
