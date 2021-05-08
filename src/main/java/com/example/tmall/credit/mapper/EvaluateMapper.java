package com.example.tmall.credit.mapper;

import com.example.tmall.credit.entity.Evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluateMapper {
    List<Evaluate> getEvaluateBySellerID(int seller_id);
    List<Evaluate> getEvaluateByServiceID(int service_id);
}
