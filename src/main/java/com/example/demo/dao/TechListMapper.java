package com.example.demo.dao;

import com.example.demo.entity.TechEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface TechListMapper {
    //获得全部信息
    List<TechEntity> selectTechList();

    //四个筛选项
    List<String> getAllCountry();
    List<String> getAllIndustry();
    List<String> getAllProductionStage();
    List<String> getAllFields();

    //筛选+搜索
    List<TechEntity> filterByParams(@Param("industry")String industry, @Param("country")String country, @Param("productionStage")String effectiveness, @Param("fields")String fields);
    List<TechEntity> searchByKeyword(@Param("keyword")String keyword);
}
