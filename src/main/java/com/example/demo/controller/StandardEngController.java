package com.example.demo.controller;

import com.example.demo.controller.vo.StandardEngVO;
import com.example.demo.service.StandardEngService;
import com.example.demo.service.StandardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
}
