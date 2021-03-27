package com.zzu.he.service;

import java.util.List;
import java.util.Map;

import com.zzu.he.entity.ProductInfo;


public interface ProService {

	public List<ProductInfo> findAllPro(Map<String, Object> map);

	public List<ProductInfo> findAll();

	public List<ProductInfo> findProByName(String name, int start, int pagesize);

	public ProductInfo findProById( int service_id);

	public int proCount();

}
