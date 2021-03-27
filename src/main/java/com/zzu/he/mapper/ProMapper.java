package com.zzu.he.mapper;

import java.util.List;
import java.util.Map;

import com.zzu.he.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProMapper {

	List<ProductInfo> findAllPro(Map<String, Object> map);

	List<ProductInfo> findAll();

	List<ProductInfo> findProByName(String name, int start, int pagesize);
	ProductInfo findProById(@Param("service_id") int service_id);

	int ProCount();
}
