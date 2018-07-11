package com.bracelet.service.impl;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bracelet.entity.BloodSugar;
import com.bracelet.entity.HeartPressure;
import com.bracelet.service.IBloodSugarService;
import com.bracelet.service.IMinerStatusService;

/**
 * MinerStatus服务
 */
@Service
public class MinerStatusServiceImpl implements IMinerStatusService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	    @Autowired
	    JdbcTemplate jdbcTemplate;
		@Override
		public boolean insert(String imei, String info, Timestamp timestamp) {
			int i = jdbcTemplate.update(
					"insert into miner_status_info (imei, info, upload_time) values (?,?,?)",
					new Object[] { imei, info, timestamp },
					new int[] {  java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.TIMESTAMP });
			return i == 1;
		}
		
	
}
