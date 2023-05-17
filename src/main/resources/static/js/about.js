$(document).ready(function () {
    var path = window.location.pathname
    var path_spilt = path.split("/")
    var id = path_spilt[path_spilt.length-1]
    var detail = $("#detail_info")
    var detail_table = $("#detail_table")
    var detail_title = $("#detail_title")
    var about = $("about")

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
            $("#detail-words").html("平台简介")


        }
        getDetail(lang)
    })



    function getDetail(language){
        var info= "为了全面了解国际先进清洁生产技术发展状况，分析研判“一带一路”共建国家重污染行业清洁生产水平，以推动共建国家典型重污染行业绿色发展为总体出发点，基于全生命周期思想，通过广泛调研和分析研判，梳理形成了《中国及“一带一路”共建国家先进适用清洁生产技术供给清单》与《“一带一路”共建国家重污染行业清洁生产技术需求清单》。在此基础上，开发构建了“一带一路”重污染行业清洁生产技术供需清单数据平台（The Belt and Road Initiative Industry Cleaner Production Technology Demand and Supply Inventory Database，BRI-CPTI）。本数据库面向“一带一路”沿线的造纸、石化、纺织、钢铁和水泥五大典型重污染行业，涉及从源头控制到废弃物处置全生命周期的多个阶段，涵盖了中国及部分共建国家先进适用的清洁生产技术及共建国家当前迫切的清洁生产技术需求。"
        // if(language==="english"){
        //     url="/getDemandEng/"
        // }

        about.append("<text>"+info+"</text>")
    }

})