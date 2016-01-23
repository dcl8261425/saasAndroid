package com.herotculb.qunhaichat.dto;

public class ScoreToGoodsListDto {
	private long id;
	 private String name;
	 private long scoreDuiHuanId;
	 private String xuliehao;
	 private int num;
	 private boolean uses;
	 private long userid;
	 private long linkmainId;
	 private long conpanyId;
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
	public long getScoreDuiHuanId() {
		return scoreDuiHuanId;
	}
	public void setScoreDuiHuanId(long scoreDuiHuanId) {
		this.scoreDuiHuanId = scoreDuiHuanId;
	}
	public String getXuliehao() {
		return xuliehao;
	}
	public void setXuliehao(String xuliehao) {
		this.xuliehao = xuliehao;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isUses() {
		return uses;
	}
	public void setUses(boolean uses) {
		this.uses = uses;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getLinkmainId() {
		return linkmainId;
	}
	public void setLinkmainId(long linkmainId) {
		this.linkmainId = linkmainId;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
}
