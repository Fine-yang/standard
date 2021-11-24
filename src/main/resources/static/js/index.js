$(document).ready(function () {

    var years = new Array()
    $(function () {
    })



    function getList(){
        $.ajax({
            // url : '/initTable',
            url: '/getList',
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                var arr = returnValue ;
                console.log(arr)
                $.each(arr, function(i, item) {
                    var detail_id = item["detail_id"];
                    var industry = item["industry"];
                    var region = item["region"];
                    var number = item["number"];
                    var effectiveness = item["effectiveness"]
                    var scope = item["scope"];
                    var standard = item["standard"];
                    if (number == null){
                        number = "无"
                    }
                    if(standard ==null){
                        standard = "暂未命名"
                    }
                    var option = "<dl class=\"list-group\"  style='margin-bottom: 3%'>\n" +
                        "                    <dt style='margin-bottom: 2%' >\n" +
                        "                        <a class=\"standard-title\" href=\""+"/detail/"+detail_id+"\" target='_blank'>\n" +
                        "                        <h4 class=\"list-group-item-heading\" >"+ standard +"</h4>\n" +
                        "                        </a>\n" +
                        "                    </dt>\n" +
                        "                    <span class=\"label label-default\">行业:    "+ industry +"</span>\n" +
                        "                    <span class=\"label label-info\">国家:    "+ region +"</span>\n" +
                        "                    <span class=\"label label-info\">标准号:    "+ number +"</span>\n" +
                        "                    <span class=\"label label-info\">是否现行:    "+effectiveness+"</span>\n" +
                        "                    <span class=\"label label-info\">范围:    "+scope+"</span>\n" +
                        "         </dl>"+
                        "         <hr class=\"simple\" color=\"#6f5499\" />"
                    // var option = "<option>"+item+"</option>"
                    // console.log(option)

                    $("#standard-list").append(option)
                });
            }
        });
    }
    getList()




});

