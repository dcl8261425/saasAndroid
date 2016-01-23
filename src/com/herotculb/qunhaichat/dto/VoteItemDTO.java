package com.herotculb.qunhaichat.dto;

public class VoteItemDTO {
	private long id;
	private String name;
	private long num;
	
	private long ConpanyId;
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
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
	public long getConpanyId() {
		return ConpanyId;
	}
	public void setConpanyId(long conpanyId) {
		ConpanyId = conpanyId;
	}
	
}
