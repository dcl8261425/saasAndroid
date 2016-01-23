package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class ChanceListDto {
	private long id;
	private long createManId;
	private String creayeManName;
	private String customerName;
	private String customerAddress;
	private String customerType;
	private int customerLevel;//客户的级别 重要程度
	private String customerMark;
	private String createManMark;
	private int state;//1.普通机会 2.优质机会 3.已成客户 4.已流失 5.超过3个月无购物
	private long notesUserId;//0为未指定
	private String NotesUserName;
	private long conpanyId;
	private String createDate;;
	private String lastBuy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCreateManId() {
		return createManId;
	}
	public void setCreateManId(long createManId) {
		this.createManId = createManId;
	}
	public String getCreayeManName() {
		return creayeManName;
	}
	public void setCreayeManName(String creayeManName) {
		this.creayeManName = creayeManName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(int customerLevel) {
		this.customerLevel = customerLevel;
	}
	public String getCustomerMark() {
		return customerMark;
	}
	public void setCustomerMark(String customerMark) {
		this.customerMark = customerMark;
	}
	public String getCreateManMark() {
		return createManMark;
	}
	public void setCreateManMark(String createManMark) {
		this.createManMark = createManMark;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getNotesUserId() {
		return notesUserId;
	}
	public void setNotesUserId(long notesUserId) {
		this.notesUserId = notesUserId;
	}
	public String getNotesUserName() {
		return NotesUserName;
	}
	public void setNotesUserName(String notesUserName) {
		NotesUserName = notesUserName;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastBuy() {
		return lastBuy;
	}
	public void setLastBuy(String lastBuy) {
		this.lastBuy = lastBuy;
	}
}
