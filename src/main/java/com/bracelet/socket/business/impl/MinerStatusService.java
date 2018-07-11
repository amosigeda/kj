package com.bracelet.socket.business.impl;

import io.netty.channel.Channel;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bracelet.dto.SocketBaseDto;
import com.bracelet.dto.SocketLoginDto;
import com.bracelet.service.IMinerStatusService;

/**
 * minerStatus业务
 * 
 */
@Component("minerStatusService")
public class MinerStatusService extends AbstractBizService{
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    IMinerStatusService IMinerStatusService;

   // {"a": 0,"type": 12,"no": "12312312","timestamp": 1501123709,"data":{"summary":{"elapsed":"4m37s","rt":"3933.770","avg":"3945.48","foundblocks":"0","localwork":"4174"},"antminer":{"chain":"1","acic":"63","frequency":"550","rt":"0","hw":"1","pcb":"62","chip":"93"},"pool0":{"url":"Stream+tcp://stratum.f2pool.com:3333","user":"wfj.1","status":"Alive","diff":"8.19k","getworks":"16","priority":"0","accepted":"109","diff1#":"0","diffA#":"222.208","diffR#":"0"},"pool1":{"url":"Stream+tcp://stratum.f2pool.com:3333","user":"wfj.1","status":"Alive","diff":"8.19k","getworks":"16","priority":"0","accepted":"109","diff1#":"0","diffA#":"222.208","diffR#":"0"},"pool2":{"url":"Stream+tcp://stratum.f2pool.com:3333","user":"wfj.1","status":"Alive","diff":"8.19k","getworks":"16","priority":"0","accepted":"109","diff1#":"0","diffA#":"222.208","diffR#":"0"},"timestamp": 1501123709}}
    
    
    public SocketBaseDto process1(SocketLoginDto socketLoginDto, JSONObject jsonObject, Channel channel) {
    	JSONObject jsonObject2 = (JSONObject) jsonObject.get("data");
    	logger.info("===实时状态：" + jsonObject.toJSONString());
       
    	String  imei  = socketLoginDto.getImei();
    	long timestamp = jsonObject2.getLongValue("timestamp");
    	
    	IMinerStatusService.insert(imei,jsonObject.toJSONString(),new Timestamp(timestamp * 1000));
    	
    	JSONObject summary = (JSONObject) JSON.parse(jsonObject2.getString("summary"));
        String elapsed = summary.getString("elapsed");
        String rts = summary.getString("rt");
        String avg = summary.getString("avg");
        String foundblocks = summary.getString("foundblocks");
        String localwork = summary.getString("localwork");
        
        JSONObject antminer=(JSONObject) JSON.parse(jsonObject2.getString("antminer"));
        String chain = antminer.getString("chain");
        String acic = antminer.getString("acic");
        String frequency = antminer.getString("frequency");
        String rta = antminer.getString("rt");
        String hw = antminer.getString("hw");
        String pcb = antminer.getString("pcb");
        String chip = antminer.getString("chip");
        
        JSONObject pool0=(JSONObject) JSON.parse(jsonObject2.getString("pool0"));
        String url0 = pool0.getString("url");
        String user0 = pool0.getString("user");
        String status0  = pool0.getString("status");
        String diff0 = pool0.getString("diff");
        String getworks0 = pool0.getString("getworks");
        String priority0 = pool0.getString("priority");
        String accepted0 = pool0.getString("accepted");
        String diff10 = pool0.getString("diff1#");
        String diffA0 = pool0.getString("diffA#");
        String diffR0 = pool0.getString("diffR#");
        
        JSONObject pool1=(JSONObject) JSON.parse(jsonObject2.getString("pool1"));
        String url1 = pool1.getString("url");
        String user1 = pool1.getString("user");
        String status1  = pool1.getString("status");
        String diff1 = pool1.getString("diff");
        String getworks1 = pool1.getString("getworks");
        String priority1 = pool1.getString("priority");
        String accepted1 = pool1.getString("accepted");
        String diff11 = pool1.getString("diff1#");
        String diffA1 = pool1.getString("diffA#");
        String diffR1 = pool1.getString("diffR#");
        
        JSONObject pool2=(JSONObject) JSON.parse(jsonObject2.getString("pool2"));
        String url2 = pool2.getString("url");
        String user2 = pool2.getString("user");
        String status2  = pool2.getString("status");
        String diff2 = pool2.getString("diff");
        String getworks2 = pool2.getString("getworks");
        String priority2 = pool2.getString("priority");
        String accepted2 = pool2.getString("accepted");
        String diff12 = pool2.getString("diff1#");
        String diffA2 = pool2.getString("diffA#");
        String diffR2 = pool2.getString("diffR#");
        
      

        SocketBaseDto dto = new SocketBaseDto();
        dto.setType(jsonObject.getIntValue("type"));
        dto.setNo(jsonObject.getString("no"));
        dto.setTimestamp(new Date().getTime());
        dto.setStatus(0);
        return dto;
    }
}
