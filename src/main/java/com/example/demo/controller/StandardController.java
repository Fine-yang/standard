package com.example.demo.controller;

import com.example.demo.controller.vo.StandardVO;
import com.example.demo.service.StandardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class StandardController {

    @Resource
    private StandardService standardService;

    @GetMapping({"/getList"})
    @ResponseBody
    public List<StandardVO> getStandardList(){
        return standardService.getStandardList();
    }

    @GetMapping({"getDetail/{id}"})
    @ResponseBody
    public List<StandardVO> getDetail(@PathVariable("id") int id){
        System.out.println(id);
        return standardService.getStandardDetailById(id);
    }
    @GetMapping({"detail/{id}"})
    public String detail(@PathVariable("id") int id){
        System.out.println(id);
        return "detail";
    }

//    @GetMapping("tech")
//    public String tech(){
//        return "tech";
//    }
//
//    @GetMapping("tech_detail/{id}")
//    public String techDetail(@PathVariable("id") int id){
//        return "tech_detail";
//    }
//
//    @GetMapping("demand")
//    public String demand(){
//        return "demand";
//    }
//
//    @GetMapping("demand_detail/{id}")
//    public String demandDetail(@PathVariable("id") int id1408){
//        return "demand_detail";
//    }

    @GetMapping({"/getAllIndustry"})
    @ResponseBody
    public List<String> getAllIndustry() {
        List<String> instList = standardService.getAllIndustry();
        System.out.println(instList);
        return instList;
    }

    @GetMapping({"/getAllRegion"})
    @ResponseBody
    public List<String> getAllRegion() {
        return standardService.getAllRegion();
    }

    @GetMapping({"/filter"})
    @ResponseBody
    public List<StandardVO> filterByParams(@RequestParam Map<String, String> params) {
        System.out.println(params);
        String region = params.get("region");
        String industry = params.get("industry");
        String effectiveness = params.get("effectiveness");
        System.out.println(params.get("region"));
        return standardService.filterByParams(industry, region, effectiveness);
    }

    @GetMapping({"/search"})
    @ResponseBody
    public List<StandardVO> search(@RequestParam Map<String, String> params) {
        String keyword = params.get("keyword");
        keyword = "%"+keyword+"%";
        System.out.println(params);
        return standardService.searchByKeyword(keyword);
    }

    @GetMapping({"preview/{filedir}/{id}/{filename}"})
    @ResponseBody
    public void showPDFFile(@PathVariable("id") String id,@PathVariable("filename") String filename, @PathVariable("filedir") String filedir, HttpServletResponse response) {
//        File file = new File("D:\\原文件汇总\\原文件汇总\\标准数据库—纺织行业—标准原件\\《1+清洁生产标准 纺织业（棉印染）》.pdf");
        File file = new File("src\\main\\resources\\static\\sourceFiles\\"+filedir+"\\《"+id+"+"+filename+"》.pdf");
        System.out.println(filedir);
        System.out.println(filename);
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
            System.out.println(filename);
            byte[] data = null;
            FileInputStream input = null;
            try {
                input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
            } catch (Exception e) {
                System.out.println("pdf 文件处理异常: " +e);
            }finally {
                try {
                    if (input != null) {
                        input.close();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println(file.getAbsolutePath());
        }
    }
}
