package com.example.tmall.credit.service.impl;

import com.example.tmall.credit.entity.ProductInfo;
import com.example.tmall.credit.entity.ProductScore;
import com.example.tmall.credit.mapper.ProMapper;
import com.example.tmall.credit.service.ProService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProServiceImpl implements ProService {

	@Resource
	private ProMapper proMapper;
	@Resource(name = "evaluateService")
	EvaluateServiceImpl evaluateService;
	@Resource(name = "processService")
	ProcessServiceImpl processService;

	
	@Override
	public List<ProductScore> findAllPro(Map<String, Object> map) {
		List<ProductInfo> productInfoList = proMapper.findAllPro(map);
		List<ProductScore> productScoreList1 = getProductScore1(productInfoList);//得到服务产品信息的分数
		List<ProductScore> productScoreList3 = getProductScore3(productScoreList1);//得到Part3的分数
		List<ProductScore> productScoreList2 = getProductScore2(productScoreList3);//得到Part2的分数
		return productScoreList2;//返回每个产品的三个得分
	}

	@Override
	public List<ProductInfo> findProByName(String name, int start, int pagesize) {
		// TODO Auto-generated method stub
		return proMapper.findProByName(name, start, pagesize);
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

	@Override
	public List<ProductScore> getProductScore1(List<ProductInfo> productInfoList){
		//根据id得到服务产品信息得分，即part1得分
		List<ProductScore> productScoreList1 = new ArrayList<>();
		for(ProductInfo productInfo : productInfoList){
			int score1 = 0;
			//将信息储存至productScore中
			ProductScore productScore = new ProductScore(productInfo.getService_id(),productInfo.getService_name(),productInfo.getService_intro()
					,productInfo.getService_people(),productInfo.getService_device(),productInfo.getService_phone(),productInfo.getService_duration()
					,productInfo.getService_price(),productInfo.getService_post(),productInfo.getService_complaint(),productInfo.getService_confirmtime()
					,productInfo.getService_dispatchtime(),productInfo.getService_procedure(),productInfo.getService_legalinfo(),productInfo.getService_audience()
					,productInfo.getService_personalize(),productInfo.getSeller_id());
			//有形性
			if(productScore.getService_name()!=null)score1+=10;
			if(productScore.getService_intro()!=null)score1+=10;
			if(productScore.getService_people()!=null)score1+=10;
			if(productScore.getService_device()!=null)score1+=5;
			//可靠性
			if(productScore.getService_phone()!=null)score1+=7;
			if(productScore.getService_duration()!=null)score1+=7;
			if(productScore.getService_price()!=null)score1+=7;
			if(productScore.getService_post()!=null)score1+=5;
			if(productScore.getService_complaint()!=null)score1+=5;
			//响应性
			if(productScore.getService_confirmtime()!=null)score1+=5;
			if(productScore.getService_dispatchtime()!=null)score1+=5;
			//保证性
			if(productScore.getService_procedure()!=null)score1+=7;
			if(productScore.getService_legalinfo()!=null)score1+=5;
			//移情性
			if(productScore.getService_audience()!=null)score1+=7;
			if(productScore.getService_personalize()!=null)score1+=5;
			productScore.setScore1(score1);
			productScoreList1.add(productScore);
		}
		return productScoreList1;
	}
	@Override
	public List<ProductScore> getProductScore2(List<ProductScore> productScoreList) {
		List<ProductScore> productScoreList2 = new ArrayList<>();
		for(ProductScore productScore : productScoreList){
			ProductScore productScore2 = new ProductScore(productScore.getService_id(),productScore.getService_name(),productScore.getService_intro()
					,productScore.getService_people(),productScore.getService_device(),productScore.getService_phone(),productScore.getService_duration()
					,productScore.getService_price(),productScore.getService_post(),productScore.getService_complaint(),productScore.getService_confirmtime()
					,productScore.getService_dispatchtime(),productScore.getService_procedure(),productScore.getService_legalinfo(),productScore.getService_audience()
					,productScore.getService_personalize(),productScore.getSeller_id());
			productScore2.setScore1(productScore.getScore1());
			productScore2.setScore3(productScore.getScore3());
			Map<String,Object> map = processService.getProcessAVGByServiceID(productScore.getService_id());//得到服务过程得分
			double rectifyAvg = processService.getRectifyByServiceID(productScore.getService_id());
			productScore2.setScore2(((Double) map.get("score2")+rectifyAvg));
			productScoreList2.add(productScore2);
		}
		return productScoreList2;
	}
	@Override
	public List<ProductScore> getProductScore3(List<ProductScore> productScoreList){
		List<ProductScore> productScoreList3 = new ArrayList<>();
		for(ProductScore productScore : productScoreList){
			ProductScore productScore3 = new ProductScore(productScore.getService_id(),productScore.getService_name(),productScore.getService_intro()
					,productScore.getService_people(),productScore.getService_device(),productScore.getService_phone(),productScore.getService_duration()
					,productScore.getService_price(),productScore.getService_post(),productScore.getService_complaint(),productScore.getService_confirmtime()
					,productScore.getService_dispatchtime(),productScore.getService_procedure(),productScore.getService_legalinfo(),productScore.getService_audience()
					,productScore.getService_personalize(),productScore.getSeller_id());
			productScore3.setScore1(productScore.getScore1());
			Map<String, Object> map = new HashMap<>();
			map = evaluateService.getEvaluateInfoByServiceID(productScore.getService_id());
			productScore3.setScore3((Double)map.get("score"));
			productScoreList3.add(productScore3);
		}
		return productScoreList3;
	}

	@Override
	public List<ProductScore> findProInfoByID(int service_id) {
		List<ProductInfo> productInfoList = proMapper.findProInfoByID(service_id);
		List<ProductScore> productScoreList1 = getProductScore1(productInfoList);
		List<ProductScore> productScoreList3 = getProductScore3(productScoreList1);
		List<ProductScore> productScoreList2 = getProductScore3(productScoreList3);
		return productScoreList2;
	}
	public List<Double> getProductInfo(int service_id){
		System.out.println("111");
		List<ProductInfo> productList = proMapper.getProduct(service_id);
		System.out.println("222s");
		System.out.println(productList.toString());
		List<Double> doubleList = getAverage(productList);
		return doubleList;
	}
	public List<Double> getAverage(List<ProductInfo> productList){
		int num = productList.size();
		int score1 = 0;//有形性总分
		int score2 = 0;//移情性总分
		int score3 = 0;//保证性总分
		int score4 = 0;//响应性总分
		int score5 = 0;//可靠性总分
		for(ProductInfo product:productList){
			//有形性总分
			if(product.getService_name()!=null)score1+=10;
			if(product.getService_intro()!=null)score1+=10;
			if(product.getService_people()!=null)score1+=10;
			if(product.getService_device()!=null)score1+=5;
			//移情性
			if(product.getService_audience()!=null)score2+=7;
			if(product.getService_personalize()!=null)score2+=5;

			//保证性
			if(product.getService_procedure()!=null)score3+=7;
			if(product.getService_legalinfo()!=null)score3+=5;
			//响应性
			if(product.getService_confirmtime().equals("1"))score4+=5;
			if(product.getService_dispatchtime().equals("1"))score4+=5;
			//可靠性总分
			if(product.getService_phone()!=null)score5+=7;
			if(product.getService_duration()!=null)score5+=7;
			if(product.getService_price()!=null)score5+=7;
			if(product.getService_post()!=null)score5+=5;
			if(product.getService_complaint()!=null)score5+=5;
		}
		if(num!=0) {
			double d1 = score1 / num;//有形性AVG
			double d2 = score2 / num;//移情性AVG
			double d3 = score3 / num;//保证性AVG
			double d4 = score4 / num;//响应性AVG
			double d5 = score5 / num;//可靠性AVG
			List<Double> doubleList = Arrays.asList(d1, d2, d3, d4, d5);
			return doubleList;
		}else{
			List<Double> doubleList = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);
			return doubleList;
		}

	}



}
