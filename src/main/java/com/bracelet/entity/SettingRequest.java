package com.bracelet.entity;

public class SettingRequest {
	private int a = 0;
	private String no;
	private int type;
	private long timestamp;
	private String hostname;
	private String protocol;
	private String ipaddress;
	private String netmask;
	private String gateway;
	private String dnssercers;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getDnssercers() {
		return dnssercers;
	}

	public void setDnssercers(String dnssercers) {
		this.dnssercers = dnssercers;
	}
	
}


