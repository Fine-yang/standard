package com.example.demo.service;

import com.example.demo.controller.vo.StandardEngVO;
import com.example.demo.controller.vo.StandardVO;
import com.example.demo.dao.StandardDetailEngMapper;
import com.example.demo.dao.StandardListEngMapper;
import com.example.demo.entity.Standard;
import com.example.demo.entity.StandardEng;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandardEngService {
    @Autowired
    private StandardListEngMapper standardListEngMapper;
    @Autowired
    private StandardDetailEngMapper standardDetailEngMapper;

    public List<StandardEngVO> getStandardEngList(){
        List<StandardEng> standardEngList=standardListEngMapper.selectStandardEngList();
        List<StandardEngVO> standardEngVOList=new ArrayList<>();
        standardEngVOList= BeanUtil.copyList(standardEngList,StandardEngVO.class);
        return standardEngVOList;
    }

    public List<StandardEngVO> getStandardDetailEngById(int id){
        List<StandardEng> standardEngList=standardDetailEngMapper.selectStandardDetailEngById(id);
        List<StandardEngVO> standardEngVOList=new ArrayList<>();
        standardEngVOList= BeanUtil.copyList(standardEngList,StandardEngVO.class);
        return standardEngVOList;
    }

    public List<String> getAllIndustryEng() {
        List<String> industryList = standardListEngMapper.getAllIndustryEng();
        return industryList;
    }

    public List<String> getAllRegionEng() {
        List<String> regionList = standardListEngMapper.getAllRegionEng();
        return regionList;
    }

    public List<StandardEngVO> filterByParamsEng(String industry, String region, String effectiveness){
        List<StandardEng> standardList=standardListEngMapper.filterByParamsEng(industry, region, effectiveness);
        List<StandardEngVO> standardVOList=new ArrayList<>();
        standardVOList= BeanUtil.copyList(standardList,StandardEngVO.class);
        return standardVOList;
    }

    public List<StandardEngVO> searchByKeywordEng(String keyword){
        List<StandardEng> standardList=standardListEngMapper.searchByKeywordEng(keyword);
        List<StandardEngVO> standardVOList = new ArrayList<>();
        standardVOList= BeanUtil.copyList(standardList,StandardEngVO.class);
        return standardVOList;
    }
}
