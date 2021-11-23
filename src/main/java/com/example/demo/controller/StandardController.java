package com.example.demo.controller;

import com.example.demo.controller.vo.StandardVO;
import com.example.demo.service.StandardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

}
