// 定向跳转页面功能
function go_page(page_name) {
    // console.log(page_name);
    var input_page = Number($("#pageNumber").val());
    var max_page = Number($("#max_page").text());

    console.log(input_page);
    console.log(max_page);
    console.log(input_page > max_page);

    if (input_page < 1) {
        input_page = 1;
    }

    if (input_page > max_page) {
        input_page = max_page;
    }

    alert("即将跳转到第 " + input_page + "页");
    window.location.href = "/" + page_name + "?pageNum=" + input_page + "&size=5";
}