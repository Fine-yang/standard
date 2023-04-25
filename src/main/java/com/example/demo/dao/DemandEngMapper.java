package com.example.demo.dao;

import com.example.demo.entity.DemandEng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemandEngMapper {
    List<DemandEng> selectDemandList();
    List<String> getAllIndustry();
    List<String> getAllRegion();
    List<String> getAllStage();
    List<DemandEng> filterByParams(@Param("industry")String industry, @Param("region")String region, @Param("stage")String stage);
    List<DemandEng> searchByKeyword(@Param("keyword")String keyword);
    List<DemandEng> selectDemandEngById(int demand_id);
}
