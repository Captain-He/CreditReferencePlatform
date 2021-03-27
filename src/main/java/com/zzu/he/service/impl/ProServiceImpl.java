package com.zzu.he.service.impl;

import java.util.List;
import java.util.Map;

import com.zzu.he.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzu.he.mapper.ProMapper;
import com.zzu.he.service.ProService;

@Service
public class ProServiceImpl implements ProService {

	@Autowired
	ProMapper proMapper;

	
	@Override
	public List<ProductInfo> findAllPro(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return proMapper.findAllPro(map);
	}

	@Override
	public List<ProductInfo> findProByName(String name, int start, int pagesize) {
		// TODO Auto-generated method stub
		return proMapper.findProByName(name, start, pagesize);
	}
	@Override
	public ProductInfo findProById( int service_id){
		return proMapper.findProById(service_id);
	}
	@Override
	public int proCount() {
		// TODO Auto-generated method stub
		return proMapper.ProCount();
	}

	@Override
	public List<ProductInfo> findAll() {
		// TODO Auto-generated method stub
		return proMapper.findAll();
	}


}
