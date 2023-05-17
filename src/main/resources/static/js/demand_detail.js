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

        if (lang !== "chinese" && lang !=="english"){
            setCookie("language", "english", 7);
        }

        if (lang === "chinese") {
            $("#page-title").html("“一带一路”重污染行业清洁生产技术清单数据平台");
            $("#tech").html("技术清单");
            $("#demand").html("需求清单");
            $("#others").html("关于平台");
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
        var url= "/getDemandDetail/"
        if(language==="english"){
            url="/getDemandEng/"
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

                    var demand_id = item["demandId"];
                    var region = item["region"];
                    var industry = item["industry"];
                    var number = item["number"]
                    var stage = item["stage"];
                    var tech = item["tech"];
                    var tech_categories = item["techCategories"]
                    var tech_overview = item["techOverview"]
                    var description = item["description"];
                    var source = item["source"];
                    if (number == null){
                        number = (language==="english")?"null":"无";
                    }

                    var title_option = "<h3>"+tech+"</h3>"
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
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">编号：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+number+"</td>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">需求阶段：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+stage+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">技术：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+tech+"</td>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">技术类别：</td>\n" +
                        "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+tech_categories+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">需求简介：</td>\n" +
                        "                    <td colspan='3' style=\"width: 65% ; padding-bottom: 30px; text-align: left\">"+description+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">技术简介：</td>\n" +
                        "                    <td colspan='3' style=\"width: 65% ; padding-bottom: 30px; text-align: left\">"+tech_overview+"</a></td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">来源：</td>\n" +
                        "                    <td colspan='3' style=\"width: 65% ; padding-bottom: 30px; text-align: left\">"+source+"</td>\n" +
                        "                </tr>\n" +
                        "                </tbody>";
                    if(language==="english"){
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
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Production Stage：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+stage+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Technology：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+tech+"</td>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Technology   Categories：</td>\n" +
                            "                    <td style=\"width: 32% ; padding-bottom: 30px; text-align: left\">"+tech_categories+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Demand description：</td>\n" +
                            "                    <td colspan='3' style=\"width: 65% ; padding-bottom: 30px; text-align: left\">"+description+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Technology Overview：</td>\n" +
                            "                    <td colspan='3' style=\"width: 65% ; padding-bottom: 30px; text-align: left\">"+tech_overview+"</a></td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <td style=\"width: 18% ; padding-bottom: 30px;font-weight: bold\">Source：</td>\n" +
                            "                    <td colspan='3' style=\"width: 65% ; padding-bottom: 30px; text-align: left\">"+source+"</td>\n" +
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