package com.example.tmall.credit.mapper;

import com.example.tmall.credit.entity.Process;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProcessMapper {
    List<Process> findAllProcess();
    List<Process> findAllProcessByServiceID(int service_id);
}
