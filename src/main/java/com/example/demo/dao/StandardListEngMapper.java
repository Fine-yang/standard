package com.example.demo.dao;

import com.example.demo.entity.Standard;
import com.example.demo.entity.StandardEng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardListEngMapper {

    List<StandardEng> selectStandardEngList();
    List<String> getAllIndustryEng();
    List<String> getAllRegionEng();
    List<StandardEng> filterByParamsEng(@Param("industry")String industry, @Param("region")String region, @Param("effectiveness")String effectiveness);
    List<StandardEng> searchByKeywordEng(@Param("keyword")String keyword);
}
