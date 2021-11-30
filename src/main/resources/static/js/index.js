$(document).ready(function () {

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

    var years = new Array()
    $(function () {
        // setCookie("language", "english", 7)
        $("#chinese").click(function () {
            setCookie("language", "chinese", 7)
            window.location.reload();
        });
        $("#english").click(function () {
            setCookie("language", "english", 7)
            window.location.reload();
        });

        var lang = getCookie("language")
        // $("#title-en").html(function (){
        //     return "“一带一路”工业清洁生产指标体系与标准数据平台"
        // })
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

        }
        getList(lang)
    })


    function getList(language){
        console.log(language)
        var url="/getList";
        if(language=="english"){
            url="/getList";
        }
        // console.log(language)
        $.ajax({
            // url : '/initTable',
            url: url,
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                var arr = returnValue ;
                // console.log(arr)
                // console.log(language)
                $("#standard-list").html("");
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
                        if (language=="english"){
                            number = "null"
                        }
                    }
                    if(standard ==null){
                        standard = "暂未命名"
                        if (language=="english"){
                            // console.log("in if:"+language)
                            standard="null"
                        }
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
                    if(language=="english"){
                        option = "<dl class=\"list-group\"  style='margin-bottom: 3%'>\n" +
                            "                    <dt style='margin-bottom: 2%' >\n" +
                            "                        <a class=\"standard-title\" href=\""+"/detail/"+detail_id+"\" target='_blank'>\n" +
                            "                        <h4 class=\"list-group-item-heading\" >"+ standard +"</h4>\n" +
                            "                        </a>\n" +
                            "                    </dt>\n" +
                            "                    <span class=\"label label-default\">Industry:    "+ industry +"</span>\n" +
                            "                    <span class=\"label label-info\">Region:    "+ region +"</span>\n" +
                            "                    <span class=\"label label-info\">Number:    "+ number +"</span>\n" +
                            "                    <span class=\"label label-info\">Effectiveness:    "+effectiveness+"</span>\n" +
                            "                    <span class=\"label label-info\">Scope:    "+scope+"</span>\n" +
                            "         </dl>"+
                            "         <hr class=\"simple\" color=\"#6f5499\" />"
                    }
                    // var option = "<option>"+item+"</option>"
                    // console.log(option)

                    $("#standard-list").append(option)
                });
            }
        });
    }






});

