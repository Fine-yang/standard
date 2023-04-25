package com.example.demo.service;

import com.example.demo.controller.vo.TechEntityVO;
import com.example.demo.dao.TechDetailMapper;
import com.example.demo.dao.TechListMapper;
import com.example.demo.entity.TechEntity;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechService {
    @Autowired
    private TechListMapper techListMapper;
    @Autowired
    private TechDetailMapper techDetailMapper;

    public List<TechEntityVO> getTechList(){
        List<TechEntity> techEntityList=techListMapper.selectTechList();
        List<TechEntityVO> techEntityVOList=new ArrayList<>();
        techEntityVOList= BeanUtil.copyList(techEntityList,TechEntityVO.class);
        return techEntityVOList;
    }

    public List<TechEntityVO> getTechDetailById(String NO){
        List<TechEntity> techEntityList=techDetailMapper.selectTechDetailById(NO);
        List<TechEntityVO> techEntityVOList=new ArrayList<>();
        techEntityVOList= BeanUtil.copyList(techEntityList,TechEntityVO.class);
        return techEntityVOList;
    }

    public List<TechEntityVO> filterByParams(String industry, String country, String productionStage, String fields){
        List<TechEntity> techEntityList=techListMapper.filterByParams(industry, country, productionStage, fields);
        List<TechEntityVO> techEntityVOList=new ArrayList<>();
        techEntityVOList= BeanUtil.copyList(techEntityList,TechEntityVO.class);
        return techEntityVOList;
    }

    public List<TechEntityVO> searchByKeyword(String keyword){
        List<TechEntity> techEntityList=techListMapper.searchByKeyword(keyword);
        List<TechEntityVO> techEntityVOList=new ArrayList<>();
        techEntityVOList= BeanUtil.copyList(techEntityList,TechEntityVO.class);
        return techEntityVOList;
    }

    public List<String> getAllIndustry() {
        List<String> industryList = techListMapper.getAllIndustry();
        return industryList;
    }

    public List<String> getAllCountry() {
        List<String> countryList = techListMapper.getAllCountry();
        return countryList;
    }

    public List<String> getAllProductionStage(){
        List<String> productionStageList=techListMapper.getAllProductionStage();
        return productionStageList;
    }

    public List<String> getAllFields(){
        List<String> fieldsList=techListMapper.getAllFields();
        return fieldsList;
    }
}
