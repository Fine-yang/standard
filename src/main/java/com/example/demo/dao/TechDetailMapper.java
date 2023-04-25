package com.example.demo.dao;

import com.example.demo.entity.TechEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TechDetailMapper {
    List<TechEntity> selectTechDetailById(String NO);
}
