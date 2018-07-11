package com.bracelet.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bracelet.dto.HttpBaseDto;
import com.bracelet.dto.SocketLoginDto;
import com.bracelet.entity.GeneralSettingsRequest;
import com.bracelet.entity.LocationRequest;
import com.bracelet.entity.SettingRequest;
import com.bracelet.entity.UserInfo;
import com.bracelet.exception.BizException;
import com.bracelet.util.ChannelMap;
import com.bracelet.util.RanomUtil;
import com.bracelet.util.RespCode;

@Controller
@RequestMapping("/generalsetting")
public class GeneralSettingsController extends BaseController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping(value = "/gs", method = RequestMethod.POST)
	public String GsSetting(@RequestBody String json) {
		logger.info("generalsetting="+json);
		JSONObject jsonObject = (JSONObject) JSON.parse(json);
        String imei =jsonObject.getString("imei");
		
		SocketLoginDto socketLoginDto = ChannelMap.getChannel(imei);
		if (socketLoginDto == null || socketLoginDto.getChannel() == null) {
			logger.info("socketLoginDto error.no login.imei:" + imei);
			return "2";
		}

		GeneralSettingsRequest re = new GeneralSettingsRequest();
		re.setA(0);
		re.setTimestamp(System.currentTimeMillis() / 1000);
		re.setType(20);
		re.setNo(UUID.randomUUID().toString().replaceAll("-", ""));
		re.setPassword1(jsonObject.getString("password1"));
		re.setPassword2(jsonObject.getString("password2"));
		re.setPassword3(jsonObject.getString("password3"));
		re.setUrl1(jsonObject.getString("url1"));
		re.setUrl2(jsonObject.getString("url2"));
		re.setUrl3(jsonObject.getString("url3"));
		re.setWorker1(jsonObject.getString("worker1"));
		re.setWorker2(jsonObject.getString("worker2"));
		re.setWorker3(jsonObject.getString("worker3"));
		
		if (socketLoginDto.getChannel().isActive()) {
			socketLoginDto.getChannel().writeAndFlush(JSON.toJSONString(re) + "\r\n");
			logger.info("===request GeneralSettingsController...ip:" + socketLoginDto.getChannel().remoteAddress().toString()
					+ ",data:" + JSON.toJSONString(re));
		} else {
			logger.info("socketLoginDto error.no login.not active.imei:" + imei);
			return "0";
		}

		return "1";
	}
	
	@ResponseBody
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public String Setting(@RequestBody String json) {
		logger.info("SettingsController="+json);
		JSONObject jsonObject = (JSONObject) JSON.parse(json);
        String imei =jsonObject.getString("imei");
		
		SocketLoginDto socketLoginDto = ChannelMap.getChannel(imei);
		if (socketLoginDto == null || socketLoginDto.getChannel() == null) {
			logger.info("socketLoginDto error.no login.imei:" + imei);
			return "2";
		}

		SettingRequest re = new SettingRequest();
		re.setA(0);
		re.setTimestamp(System.currentTimeMillis() / 1000);
		re.setType(21);
		re.setNo(UUID.randomUUID().toString().replaceAll("-", ""));
		re.setDnssercers(jsonObject.getString("dnssercers"));
		re.setGateway(jsonObject.getString("gateway"));
		re.setHostname(jsonObject.getString("hostname"));
		re.setIpaddress(jsonObject.getString("ipaddress"));
		re.setNetmask(jsonObject.getString("netmask"));
		re.setProtocol(jsonObject.getString("protocol"));

		if (socketLoginDto.getChannel().isActive()) {
			socketLoginDto.getChannel().writeAndFlush(JSON.toJSONString(re) + "\r\n");
			logger.info("===request SettingsController...ip:" + socketLoginDto.getChannel().remoteAddress().toString()
					+ ",data:" + JSON.toJSONString(re));
		} else {
			logger.info("socketLoginDto error.no login.not active.imei:" + imei);
			return "0";
		}

		return "1";
	}
	

}


