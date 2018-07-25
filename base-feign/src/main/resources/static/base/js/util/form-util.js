/**
 * 将form中带name的参数拼接为json
 * Created by yklin on 2018/5/25.
 */
/**
 *
 * @param dom form元素
 * @returns {*}
 */
function dom2Json(dom) {
    return form2Json($(dom));
}
/**
 *
 * @param obj form对象
 * @returns {{}}
 */
function form2Json(obj) {
    return arr2Json(obj.serializeArray());
}
/**
 *
 * @param arr form数组
 * @returns {{}}
 */
function arr2Json(arr) {
    var values = {};
    $.each(arr, function (index, row) {
        values[row.name] = row.value
    });
    return values;
}