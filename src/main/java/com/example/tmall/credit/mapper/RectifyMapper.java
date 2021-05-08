package com.example.tmall.credit.mapper;

import com.example.tmall.credit.entity.Rectify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RectifyMapper {
    List<Rectify> findAllRectify();
    List<Rectify> findAllRectifyByServiceID(int service_id);
}
