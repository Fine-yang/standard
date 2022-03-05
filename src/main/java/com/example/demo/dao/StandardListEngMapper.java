package com.example.demo.dao;

import com.example.demo.entity.Standard;
import com.example.demo.entity.StandardEng;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StandardListEngMapper {

    List<StandardEng> selectStandardEngList();
}
