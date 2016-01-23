package com.herotculb.qunhaichat.dto;

public class RoleDto {
	private long id;
	private long conpanyId;//所属公司
	private long groupid;//该角色所属组名
	private String name;//角色名
	private String marks;//备注
	private boolean conpanyAdminRole;
	private String groupName;
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
	public long getGroupid() {
		return groupid;
	}
	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public boolean isConpanyAdminRole() {
		return conpanyAdminRole;
	}
	public void setConpanyAdminRole(boolean conpanyAdminRole) {
		this.conpanyAdminRole = conpanyAdminRole;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
