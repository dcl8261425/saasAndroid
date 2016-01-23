package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class ConpanyZoneRet {
	private long id;
	private long conpanyId;
	private String content;
	private long createUserId;
	private String createUserName;
	private long groupId;
	private long conpanyZoneId;
	private Date createDate;
	private int indexNum;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getConpanyZoneId() {
		return conpanyZoneId;
	}
	public void setConpanyZoneId(long conpanyZoneId) {
		this.conpanyZoneId = conpanyZoneId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getIndexNum() {
		return indexNum;
	}
	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}
}
