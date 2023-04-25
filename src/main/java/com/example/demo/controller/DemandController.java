package com.example.demo.controller;

import com.example.demo.controller.vo.DemandVO;
import com.example.demo.service.DemandDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class DemandController {

    @Resource
    private DemandDetailService demandDetailService;

    @GetMapping({"/getDemandList"})
    @ResponseBody
    public List<DemandVO> getDemandList() {
        return demandDetailService.getDemandList();
    }

    @GetMapping("demand")
    public String demand() {
        return "demand";
    }

    @GetMapping({"/getDemandDetail/{id}"})
    @ResponseBody
    public List<DemandVO> getDetail(@PathVariable("id") int id) {
        System.out.println(id);
        return demandDetailService.getDemandDetailById(id);
    }

    @GetMapping({"demand_detail/{id}"})
    public String detail(@PathVariable("id") int id) {
        System.out.println(id);
        return "demand_detail";
    }


    @GetMapping({"/getAllDemandIndustry"})
    @ResponseBody
    public List<String> getAllIndustry() {
        List<String> instList = demandDetailService.getAllIndustry();
        System.out.println(instList);
        return instList;
    }

    @GetMapping({"/getAllDemandRegion"})
    @ResponseBody
    public List<String> getAllRegion() {
        return demandDetailService.getAllRegion();
    }


    @GetMapping({"/getAllDemandStage"})
    @ResponseBody
    public List<String> getAllStage() {
        return demandDetailService.getAllStage();
    }


    @GetMapping({"/demandFilter"})
    @ResponseBody
    public List<DemandVO> filterByParams(@RequestParam Map<String, String> params) {
//        System.out.println(params);
        String region = params.get("region");
        String industry = params.get("industry");
        String stage = params.get("stage");
        return demandDetailService.filterByParams(industry, region, stage);
    }

    @GetMapping({"/demandSearch"})
    @ResponseBody
    public List<DemandVO> search(@RequestParam Map<String, String> params) {
        String keyword = params.get("keyword");
        keyword = "%" + keyword + "%";
        System.out.println(params);
        return demandDetailService.searchByKeyword(keyword);
    }
}

