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
            $("#others").html("关于平台");
            $("#search-filed").placeholder = "搜索本页";
            $("#search").html("搜索");
            $("#login").html("登录");
            $("#register").html("注册");
            // $("#panel-title").html("造纸行业标准");
            $("#language").html("语言<b class=\"caret\"></b>");
            $("#chinese").html("中文");
            $("#english").html("英文")
            $("#industry_label").html("行业：")
            $("#region_label").html("国家：")
            $("#stage_label").html("阶段：")
            $("#fields_label").html("面向领域：")
            $("#filter_btn").html("筛选")

        }
        getAllRegion(lang)
        getAllIndustry(lang)
        getStage(lang)
        getFields(lang)
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
        var url = "/techSearch"
        var lang = getCookie("language")
        if (lang == "english"){
            url = "/techSearchEng"
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
        var country = $("#region option:selected").text()
        var stage = $("#stage option:selected").text()
        var fields = $("#fields option:selected").text()
        console.log(industry)
        console.log(country)
        console.log(stage)
        var data = {}
        if (industry != "") {
            data["industry"] = industry
        }
        if (country != "") {
            data["country"] = country
        }
        if (stage != "") {
            data["productionStage"] = stage
        }
        if (fields != "") {
            data["fields"] = fields
        }
        var url = "/techFilter"
        if (language=="english") {
            url = "/techFilterEng"
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
        var url = "/getAllTechIndustry"
        if(language==="english"){
            url="/getAllTechIndustryEng";
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
                $("#industry").selectpicker({width: 100})

                $("#industry").selectpicker("refresh")
                $("#industry").selectpicker("render")
            }
        })
    }

    function getAllRegion(language) {
        console.log(language)
        var url = "/getAllTechCountry"
        if(language==="english"){
            url="/getAllTechCountryEng";
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
                $("#region").selectpicker({width:100})

                $("#region").selectpicker("refresh")
                $("#region").selectpicker("render")
            }
        })
    }

    function getStage(language) {
        console.log(language)
        var url = "/getAllTechProductionStage"
        if(language==="english"){
            url="/getAllTechProductionStageEng";
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
                $("#stage").selectpicker({width:160})

                $("#stage").selectpicker("refresh")
                $("#stage").selectpicker("render")
            }
        })
    }
    function getFields(language) {
        console.log(language)
        var url = "/getAllTechFields"
        if(language==="english"){
            url="/getAllTechFieldsEng";
        }
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (returnValue) {
                console.log("return_value:")
                console.log(returnValue)
                $("#fields").html("<option selected></option>");
                $.each(returnValue, function (i,item){
                    var option = "<option>"+item+"</option>"
                    $("#fields").append(option)
                })
                $("#fields").selectpicker("refresh")
                $("#fields").selectpicker("render")
            }
        })
    }

    function constructList(returnValue) {
        var arr = returnValue ;
        console.log(arr)
        var language = getCookie("language")
        // console.log(language)
        $("#tech-list").html("");
        $.each(arr, function(i, item) {
            console.log(item)
            var no = item["no"];
            // if (language=="english") {
            //     detail_id = item["detailEng_id"]
            // }
            var industry = item["industry"];
            var country = item["country"];
            var cleanTechnology = item["cleanTechnology"];
            var stage = item["productionStage"]
            var fields = item["fields"];
            var highlights = item["highlights"];
            var highlights_list = highlights.split(/\/|；|;/)
            var hl_str = "<hr width='1%' />"
            for (var hl in highlights_list) {
                hl_str = hl_str +
                    "                    <span  style='font-size: large' class=\"label label-success\">"+highlights_list[hl]+"</span>\n"
            }

            var option = "<dl class=\"list-group\"  style='margin-bottom: 3%'>\n" +
                "                    <dt style='margin-bottom: 2%' >\n" +
                "                        <a class=\"standard-title\" href=\""+"/tech_detail/"+no+"\" target='_blank'>\n" +
                "                        <h4 class=\"list-group-item-heading\" >"+ cleanTechnology +"</h4>\n" +
                "                        </a>\n" +
                "                    </dt>\n" +
                // "                    <span class=\"label label-info\">编号:    "+ no +"</span>\n" +
                "                    <span class=\"label label-info\">国家:    "+ country +"</span>\n" +

                "                    <span class=\"label label-info\">行业:    "+ industry +"</span>\n" +
                // "                    <span class=\"label label-info\">技术名称:    "+ cleanTechnology +"</span>\n" +
                "                    <span class=\"label label-info\">阶段:    "+ stage +"</span>\n" +
                "                    <span class=\"label label-info\">面向领域:    "+fields+"</span>\n" +
                // "                    <h3><span  class=\"label label-success\">"+highlights+"</span></h3>\n" +
                hl_str+
                "         </dl>"+
                "         <hr class=\"simple\" color=\"#6f5499\" />"
            if(language==="english"){
                option = "<dl class=\"list-group\"  style='margin-bottom: 3%'>\n" +
                    "                    <dt style='margin-bottom: 2%' >\n" +
                    "                        <a class=\"standard-title\" href=\""+"/tech_detail/"+no+"\" target='_blank'>\n" +
                    "                        <h4 class=\"list-group-item-heading\" >"+ cleanTechnology +"</h4>\n" +
                    "                        </a>\n" +
                    "                    </dt>\n" +
                    // "                    <span class=\"label label-info\">No.:    "+ no +"</span>\n" +
                    "                    <span class=\"label label-info\">Country:    "+ country +"</span>\n" +

                    "                    <span class=\"label label-info\">Industry:    "+ industry +"</span>\n" +
                    // "                    <span class=\"label label-info\">CleanTechnology:    "+ cleanTechnology +"</span>\n" +
                    "                    <span class=\"label label-info\">Stage:    "+ stage +"</span>\n" +
                    "                    <span class=\"label label-info\">Fileds:    "+fields+"</span>\n" +
                    // "                    <h3><span  class=\"label label-success\">"+highlights+"</span></h3>\n" +
                    hl_str+
                    "         </dl>"+
                    "         <hr class=\"simple\" color=\"#6f5499\" />"
            }
            // var option = "<option>"+item+"</option>"
            // console.log(option)

            $("#tech-list").append(option)
        });
    }

    function getList(language){
        console.log(language)
        var url="/getTechList";
        if(language==="english"){
            url="/getTechEngList";
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

