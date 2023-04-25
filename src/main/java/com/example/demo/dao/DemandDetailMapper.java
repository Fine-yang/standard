package com.example.demo.dao;

import com.example.demo.entity.DemandDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemandDetailMapper {
    List<DemandDetail> selectDemandList();
    List<String> getAllIndustry();
    List<String> getAllRegion();
    List<String> getAllStage();
    List<DemandDetail> filterByParams(@Param("industry")String industry, @Param("region")String region, @Param("stage")String stage);
    List<DemandDetail> searchByKeyword(@Param("keyword")String keyword);
    List<DemandDetail> selectDemandDetailById(int demand_id);
}
