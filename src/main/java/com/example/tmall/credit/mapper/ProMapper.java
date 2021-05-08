package com.example.tmall.credit.mapper;

import com.example.tmall.credit.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProMapper {

	List<ProductInfo> findAllPro(Map<String, Object> map);

	List<ProductInfo> findAll();

	List<ProductInfo> findProInfoByID(int service_id);

	List<ProductInfo> findProByName(String name, int start, int pagesize);

	int ProCount();
	List<ProductInfo> getProduct(int service_id);

}
