/**
 * Created by yklin on 2018/6/12.
 */
$.fn.defaultJqGrid = function (option) {
    var self = $(this);
    console.log(self)
    var defaultOption = {
        width: self.closest("div").width()-1,//获取外层div宽度
        datatype: "json",//请求数据返回的类型。可选json,xml,txt
        rowNum: 10,//一页显示多少条
        rowList: [10, 15, 20, 30, 50, 80, 100],//可供用户选择一页显示多少条
        pager: '#' + $(this).attr("id") + 'Pager',//表格页脚的占位符(一般是div)的id
        sortname: 'createDate',//初始化的时候排序的字段
        sortorder: "desc",//排序方式,可选desc,asc
        mtype: "post",//向后台请求数据的ajax的类型。可选post,get
        caption: "列表",//表格的标题名字
        viewrecords: true
    };
    $.extend(defaultOption, option);
    self.jqGrid(defaultOption);
};