package com.example.demo.controller;

import com.example.demo.controller.vo.DemandEngVO;
import com.example.demo.service.DemandEngService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class DemandEngController {

    @Resource
    private DemandEngService demandEngService;

    @GetMapping({"/getDemandEngList"})
    @ResponseBody
    public List<DemandEngVO> getDemandEngList() {
        return demandEngService.getDemandList();
    }


    @GetMapping({"/getDemandEng/{id}"})
    @ResponseBody
    public List<DemandEngVO> getDetail(@PathVariable("id") int id) {
        System.out.println(id);
        return demandEngService.getDemandEngById(id);
    }


    @GetMapping({"/getAllDemandIndustryEng"})
    @ResponseBody
    public List<String> getAllIndustry() {
        List<String> instList = demandEngService.getAllIndustry();
        System.out.println(instList);
        return instList;
    }

    @GetMapping({"/getAllDemandRegionEng"})
    @ResponseBody
    public List<String> getAllRegion() {
        return demandEngService.getAllRegion();
    }


    @GetMapping({"/getAllDemandStageEng"})
    @ResponseBody
    public List<String> getAllStage() {
        return demandEngService.getAllStage();
    }


    @GetMapping({"/demandFilterEng"})
    @ResponseBody
    public List<DemandEngVO> filterByParams(@RequestParam Map<String, String> params) {
//        System.out.println(params);
        String region = params.get("region");
        String industry = params.get("industry");
        String stage = params.get("stage");
        return demandEngService.filterByParams(industry, region, stage);
    }

    @GetMapping({"/demandSearchEng"})
    @ResponseBody
    public List<DemandEngVO> search(@RequestParam Map<String, String> params) {
        String keyword = params.get("keyword");
        keyword = "%" + keyword + "%";
        System.out.println(params);
        return demandEngService.searchByKeyword(keyword);
    }
}

