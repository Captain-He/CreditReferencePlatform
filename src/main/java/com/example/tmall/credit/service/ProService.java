package com.example.tmall.credit.service;

import com.example.tmall.credit.entity.ProductInfo;
import com.example.tmall.credit.entity.ProductScore;

import java.util.List;
import java.util.Map;


public interface ProService {

	public List<ProductScore> findAllPro(Map<String, Object> map);

	public List<ProductInfo> findAll();

	public List<ProductInfo> findProByName(String name, int start, int pagesize);

	public int proCount();

	public List<ProductScore> getProductScore1(List<ProductInfo> productInfoList);

	public List<ProductScore> getProductScore2(List<ProductScore> productScoreList);

	public List<ProductScore> getProductScore3(List<ProductScore> productScoreList);

	public List<ProductScore> findProInfoByID(int service_id);

	public List<Double> getProductInfo(int service_id);

	public List<Double> getAverage(List<ProductInfo> productInfoList);
}
