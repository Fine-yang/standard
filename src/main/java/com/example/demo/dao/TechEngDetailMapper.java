package com.example.demo.dao;

import com.example.demo.entity.TechEngEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TechEngDetailMapper {
    List<TechEngEntity> selectTechEngDetailById(String NO);
}
