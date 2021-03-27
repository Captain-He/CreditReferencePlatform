package com.zzu.he.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.zzu.he.entity.ProductInfo;
import com.zzu.he.service.ProService;
import com.zzu.he.tools.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Sys")
public class ProductDeal {
	@Autowired
	ProService proService ;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/getAllInfo")
	@ResponseBody
	public Object getAllInfo( @RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<ProductInfo> allPro = proService.findAllPro(map);
		int total = proService.proCount();

		Layui l = Layui.data(total, allPro);
		return JSON.toJSON(l);
	}

	@RequestMapping(value = "/getSigalInfo")
	@ResponseBody
	public Object getSigalInfo( @RequestParam("service_id") int service_id) {
		Map<String, Object> map = new HashMap<>();
		ProductInfo sigalPro = proService.findProById(service_id);
		map.put("pro",sigalPro);
		System.out.println(sigalPro);
		return JSON.toJSON(map);
	}

}
