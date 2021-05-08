package com.example.tmall.credit.service.impl;

import com.example.tmall.credit.entity.Process;
import com.example.tmall.credit.entity.Rectify;
import com.example.tmall.credit.mapper.ProcessMapper;
import com.example.tmall.credit.mapper.RectifyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("processService")
public class ProcessServiceImpl {
    @Resource
    ProcessMapper processMapper;
    @Resource
    RectifyMapper rectifyMapper;
    public Map<String,Object> getProcessAVGByServiceID(int service_id){
        List<Process> processList = processMapper.findAllProcessByServiceID(service_id);
        return getProcessAverage(processList);
    }

    public double getRectifyByServiceID(int service_id){
        List<Rectify> rectifyList = rectifyMapper.findAllRectifyByServiceID(service_id);
        return getRectifyAverage(rectifyList);
    }

    public Map<String,Object> getProcessAverage(List<Process> processList){
        int sum = 0 ;
        int num = processList.size();
        if(num == 0){
            Map<String,Object> map = new HashMap<>();
            map.put("score2",0.0);
            return map;
        }
        else{
            for(Process process : processList){
                if(process.getCertain_time().equals("A"))sum+=10;
                if(process.getCertain_time().equals("B"))sum+=7;
                if(process.getCertain_time().equals("C"))sum+=3;
                if(process.getCertain_time().equals("D"))sum-=2;

                if(process.getDispatch_time().equals("A"))sum+=10;
                if(process.getDispatch_time().equals("B"))sum+=7;
                if(process.getDispatch_time().equals("C"))sum+=3;
                if(process.getDispatch_time().equals("D"))sum-=2;

                if(process.getExecute_time().equals("A"))sum+=5;
                if(process.getExecute_time().equals("B"))sum+=10;
                if(process.getExecute_time().equals("C"))sum+=15;
                if(process.getExecute_time().equals("D"))sum+=20;
                if(process.getExecute_time().equals("E"))sum+=25;
                if(process.getExecute_time().equals("F"))sum+=32;
                if(process.getExecute_time().equals("G"))sum+=40;

                if(process.getService_exception().equals("A"))sum+=30;
                if(process.getService_exception().equals("B"))sum+=30;
                if(process.getService_exception().equals("C"))sum+=28;
                if(process.getService_exception().equals("D"))sum+=25;
                if(process.getService_exception().equals("E"))sum+=15;
                if(process.getService_exception().equals("F"))sum-=5;
                if(process.getService_exception().equals("G"))sum+=30;
                if(process.getService_exception().equals("H"))sum+=26;
                if(process.getService_exception().equals("I"))sum+=17;
                if(process.getService_exception().equals("J"))sum+=10;
                if(process.getService_exception().equals("K"))sum-=5;
                if(process.getService_exception().equals("L"))sum+=30;
                if(process.getService_exception().equals("M"))sum-=10;
                if(process.getService_exception().equals("N"))sum+=10;
                if(process.getService_exception().equals("O"))sum+=10;
                if(process.getService_exception().equals("P"))sum+=5;
                if(process.getService_exception().equals("Q"))sum-=10;
            }
            Map<String,Object> map = new HashMap<>();
            double avg = sum / num ;
            map.put("score2",avg);
            //上面的还没改
            return map;
        }

    }

    public double getRectifyAverage(List<Rectify> rectifyList){
        int sum = 0 ;//服务整改总得分
        int num = rectifyList.size();//取出的数据库条数
        if(num == 0){
            return 0.0;
        }else{
            for(Rectify rectify:rectifyList){
                if(rectify.getRectify_situation().equals("A"))sum+=10;
                if(rectify.getRectify_situation().equals("B"))sum-=10;
                if(rectify.getRectify_situation().equals("C"))sum+=20;
            }
            double avg = sum / num ;
            return avg;
        }

    }

    public List<Process> getProcessByID(int service_id){
        return processMapper.findAllProcessByServiceID(service_id);
    }
    public Map<String,Object> getProcessData(int service_id){
        List<Process> processList = getProcessByID(service_id);
        int interupt = 0;
        int value1 = 0, value2 = 0, value3 = 0;
        int value11 = 0, value12 = 0, value13 = 0;
        Map<String,Object> map = getProcessAVGByServiceID(service_id);
        for(Process process : processList){
            if(!"A".equals(process.getService_exception())) interupt++;
            if("B".equals(process.getService_exception())||
                    "C".equals(process.getService_exception())){
                value1++;
            }
            if("D".equals(process.getService_exception())||
                    "E".equals(process.getService_exception())||
                    "F".equals(process.getService_exception())){
                value11++;
            }
            if("G".equals(process.getService_exception())||
                    "H".equals(process.getService_exception())){
                value2++;
            }
            if("I".equals(process.getService_exception())||
                    "J".equals(process.getService_exception())||
                    "K".equals(process.getService_exception())){
                value12++;
            }
            if("L".equals(process.getService_exception())||
                    "M".equals(process.getService_exception())||
                    "N".equals(process.getService_exception())){
                value3++;
            }
            if("O".equals(process.getService_exception())||
                    "P".equals(process.getService_exception())||
                    "Q".equals(process.getService_exception())){
                value13++;
            }
        }
        Map<String,Object> objectMap = new HashMap<>();
        if(processList.size()==0){
            objectMap.put("test1",value1);
            objectMap.put("test2",value2);
            objectMap.put("test3",value3);
            objectMap.put("test11",value11);
            objectMap.put("test12",value12);
            objectMap.put("test13",value13);
            objectMap.put("message1",processList.size()); //共提供服务多少次
            objectMap.put("message2",0);//完成率
            objectMap.put("message3",interupt);//终止次数
            objectMap.put("message4",map.get("score2")); //总评分
        }else{
            int rate = 100-interupt*100/processList.size();
            objectMap.put("test1",value1);
            objectMap.put("test2",value2);
            objectMap.put("test3",value3);
            objectMap.put("test11",value11);
            objectMap.put("test12",value12);
            objectMap.put("test13",value13);
            objectMap.put("message1",processList.size()); //共提供服务多少次
            objectMap.put("message2",rate);//完成率
            objectMap.put("message3",interupt);//终止次数
            //objectMap.put("message4", (Integer) map.get("score2")); //总评分
            objectMap.put("message4", new Integer(((Double)map.get("score2")).intValue())); //总评分
        }
        return objectMap;
    }
}
