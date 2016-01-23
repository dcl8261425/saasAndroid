package com.herotculb.qunhaichat.dto;

public class WeiXinWebHtmlDto {
	private long id;
	private String name;
	private String htmls;
	private long conpanyId;
	private String conpanyName;
	private long createUserId;
	private String createUserName;
	private boolean privates;//是否是私有，不是私有则所有公司都可以使用
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHtmls() {
		return htmls;
	}
	public void setHtmls(String htmls) {
		this.htmls = htmls;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getConpanyName() {
		return conpanyName;
	}
	public void setConpanyName(String conpanyName) {
		this.conpanyName = conpanyName;
	}
	public long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public boolean isPrivates() {
		return privates;
	}
	public void setPrivates(boolean privates) {
		this.privates = privates;
	}
}
