package com.bracelet.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/test")
public class TestContorller {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String Post(@RequestBody String json) {
		logger.info(json);
		JSONObject jsonObject = (JSONObject) JSON.parse(json);

		System.out.println(jsonObject.getString("a"));

		JSONObject bb = new JSONObject();
		bb.put("CODES", 500);
		bb.put("CODEssS", 500);
		bb.put("CODEsS", 500);
		bb.put("CODEssssS", 500);
		return bb.toString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String register(@RequestParam String username, @RequestParam String password, ModelMap model) {

		if ("admin".equals(username) && "123456".equals(password)) {

			return "loginSuccess";
		} else {
			return "loginfail";
		}

	}

	@RequestMapping(value = "/loginGet/{code}/{paw}", method = RequestMethod.GET)
	public String getAuthCode(@PathVariable String code, @PathVariable String paw, ModelMap model) {

		if ("admin".equals(code) && "123456".equals(paw)) {
			model.put("msg", code + "登录成功！");
			return "login/loginSuccess";
		} else {
			model.put("msg", code + "登录失败");
			return "login/loginFail";
		}

	}

	// 加requestbody就不可以跳转了
	@RequestMapping("/data/teset/{link}")
	public String dataShareTest(@PathVariable String link, ModelMap model) {

		Map<String, Object> heartPressureDataMap = new HashMap<>();
		heartPressureDataMap.put("q", "1");
		heartPressureDataMap.put("w", "2");
		heartPressureDataMap.put("e", "3");
		heartPressureDataMap.put("r", "4");
		heartPressureDataMap.put("t", "5");

		model.put("map", heartPressureDataMap);
		model.put("timestamp", link);
		model.addAttribute("test", "wetiechao");
		return "testMap/test";

	}

}
