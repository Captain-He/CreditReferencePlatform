package com.example.tmall.credit.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.example.tmall.credit.entity.ProductScore;
import com.example.tmall.credit.service.ProService;
import com.example.tmall.credit.service.impl.EvaluateServiceImpl;
import com.example.tmall.credit.service.impl.ProcessServiceImpl;
import com.example.tmall.credit.tools.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Sys")
public class ProductDeal {
	@Autowired
	ProService proService ;
	@Resource(name = "evaluateService")
	EvaluateServiceImpl evaluateService;
	@Resource(name = "processService")
	ProcessServiceImpl processService;

	@RequestMapping(value = "/getAllInfo")
	@ResponseBody
	public Object getAllInfo( @RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<ProductScore> allPro = proService.findAllPro(map);
		int total = proService.proCount();

		Layui l = Layui.data(total, allPro);
		return JSON.toJSON(l);
	}
	@RequestMapping(value = "/getProInfoByID")
	@ResponseBody
	public Object getProByID(@RequestParam("service_id") String service_id){
		int ser_id = Integer.parseInt(service_id);
		System.out.println("service_id="+ser_id);
		List<ProductScore> productScoreList = proService.findProInfoByID(ser_id);
		System.out.println(productScoreList);
		return productScoreList;
	}
	@RequestMapping(value = "/radarChart")
	@ResponseBody
	public List getProductByID(@RequestParam String service_id){
		//part1雷达图
		System.out.println("service_id========================="+service_id);
		int ser_id = Integer.parseInt(service_id);
		List<Double> doubleList = proService.getProductInfo(ser_id);
		return doubleList;
	}

	@RequestMapping(value = "/radarChart3")
	@ResponseBody
	public Object getEvaluateByID(@RequestParam String service_id){
		//返回产品评价的平均评分和各个特性评分，即Part3
		int ser_id = Integer.parseInt(service_id);
		Map<String,Object> map = evaluateService.getEvaluateInfoByServiceID(ser_id);
		//test1 有形性，test2 可靠性，test3 响应性，test4 保证性，test5 移情性，score，总得分
		return map;
	}

	@RequestMapping(value = "/radarChart2")
	@ResponseBody
	public Map<String,Object> getProcessDataByID(@RequestParam String service_id){
		//返回Part2详细信息的直方图和统计数据
		int ser_id = Integer.parseInt(service_id);
		Map<String,Object> map = processService.getProcessData(ser_id);
		return map;
	}

}
