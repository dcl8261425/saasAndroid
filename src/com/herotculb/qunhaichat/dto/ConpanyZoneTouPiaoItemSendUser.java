package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class ConpanyZoneTouPiaoItemSendUser {
	private long id;
	private long conpanyId;
	private long conpanyUserId;
	private long conpanyZoneTouPiaoItemId;
	private long groupId;
	private long conpanyZoneTouPiaoId;
	private String createDate;
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
	public long getConpanyUserId() {
		return conpanyUserId;
	}
	public void setConpanyUserId(long conpanyUserId) {
		this.conpanyUserId = conpanyUserId;
	}
	public long getConpanyZoneTouPiaoItemId() {
		return conpanyZoneTouPiaoItemId;
	}
	public void setConpanyZoneTouPiaoItemId(long conpanyZoneTouPiaoItemId) {
		this.conpanyZoneTouPiaoItemId = conpanyZoneTouPiaoItemId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getConpanyZoneTouPiaoId() {
		return conpanyZoneTouPiaoId;
	}
	public void setConpanyZoneTouPiaoId(long conpanyZoneTouPiaoId) {
		this.conpanyZoneTouPiaoId = conpanyZoneTouPiaoId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	private String createUserName;
}
