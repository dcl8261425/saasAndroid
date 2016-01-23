package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class PerformanceDto {
	private long id;
	private String userTrueName;
	private long userId;
	private long conpanyId;
	private long myCreateChanceNum;//此人创建的机会数
	private long myCreateChanceBuyNum;//此人创建的机会输成交次数
	private double myCreateChanceBuyCountPrice;//此人创建的机会总成交价格
	private long toChanceNum;//此人被分配的数
	private long toChanceBuyNum;//此人被分配的机会总买数
	private double toChanceBuyCountPrice;//此人被分配机会的总成交价格
	private long meetingNum;//签到次数
	private String createDate;
	private long meetingOutNum;
	private long meetingLastNum;
	private long meetingLeave;
	private long meetingNumOut;//签退次数
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
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
	public long getMyCreateChanceNum() {
		return myCreateChanceNum;
	}
	public void setMyCreateChanceNum(long myCreateChanceNum) {
		this.myCreateChanceNum = myCreateChanceNum;
	}
	public long getMyCreateChanceBuyNum() {
		return myCreateChanceBuyNum;
	}
	public void setMyCreateChanceBuyNum(long myCreateChanceBuyNum) {
		this.myCreateChanceBuyNum = myCreateChanceBuyNum;
	}
	public double getMyCreateChanceBuyCountPrice() {
		return myCreateChanceBuyCountPrice;
	}
	public void setMyCreateChanceBuyCountPrice(double myCreateChanceBuyCountPrice) {
		this.myCreateChanceBuyCountPrice = myCreateChanceBuyCountPrice;
	}
	public long getToChanceNum() {
		return toChanceNum;
	}
	public void setToChanceNum(long toChanceNum) {
		this.toChanceNum = toChanceNum;
	}
	public long getToChanceBuyNum() {
		return toChanceBuyNum;
	}
	public void setToChanceBuyNum(long toChanceBuyNum) {
		this.toChanceBuyNum = toChanceBuyNum;
	}
	public double getToChanceBuyCountPrice() {
		return toChanceBuyCountPrice;
	}
	public void setToChanceBuyCountPrice(double toChanceBuyCountPrice) {
		this.toChanceBuyCountPrice = toChanceBuyCountPrice;
	}
	public long getMeetingNum() {
		return meetingNum;
	}
	public void setMeetingNum(long meetingNum) {
		this.meetingNum = meetingNum;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public long getMeetingOutNum() {
		return meetingOutNum;
	}
	public void setMeetingOutNum(long meetingOutNum) {
		this.meetingOutNum = meetingOutNum;
	}
	public long getMeetingLastNum() {
		return meetingLastNum;
	}
	public void setMeetingLastNum(long meetingLastNum) {
		this.meetingLastNum = meetingLastNum;
	}
	public long getMeetingLeave() {
		return meetingLeave;
	}
	public void setMeetingLeave(long meetingLeave) {
		this.meetingLeave = meetingLeave;
	}
	public long getMeetingNumOut() {
		return meetingNumOut;
	}
	public void setMeetingNumOut(long meetingNumOut) {
		this.meetingNumOut = meetingNumOut;
	}
}
