package com.example.demo.dao;

import com.example.demo.entity.Standard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StandardListMapper {
    List<Standard> selectStandardList();

}
