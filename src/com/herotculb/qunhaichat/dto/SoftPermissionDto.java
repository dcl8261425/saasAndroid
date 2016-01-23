package com.herotculb.qunhaichat.dto;

public class SoftPermissionDto {
	private long id;
	private String functionName;//功能名
	private long uplevel;//上级功能id
	private String url;//功能的url
	private String marks;//备注
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public long getUplevel() {
		return uplevel;
	}
	public void setUplevel(long uplevel) {
		this.uplevel = uplevel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
}
