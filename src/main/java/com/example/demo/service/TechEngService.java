package com.example.demo.service;

import com.example.demo.controller.vo.TechEngEntityVO;
import com.example.demo.dao.TechEngDetailMapper;
import com.example.demo.dao.TechEngListMapper;
import com.example.demo.entity.TechEngEntity;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechEngService {
    @Autowired
    private TechEngListMapper techEngListMapper;
    @Autowired
    private TechEngDetailMapper techEngDetailMapper;

    public List<TechEngEntityVO> getTechEngList(){
        List<TechEngEntity> techEngEntityList=techEngListMapper.selectTechEngList();
        List<TechEngEntityVO> techEngEntityVOList=new ArrayList<>();
        techEngEntityVOList= BeanUtil.copyList(techEngEntityList,TechEngEntityVO.class);
        return techEngEntityVOList;
    }

    public List<TechEngEntityVO> getTechEngDetailById(String NO){
        List<TechEngEntity> techEngEntityList=techEngDetailMapper.selectTechEngDetailById(NO);
        List<TechEngEntityVO> techEngEntityVOList=new ArrayList<>();
        techEngEntityVOList= BeanUtil.copyList(techEngEntityList,TechEngEntityVO.class);
        return techEngEntityVOList;
    }

    public List<TechEngEntityVO> filterByParamsEng(String industry, String country, String productionStage, String fields){
        List<TechEngEntity> techEngEntityList=techEngListMapper.filterByParamsEng(industry, country, productionStage, fields);
        List<TechEngEntityVO> techEngEntityVOList=new ArrayList<>();
        techEngEntityVOList= BeanUtil.copyList(techEngEntityList,TechEngEntityVO.class);
        return techEngEntityVOList;
    }

    public List<TechEngEntityVO> searchByKeywordEng(String keyword){
        List<TechEngEntity> techEngEntityList=techEngListMapper.searchByKeywordEng(keyword);
        List<TechEngEntityVO> techEngEntityVOList=new ArrayList<>();
        techEngEntityVOList= BeanUtil.copyList(techEngEntityList,TechEngEntityVO.class);
        return techEngEntityVOList;
    }

    public List<String> getAllIndustryEng() {
        List<String> industryList = techEngListMapper.getAllIndustryEng();
        return industryList;
    }

    public List<String> getAllCountryEng() {
        List<String> countryList = techEngListMapper.getAllCountryEng();
        return countryList;
    }

    public List<String> getAllProductionStageEng(){
        List<String> productionStageList=techEngListMapper.getAllProductionStageEng();
        return productionStageList;
    }

    public List<String> getAllFieldsEng(){
        List<String> fieldsList=techEngListMapper.getAllFieldsEng();
        return fieldsList;
    }
}
