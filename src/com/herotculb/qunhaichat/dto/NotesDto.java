package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class NotesDto {
	private long id;
	private long notesUserId;
	private String notesUserName;
	private long chanceListId;
	private String chanceListName;
	private String startDate;
	private String endDate;
	private long conpanyId;
	private String updateDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNotesUserId() {
		return notesUserId;
	}
	public void setNotesUserId(long notesUserId) {
		this.notesUserId = notesUserId;
	}
	public String getNotesUserName() {
		return notesUserName;
	}
	public void setNotesUserName(String notesUserName) {
		this.notesUserName = notesUserName;
	}
	public long getChanceListId() {
		return chanceListId;
	}
	public void setChanceListId(long chanceListId) {
		this.chanceListId = chanceListId;
	}
	public String getChanceListName() {
		return chanceListName;
	}
	public void setChanceListName(String chanceListName) {
		this.chanceListName = chanceListName;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
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
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
