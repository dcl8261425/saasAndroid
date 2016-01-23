package com.herotculb.qunhaichat.dto;

public class VoteUserDto {
	private long id;
	private String name;
	private long linkmenId;
	private String phone;
	private long voteId;
	private String voteItemName;
	private long voteItemId;
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
	public long getLinkmenId() {
		return linkmenId;
	}
	public void setLinkmenId(long linkmenId) {
		this.linkmenId = linkmenId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getVoteId() {
		return voteId;
	}
	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}
	public String getVoteItemName() {
		return voteItemName;
	}
	public void setVoteItemName(String voteItemName) {
		this.voteItemName = voteItemName;
	}
	public long getVoteItemId() {
		return voteItemId;
	}
	public void setVoteItemId(long voteItemId) {
		this.voteItemId = voteItemId;
	}
}
