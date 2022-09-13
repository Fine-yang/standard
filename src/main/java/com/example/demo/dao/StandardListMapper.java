package com.example.demo.dao;

import com.example.demo.entity.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface StandardListMapper {
    List<Standard> selectStandardList();
    List<String> getAllIndustry();
    List<String> getAllRegion();
    List<Standard> filterByParams(@Param("industry")String industry, @Param("region")String region, @Param("effectiveness")String effectiveness);
    List<Standard> searchByKeyword(@Param("keyword")String keyword);
}
