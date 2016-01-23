package com.herotculb.qunhaichat.dto;

import java.util.List;

public class VoteDTO {
	private long id;
	private String name;
	private String stardate;
	private String endDate;
	private boolean publics;//是否允许非关注用户投票
	private boolean ones;//是否是多选
	private List<VoteItemDTO> voteItem;
	private long conpanyId;
	private long wenzhangId;
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
	public String getStardate() {
		return stardate;
	}
	public void setStardate(String stardate) {
		this.stardate = stardate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public boolean isPublics() {
		return publics;
	}
	public void setPublics(boolean publics) {
		this.publics = publics;
	}
	public boolean isOnes() {
		return ones;
	}
	public void setOnes(boolean ones) {
		this.ones = ones;
	}
	public List<VoteItemDTO> getVoteItem() {
		return voteItem;
	}
	public void setVoteItem(List<VoteItemDTO> voteItem) {
		this.voteItem = voteItem;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public long getWenzhangId() {
		return wenzhangId;
	}
	public void setWenzhangId(long wenzhangId) {
		this.wenzhangId = wenzhangId;
	}
	
}
