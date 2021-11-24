$(document).ready(function () {
    var path = window.location.pathname
    var path_spilt = path.split("/")
    var id = path_spilt[path_spilt.length-1]
    var detail = $("#detail_info")
    var detail_table = $("#detail_table")
    var detail_title = $("#detail_title")
    function getDetail(){
        $.ajax({
            // url : '/initTable',
            url: '/getDetail/'+id,
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
                    var abstracts = item["abstracts"];
                    var year = item["year"]
                    var link = item["link"]
                    if (number == null){
                        number = "无"
                    }
                    if(abstracts ==null){
                        abstracts = "暂无简介"
                    }
                    if(standard ==null){
                        standard = "暂未命名"
                    }
                    var title_option = "<h3>"+standard+"</h3>"
                    detail_title.append(title_option)
                    var option = " <tbody>\n" +
                        "\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">行业：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+ industry+"</td>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">国家：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\" >"+region+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">标准号：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+number+"</td>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">年份：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+year+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">是否现行：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+effectiveness+"</td>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">范围：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+scope+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">标准名称：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+standard+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">链接：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\"><a href='"+link+"'>"+link+"</a></td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">主要内容：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+abstracts+"</td>\n" +
                        "                </tr>\n" +
                        "                </tbody>"
                    detail_table.append(option)
                    // var option = "<option>"+item+"</option>"
                    // console.log(option)

                    // $("#standard-list").append(option)
                });
            }
        });
    }
    getDetail()
})