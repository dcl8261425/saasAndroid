package com.herotculb.qunhaichat.dto;

public class VWiFiDto {
	private long id;
	private long conpanyId;
	private String name;
	private boolean useUp;
	private boolean webRigister;
	private String tokens;
	private String htmlContent;
	private String sys_uptime;//路由器启动时间
	private String sys_memfree;//系统剩余内存 kb
	private String sys_load;
	private String wifidog_uptime;//wifidog运行时间
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isUseUp() {
		return useUp;
	}
	public void setUseUp(boolean useUp) {
		this.useUp = useUp;
	}
	public boolean isWebRigister() {
		return webRigister;
	}
	public void setWebRigister(boolean webRigister) {
		this.webRigister = webRigister;
	}
	public String getTokens() {
		return tokens;
	}
	public void setTokens(String tokens) {
		this.tokens = tokens;
	}
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	public String getSys_uptime() {
		return sys_uptime;
	}
	public void setSys_uptime(String sys_uptime) {
		this.sys_uptime = sys_uptime;
	}
	public String getSys_memfree() {
		return sys_memfree;
	}
	public void setSys_memfree(String sys_memfree) {
		this.sys_memfree = sys_memfree;
	}
	public String getSys_load() {
		return sys_load;
	}
	public void setSys_load(String sys_load) {
		this.sys_load = sys_load;
	}
	public String getWifidog_uptime() {
		return wifidog_uptime;
	}
	public void setWifidog_uptime(String wifidog_uptime) {
		this.wifidog_uptime = wifidog_uptime;
	}
}
