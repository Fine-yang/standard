package com.example.demo.controller;

import com.example.demo.controller.vo.TechEngEntityVO;
import com.example.demo.service.TechEngService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class TechEngController {

    @Resource
    private TechEngService techEngService;

    @GetMapping({"/getTechEngList"})
    @ResponseBody
    public List<TechEngEntityVO> getTechEngList(){
        return techEngService.getTechEngList();
    }

    @GetMapping({"getTechEngDetail/{NO}"})
    @ResponseBody
    public List<TechEngEntityVO> getEngDetail(@PathVariable("NO") String NO){
        System.out.println(NO);
        return techEngService.getTechEngDetailById(NO);
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


    @GetMapping({"/getAllTechIndustryEng"})
    @ResponseBody
    public List<String> getAllIndustryEng() {
        List<String> instList = techEngService.getAllIndustryEng();
        System.out.println(instList);
        return instList;
    }

    @GetMapping({"/getAllTechCountryEng"})
    @ResponseBody
    public List<String> getAllRegionEng() {
        return techEngService.getAllCountryEng();
    }


    @GetMapping({"/getAllTechProductionStageEng"})
    @ResponseBody
    public List<String> getAllProductionStageEng() {
        return techEngService.getAllProductionStageEng();
    }
    @GetMapping({"/getAllTechFieldsEng"})
    @ResponseBody
    public List<String> getAllFiedlsEng() {
        return techEngService.getAllFieldsEng();
    }

    @GetMapping({"/techFilterEng"})
    @ResponseBody
    public List<TechEngEntityVO> filterByParamsEng(@RequestParam Map<String, String> params) {
//        System.out.println(params);
        String country = params.get("country");
        String industry = params.get("industry");
        String productionStage=params.get("productionStage");
        String fields=params.get("fields");
        return techEngService.filterByParamsEng(industry,country,productionStage,fields);
    }

    @GetMapping({"/tecgSearchEng"})
    @ResponseBody
    public List<TechEngEntityVO> searchEng(@RequestParam Map<String, String> params) {
        String keyword = params.get("keyword");
        keyword = "%"+keyword+"%";
        System.out.println(params);
        return techEngService.searchByKeywordEng(keyword);
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
