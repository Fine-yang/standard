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
            while (c.charAt(0)===' ') c = c.substring(1);
            if (c.indexOf(name) !== -1) return c.substring(name.length, c.length);
        }
        return "chinese";
    }

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
        if (lang !== "chinese" && lang !=="english"){
            setCookie("language", "english", 7);
        }
        if (lang === "chinese") {
            $("#page-title").html("“一带一路”重污染行业清洁生产技术清单数据平台");
            $("#tech").html("技术清单");
            $("#demand").html("需求清单");
            $("#others").html("其他");
            $("#search-filed").placeholder = "搜索本页";
            $("#search").html("搜索");
            $("#login").html("登录");
            $("#register").html("注册");
            // $("#panel-title").html("造纸行业标准");
            $("#language").html("语言<b class=\"caret\"></b>");
            $("#chinese").html("中文");
            $("#english").html("英文")
            $("#industry_label").html("需求行业：")
            $("#region_label").html("国家地区：")
            $("#stage_label").html("需求阶段：")
            $("#filter_btn").html("筛选")

        }
        getAllRegion(lang)
        getAllIndustry(lang)
        getStage(lang)
        $("#search").click(function () {
            var keyword = $("#search-filed").val()
            console.log(keyword)
            searchByKeyword(keyword)
        })
        $("#filter_btn").click(function () {
            filter(lang)
        })
        getList(lang)
    })

    function searchByKeyword(keyword){
        var url = "/demandSearch"
        var lang = getCookie("language")
        if (lang == "english"){
            url = "/demandSearchEng"
        }
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            data: {
                'keyword': keyword
            },
            async: true,
            success: function (returnValue) {
                constructList(returnValue)
            }
        })
    }

    function filter(language){
        var industry = $("#industry option:selected").text()
        var region = $("#region option:selected").text()
        var stage = $("#stage option:selected").text()
        console.log(industry)
        console.log(region)
        console.log(stage)
        var data = {}
        if (industry != "") {
            data["industry"] = industry
        }
        if (region != "") {
            data["region"] = region
        }
        if (stage != "") {
            data["stage"] = stage
        }
        var url = "/demandFilter"
        if (language=="english") {
            url = "/demandFilterEng"
        }
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: true,
            data: data,
            success : function(returnValue) {
                constructList(returnValue)
            }
        })
    }

    function getAllIndustry(language) {
        console.log(language)
        var url = "/getAllDemandIndustry"
        if(language==="english"){
            url="/getAllDemandIndustryEng";
        }
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (returnValue) {
                console.log("return_value:")
                console.log(returnValue)
                $("#industry").html("<option selected></option>");
                $.each(returnValue, function (i,item){
                    var option = "<option>"+item+"</option>"
                    $("#industry").append(option)
                })
                $("#industry").selectpicker("refresh")
                $("#industry").selectpicker("render")
            }
        })
    }

    function getAllRegion(language) {
        console.log(language)
        var url = "/getAllDemandRegion"
        if(language==="english"){
            url="/getAllDemandRegionEng";
        }
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (returnValue) {
                console.log("return_value:")
                console.log(returnValue)
                $("#region").html("<option selected></option>");
                $.each(returnValue, function (i,item){
                    var option = "<option>"+item+"</option>"
                    $("#region").append(option)
                })
                $("#region").selectpicker("refresh")
                $("#region").selectpicker("render")
            }
        })
    }

    function getStage(language) {
        console.log(language)
        var url = "/getAllDemandStage"
        if(language==="english"){
            url="/getAllDemandStageEng";
        }
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (returnValue) {
                console.log("return_value:")
                console.log(returnValue)
                $("#stage").html("<option selected></option>");
                $.each(returnValue, function (i,item){
                    var option = "<option>"+item+"</option>"
                    $("#stage").append(option)
                })
                $("#stage").selectpicker("refresh")
                $("#stage").selectpicker("render")
            }
        })
    }

    function constructList(returnValue) {
        var arr = returnValue ;
        // console.log(arr)
        var language = getCookie("language")
        // console.log(language)
        $("#demand-list").html("");
        $.each(arr, function(i, item) {
            console.log(item)
            var demand_id = item["demandId"];
            // if (language=="english") {
            //     detail_id = item["detailEng_id"]
            // }
            var industry = item["industry"];
            var region = item["region"];
            var stage = item["stage"];
            var tech_categories = item["techCategories"]
            var tech = item["tech"];
            // var standard = item["standard"];
            // if (number == null){
            //     number = "无"
            //     if (language==="english"){
            //         number = "null"
            //     }
            // }
            if(tech ==null){
                tech = "暂未命名"
                if (language==="english"){
                    // console.log("in if:"+language)
                    tech="null"
                }
            }

            var option = "<dl class=\"list-group\"  style='margin-bottom: 3%'>\n" +
                "                    <dt style='margin-bottom: 2%' >\n" +
                "                        <a class=\"standard-title\" href=\""+"/demand_detail/"+demand_id+"\" target='_blank'>\n" +
                "                        <h4 class=\"list-group-item-heading\" >"+ tech +"</h4>\n" +
                "                        </a>\n" +
                "                    </dt>\n" +

                "                    <span class=\"label label-info\">国家地区:    "+ region +"</span>\n" +
                "                    <span class=\"label label-info\">需求行业:    "+ industry +"</span>\n" +
                "                    <span class=\"label label-info\">需求阶段:    "+ stage +"</span>\n" +
                "                    <span class=\"label label-info\">需求技术类别:    "+tech_categories+"</span>\n" +
                "                    <span class=\"label label-info\">具体技术:    "+tech+"</span>\n" +
                "         </dl>"+
                "         <hr class=\"simple\" color=\"#6f5499\" />"
            if(language==="english"){
                option = "<dl class=\"list-group\"  style='margin-bottom: 3%'>\n" +
                    "                    <dt style='margin-bottom: 2%' >\n" +
                    "                        <a class=\"standard-title\" href=\""+"/demand_detail/"+demand_id+"\" target='_blank'>\n" +
                    "                        <h4 class=\"list-group-item-heading\" >"+ tech +"</h4>\n" +
                    "                        </a>\n" +
                    "                    </dt>\n" +
                    "                    <span class=\"label label-info\">Country/Region:    "+ region +"</span>\n" +
                    "                    <span class=\"label label-default\">Industry:    "+ industry +"</span>\n" +

                    "                    <span class=\"label label-info\">Production Stage:    "+ stage +"</span>\n" +
                    "                    <span class=\"label label-info\">Technology   Categories:    "+tech_categories+"</span>\n" +
                    "                    <span class=\"label label-info\">Technology:    "+ tech +"</span>\n" +
                    "         </dl>"+
                    "         <hr class=\"simple\" color=\"#6f5499\" />"
            }
            // var option = "<option>"+item+"</option>"
            // console.log(option)

            $("#demand-list").append(option)
        });
    }

    function getList(language){
        console.log(language)
        var url="/getDemandList";
        if(language==="english"){
            url="/getDemandEngList";
        }
        // console.log(language)
        $.ajax({
            // url : '/initTable',
            url: url,
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                constructList(returnValue)
            }
        });
    }

});

