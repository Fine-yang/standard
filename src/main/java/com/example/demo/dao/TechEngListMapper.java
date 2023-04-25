package com.example.demo.dao;

import com.example.demo.entity.TechEngEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TechEngListMapper {
    //获得全部信息
    List<TechEngEntity> selectTechEngList();

    //四个筛选项
    List<String> getAllCountryEng();
    List<String> getAllIndustryEng();
    List<String> getAllProductionStageEng();
    List<String> getAllFieldsEng();

    //筛选+搜索
    List<TechEngEntity> filterByParamsEng(@Param("industry")String industry, @Param("country")String country, @Param("productionStage")String effectiveness, @Param("fields")String fields);
    List<TechEngEntity> searchByKeywordEng(@Param("keyword")String keyword);
}
