package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class MapInfo {
	private long id;
	 private long conpanyId;
	 private String mapLocation;//�����ʽΪ longitude,latitude; �� 117.23622,37.2837;238.29321,45.12323;
	 private String createDate;
	 private long conpanyUserId;
	 private String conpanyUserName;
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
	public String getMapLocation() {
		return mapLocation;
	}
	public void setMapLocation(String mapLocation) {
		this.mapLocation = mapLocation;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public long getConpanyUserId() {
		return conpanyUserId;
	}
	public void setConpanyUserId(long conpanyUserId) {
		this.conpanyUserId = conpanyUserId;
	}
	public String getConpanyUserName() {
		return conpanyUserName;
	}
	public void setConpanyUserName(String conpanyUserName) {
		this.conpanyUserName = conpanyUserName;
	}
}
