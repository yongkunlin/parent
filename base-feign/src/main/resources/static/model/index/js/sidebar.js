/**
 * Created by yklin on 2018/6/20.
 */
$(function () {
    // 导航点击事件
    $('.sidebar a[data-toggle="page"]').on('click', function () {
        $('.sidebar a').removeClass('active');
        $(this).addClass('active');
        var code = $(this).attr('resource-code');
        var key = $(this).attr('resource-key');
        $.ajax({
            url: url,
            cache: false,
            success: function (result) {
                $(".main-content").html(result);
                console.log(code + '页面加载完成')
            },
            error: function (err) {
                console.log(err)
            }
        });
    });
    // 折叠栏
    $('.sidebar a[data-toggle="collapse"]').on('click', function () {
        if ($(this).hasClass('collapsed')) {
            $(this).addClass('active');
        } else {
            $(this).removeClass('active');
        }
    });
    //滚动条
    if ($('.sidebar-scroll').length > 0) {
        $('.sidebar-scroll').slimScroll({
            height: '100%',
            wheelStep: 2
        });
    }
});
