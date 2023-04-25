package com.example.demo.service;

import com.example.demo.controller.vo.DemandEngVO;
import com.example.demo.dao.DemandEngMapper;
import com.example.demo.entity.DemandEng;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandEngService {
    @Autowired
    private DemandEngMapper demandEngMapper;

    public List<DemandEngVO> getDemandList(){
        List<DemandEng> demandList=demandEngMapper.selectDemandList();
        List<DemandEngVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandEngVO.class);
        return demandVOList;
    }

    public List<DemandEngVO> getDemandEngById(int id){
        List<DemandEng> demandList=demandEngMapper.selectDemandEngById(id);
        List<DemandEngVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandEngVO.class);
        return demandVOList;
    }

    public List<DemandEngVO> filterByParams(String industry, String region, String stage){
        List<DemandEng> demandList=demandEngMapper.filterByParams(industry, region, stage);
        List<DemandEngVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandEngVO.class);
        return demandVOList;
    }

    public List<DemandEngVO> searchByKeyword(String keyword){
        List<DemandEng> demandList=demandEngMapper.searchByKeyword(keyword);
        List<DemandEngVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandEngVO.class);
        return demandVOList;
    }

    public List<String> getAllIndustry() {
        List<String> industryList = demandEngMapper.getAllIndustry();
        return industryList;
    }

    public List<String> getAllRegion() {
        List<String> regionList = demandEngMapper.getAllRegion();
        return regionList;
    }
    public List<String> getAllStage() {
        List<String> stageList = demandEngMapper.getAllStage();
        return stageList;
    }

}
