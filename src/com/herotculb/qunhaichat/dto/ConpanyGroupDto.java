package com.herotculb.qunhaichat.dto;

public class ConpanyGroupDto {
	private long id;
	private String groupName;//组名称
	private String groupMarks;//备注
	private long conpanyId;//所属公司
	private long upLevelConpanyGroup;//上一层组
	private long createConpanyGroupUserId;//创建人id
	private String createConpanyGroupUserTrueName;//创建组人物的真实名字
	private String createConpanyGroupUserName;//创建组人物的账号
	private long userNum;//用户数量
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupMarks() {
		return groupMarks;
	}
	public void setGroupMarks(String groupMarks) {
		this.groupMarks = groupMarks;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public long getUpLevelConpanyGroup() {
		return upLevelConpanyGroup;
	}
	public void setUpLevelConpanyGroup(long upLevelConpanyGroup) {
		this.upLevelConpanyGroup = upLevelConpanyGroup;
	}
	public long getCreateConpanyGroupUserId() {
		return createConpanyGroupUserId;
	}
	public void setCreateConpanyGroupUserId(long createConpanyGroupUserId) {
		this.createConpanyGroupUserId = createConpanyGroupUserId;
	}
	public String getCreateConpanyGroupUserTrueName() {
		return createConpanyGroupUserTrueName;
	}
	public void setCreateConpanyGroupUserTrueName(
			String createConpanyGroupUserTrueName) {
		this.createConpanyGroupUserTrueName = createConpanyGroupUserTrueName;
	}
	public String getCreateConpanyGroupUserName() {
		return createConpanyGroupUserName;
	}
	public void setCreateConpanyGroupUserName(String createConpanyGroupUserName) {
		this.createConpanyGroupUserName = createConpanyGroupUserName;
	}
	public long getUserNum() {
		return userNum;
	}
	public void setUserNum(long userNum) {
		this.userNum = userNum;
	}
}
