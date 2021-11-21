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

}
