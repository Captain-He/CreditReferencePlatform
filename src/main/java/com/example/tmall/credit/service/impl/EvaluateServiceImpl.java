package com.example.tmall.credit.service.impl;

import com.example.tmall.credit.entity.Evaluate;
import com.example.tmall.credit.mapper.EvaluateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("evaluateService")
public class EvaluateServiceImpl {
    @Resource
    private EvaluateMapper evaluateMapper;
    public Map<String,Object> getEvaluateInfoBySellerID(int seller_id){
        List<Evaluate> evaluateList = evaluateMapper.getEvaluateBySellerID(seller_id);
        return getAverage(evaluateList);
    }
    public Map<String,Object> getEvaluateInfoByServiceID(int service_id){
        List<Evaluate> evaluateList = evaluateMapper.getEvaluateByServiceID(service_id);
        return getAverage(evaluateList);
    }
    public Map<String,Object> getAverage(List<Evaluate> evaluateList){
        int sum = 0;//总得分
        int s1 = 0,s2=0,s3=0,s4=0,s5 = 0;//有形性，可靠性，响应性，保证性，移情性得分
        int num = evaluateList.size();
        for(Evaluate evaluate:evaluateList){
            sum+=evaluate.getPlace_star()*2;
            sum+=evaluate.getService_person_star()*2;
            sum+=evaluate.getService_time_star()*2;
            sum+=evaluate.getService_price_star()*2;
            sum+=evaluate.getService_timely_star();
            sum+=evaluate.getService_respond_star();
            sum+=evaluate.getService_reasonable_star()*4;
            sum+=evaluate.getService_support_star()*4;
            sum+=evaluate.getService_clear_star();
            sum+=evaluate.getService_personalized_star();
            //有形性
            s1+=evaluate.getPlace_star();
            s1+=evaluate.getService_person_star();
            //可靠性
            s2+= evaluate.getService_time_star();
            s2+= evaluate.getService_price_star();
            //响应性
            s3+= evaluate.getService_timely_star();
            s3+= evaluate.getService_respond_star();
            //保证性
            s4+=evaluate.getService_reasonable_star();
            s4+=evaluate.getService_support_star();
            //移情性
            s5+=evaluate.getService_clear_star();
            s5+=evaluate.getService_personalized_star();
        }
        if(num!=0){
            double sumAvg = sum/num;//平均总得分
            Map<String,Object> map = new HashMap<>();
            map.put("score",sumAvg);
            map.put("test1",s1/(2*num));
            map.put("test2",s2/(2*num));
            map.put("test3",s3/(2*num));
            map.put("test4",s4/(2*num));
            map.put("test5",s5/(2*num));
            return map;
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("score",0.0);
            map.put("test1",0.0);
            map.put("test2",0.0);
            map.put("test3",0.0);
            map.put("test4",0.0);
            map.put("test5",0.0);
            return map;
        }
    }
}
