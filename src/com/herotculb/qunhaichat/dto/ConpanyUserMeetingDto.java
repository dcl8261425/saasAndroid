package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class ConpanyUserMeetingDto {
	private long id;
	private String conpanyUsertrueName;
	private long userId;
	private String startDate;
	private String endDate;
	private long conpanyId;
	private long stute;//状态，如：0未签到1迟到2早退3迟到加早退4外出5正常签到
	private String stuteMarks;//外出备注
	private String createDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConpanyUsertrueName() {
		return conpanyUsertrueName;
	}
	public void setConpanyUsertrueName(String conpanyUsertrueName) {
		this.conpanyUsertrueName = conpanyUsertrueName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public long getStute() {
		return stute;
	}
	public void setStute(long stute) {
		this.stute = stute;
	}
	public String getStuteMarks() {
		return stuteMarks;
	}
	public void setStuteMarks(String stuteMarks) {
		this.stuteMarks = stuteMarks;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
