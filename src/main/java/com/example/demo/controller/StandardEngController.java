package com.example.demo.controller;

import com.example.demo.controller.vo.StandardEngVO;
import com.example.demo.controller.vo.StandardVO;
import com.example.demo.service.StandardEngService;
import com.example.demo.service.StandardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class StandardEngController {
    @Resource
    private StandardEngService standardEngService;

    @GetMapping({"/getEngList"})
    @ResponseBody
    public List<StandardEngVO> getStandardList(){
        return standardEngService.getStandardEngList();
    }

    @GetMapping({"getEngDetail/{id}"})
    @ResponseBody
    public List<StandardEngVO> getDetail(@PathVariable("id") int id){
        System.out.println(id);
        return standardEngService.getStandardDetailEngById(id);
    }
    @GetMapping({"detailEng/{id}"})
    public String detailEng(@PathVariable("id") int id){
        System.out.println(id);
        return "detail";
    }

    @GetMapping({"/getAllIndustryEng"})
    @ResponseBody
    public List<String> getAllIndustryEng() {
        List<String> instList = standardEngService.getAllIndustryEng();
        System.out.println(instList);
        return instList;
    }

    @GetMapping({"/getAllRegionEng"})
    @ResponseBody
    public List<String> getAllRegionEng() {
        return standardEngService.getAllRegionEng();
    }

    @GetMapping({"/filterEng"})
    @ResponseBody
    public List<StandardEngVO> filterByParams(@RequestParam Map<String, String> params) {
        System.out.println(params);
        String region = params.get("region");
        String industry = params.get("industry");
        String effectiveness = params.get("effectiveness");
        System.out.println(params.get("region"));
        return standardEngService.filterByParamsEng(industry, region, effectiveness);
    }

    @GetMapping({"/searchEng"})
    @ResponseBody
    public List<StandardEngVO> search(@RequestParam Map<String, String> params) {
        String keyword = params.get("keyword");
        keyword = "%"+keyword+"%";
        System.out.println(params);
        return standardEngService.searchByKeywordEng(keyword);
    }
}
