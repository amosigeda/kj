package com.bracelet.service;

import java.sql.Timestamp;

import com.bracelet.entity.BloodSugar;


public interface IMinerStatusService {
	boolean insert( String imei, String info,Timestamp timestamp);
}
