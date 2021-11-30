$(document).ready(function () {
    var path = window.location.pathname
    var path_spilt = path.split("/")
    var id = path_spilt[path_spilt.length-1]
    var detail = $("#detail_info")
    var detail_table = $("#detail_table")
    var detail_title = $("#detail_title")

    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays*24*60*60*1000));
        var expires = "expires="+d.toUTCString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
        }
        return "";
    }

    $(function () {

        $("#chinese").click(function () {
            setCookie("language", "chinese", 7)
            window.location.reload();
        });
        $("#english").click(function () {
            setCookie("language", "english", 7)
            window.location.reload();
        });

        var lang = getCookie("language")

        if (lang != "chinese" && lang !="english"){
            setCookie("language", "english", 7);
        }

        if (lang == "chinese") {
            $("#page-title").html("“一带一路”工业清洁生产指标体系与标准数据平台");
            $("#population").html("人口");
            $("#standard").html("标准");
            $("#others").html("其他");
            $("#search-filed").placeholder = "搜索本页";
            $("#search").html("搜索");
            $("#login").html("登录");
            $("#register").html("注册");
            $("#panel-title").html("造纸行业标准");
            $("#language").html("语言<b class=\"caret\"></b>");
            $("#chinese").html("中文");
            $("#english").html("英文")
            $("#detail-words").html("详细信息")


        }
        getDetail(lang)
    })

    function getDetail(language){
        var url= "/getDetail/"
        if(language=="english"){
            url="/getDetail/"
        }
        $.ajax({
            // url : '/initTable',
            url: url+id,
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                var arr = returnValue ;
                console.log(arr)
                detail_title.html("")
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
                    if(language=="english"){
                        if (number == null){
                            number = "null"
                        }
                        if(abstracts ==null){
                            abstracts = "null"
                        }
                        if(standard ==null){
                            standard = "null"
                        }
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
                        "                </tbody>";
                    if(language=="english"){
                        option = " <tbody>\n" +
                            "\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Industry：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+ industry+"</td>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Region：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\" >"+region+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Number：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+number+"</td>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Year：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+year+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Effectiveness：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+effectiveness+"</td>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Scope：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+scope+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Standard：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+standard+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Link：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\"><a href='"+link+"'>"+link+"</a></td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Abstracts：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+abstracts+"</td>\n" +
                            "                </tr>\n" +
                            "                </tbody>";
                    }
                    detail_table.append(option)
                    // var option = "<option>"+item+"</option>"
                    // console.log(option)

                    // $("#standard-list").append(option)
                });
            }
        });
    }

})