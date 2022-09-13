package com.example.demo.service;

import com.example.demo.controller.vo.StandardVO;
import com.example.demo.dao.StandardDetailMapper;
import com.example.demo.dao.StandardListMapper;
import com.example.demo.entity.Standard;
import com.example.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandardService {
    @Autowired
    private StandardListMapper standardListMapper;
    @Autowired
    private StandardDetailMapper standardDetailMapper;

    public List<StandardVO> getStandardList(){
        List<Standard> standardList=standardListMapper.selectStandardList();
        List<StandardVO> standardVOList=new ArrayList<>();
        standardVOList= BeanUtil.copyList(standardList,StandardVO.class);
        return standardVOList;
    }

    public List<StandardVO> getStandardDetailById(int id){
        List<Standard> standardList=standardDetailMapper.selectStandardDetailById(id);
        List<StandardVO> standardVOList=new ArrayList<>();
        standardVOList= BeanUtil.copyList(standardList,StandardVO.class);
        return standardVOList;
    }

    public List<StandardVO> filterByParams(String industry, String region, String effectiveness){
        List<Standard> standardList=standardListMapper.filterByParams(industry, region, effectiveness);
        List<StandardVO> standardVOList=new ArrayList<>();
        standardVOList= BeanUtil.copyList(standardList,StandardVO.class);
        return standardVOList;
    }

    public List<StandardVO> searchByKeyword(String keyword){
        List<Standard> standardList=standardListMapper.searchByKeyword(keyword);
        List<StandardVO> standardVOList=new ArrayList<>();
        standardVOList= BeanUtil.copyList(standardList,StandardVO.class);
        return standardVOList;
    }

    public List<String> getAllIndustry() {
        List<String> industryList = standardListMapper.getAllIndustry();
        return industryList;
    }

    public List<String> getAllRegion() {
        List<String> regionList = standardListMapper.getAllRegion();
        return regionList;
    }
}
