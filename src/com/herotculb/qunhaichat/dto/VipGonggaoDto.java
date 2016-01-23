package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class VipGonggaoDto {
	private long id;
	private String GonggaoContent;
	private long conpanyId;
	private String sendDate;
	private String imageLink;
	private String videoLink;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGonggaoContent() {
		return GonggaoContent;
	}
	public void setGonggaoContent(String gonggaoContent) {
		GonggaoContent = gonggaoContent;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
}
