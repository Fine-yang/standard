package com.example.demo.service;

import com.example.demo.controller.vo.DemandVO;
import com.example.demo.dao.DemandDetailMapper;
import com.example.demo.entity.DemandDetail;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandDetailService {
    @Autowired
    private DemandDetailMapper demandDetailMapper;

    public List<DemandVO> getDemandList(){
        List<DemandDetail> demandList=demandDetailMapper.selectDemandList();
        List<DemandVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandVO.class);
        return demandVOList;
    }

    public List<DemandVO> getDemandDetailById(int id){
        List<DemandDetail> demandList=demandDetailMapper.selectDemandDetailById(id);
        List<DemandVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandVO.class);
        return demandVOList;
    }

    public List<DemandVO> filterByParams(String industry, String region, String stage){
        List<DemandDetail> demandList=demandDetailMapper.filterByParams(industry, region, stage);
        List<DemandVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandVO.class);
        return demandVOList;
    }

    public List<DemandVO> searchByKeyword(String keyword){
        List<DemandDetail> demandList=demandDetailMapper.searchByKeyword(keyword);
        List<DemandVO> demandVOList=new ArrayList<>();
        demandVOList= BeanUtil.copyList(demandList,DemandVO.class);
        return demandVOList;
    }

    public List<String> getAllIndustry() {
        List<String> industryList = demandDetailMapper.getAllIndustry();
        return industryList;
    }

    public List<String> getAllRegion() {
        List<String> regionList = demandDetailMapper.getAllRegion();
        return regionList;
    }
    public List<String> getAllStage() {
        List<String> stageList = demandDetailMapper.getAllStage();
        return stageList;
    }

}
