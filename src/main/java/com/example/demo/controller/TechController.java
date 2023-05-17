package com.example.demo.controller;

import com.example.demo.controller.vo.TechEntityVO;
import com.example.demo.service.TechService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class TechController {

    @Resource
    private TechService techService;

    @GetMapping({"/getTechList"})
    @ResponseBody
    public List<TechEntityVO> getTechList(){
        return techService.getTechList();
    }

    @GetMapping("tech")
    public String tech(){
        return "tech";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }
    @GetMapping({"getTechDetail/{NO}"})
    @ResponseBody
    public List<TechEntityVO> getDetail(@PathVariable("NO") String NO){
        System.out.println(NO);
        return techService.getTechDetailById(NO);
    }
    @GetMapping({"tech_detail/{NO}"})
    public String detail(@PathVariable("NO") String NO){
        System.out.println(NO);
        return "tech_detail";
    }


//    @GetMapping("demand")
//    public String demand(){
//        return "demand";
//    }
//
//    @GetMapping("demand_detail/{id}")
//    public String demandDetail(@PathVariable("id") int id){
//        return "demand_detail";
//    }


    @GetMapping({"/getAllTechIndustry"})
    @ResponseBody
    public List<String> getAllIndustry() {
        List<String> instList = techService.getAllIndustry();
        System.out.println(instList);
        return instList;
    }

    @GetMapping({"/getAllTechCountry"})
    @ResponseBody
    public List<String> getAllRegion() {
        return techService.getAllCountry();
    }


    @GetMapping({"/getAllTechProductionStage"})
    @ResponseBody
    public List<String> getAllProductionStage() {
        List<String> stages = techService.getAllProductionStage();
        Set<String> stageSet = new HashSet<>();
        for (int i = 0 ; i< stages.size(); i++){
            String stage = stages.get(i);
            String[] ss =  stage.split("/|;|,|；");
//            stageSet.addAll(ss)
            for (int j = 0; j< ss.length; j++){
                stageSet.add(ss[j]);
            }

        }
        List<String> result = new ArrayList<String>();
        result.addAll(stageSet);
        return result;
    }
    @GetMapping({"/getAllTechFields"})
    @ResponseBody
    public List<String> getAllFiedls() {
        List<String> fields = techService.getAllFields();
        Set<String> fieldSet = new HashSet<>();
        for (int i = 0 ; i< fields.size(); i++){
            String stage = fields.get(i);
            String[] ss =  stage.split("/|;|,|；");
//            stageSet.addAll(ss)
            for (int j = 0; j< ss.length; j++){
                fieldSet.add(ss[j]);
            }

        }
        List<String> result = new ArrayList<String>();
        result.addAll(fieldSet);
        return result;
//        return techService.getAllFields();
    }

    @GetMapping({"/techFilter"})
    @ResponseBody
    public List<TechEntityVO> filterByParams(@RequestParam Map<String, String> params) {
//        System.out.println(params);
        String country = params.get("country");
        String industry = params.get("industry");
        String productionStage=params.get("productionStage");
        String fields=params.get("fields");
        return techService.filterByParams(industry,country,productionStage,fields);
    }

    @GetMapping({"/techSearch"})
    @ResponseBody
    public List<TechEntityVO> search(@RequestParam Map<String, String> params) {
        String keyword = params.get("keyword");
        keyword = "%"+keyword+"%";
        System.out.println(params);
        return techService.searchByKeyword(keyword);
    }
//文件预览，先注释掉了
//    @GetMapping({"preview/{filedir}/{id}/{filename}"})
//    @ResponseBody
//    public void showPDFFile(@PathVariable("id") String id,@PathVariable("filename") String filename, @PathVariable("filedir") String filedir, HttpServletResponse response) {
////        File file = new File("D:\\原文件汇总\\原文件汇总\\标准数据库—纺织行业—标准原件\\《1+清洁生产标准 纺织业（棉印染）》.pdf");
//        File file = new File("src\\main\\resources\\static\\sourceFiles\\"+filedir+"\\《"+id+"+"+filename+"》.pdf");
//        System.out.println(filedir);
//        System.out.println(filename);
//        if (file.exists()) {
//            System.out.println(file.getAbsolutePath());
//            System.out.println(filename);
//            byte[] data = null;
//            FileInputStream input = null;
//            try {
//                input = new FileInputStream(file);
//                data = new byte[input.available()];
//                input.read(data);
//                response.getOutputStream().write(data);
//            } catch (Exception e) {
//                System.out.println("pdf 文件处理异常: " +e);
//            }finally {
//                try {
//                    if (input != null) {
//                        input.close();
//                    }
//                }catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }else {
//            System.out.println(file.getAbsolutePath());
//        }
//    }
}
