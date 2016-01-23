package com.herotculb.qunhaichat.dto;

import java.util.Date;

public class GoodsLogDto {
	public static final int ACTION_ADD=1;
	public static final int ACTION_REDUCE=2;
	public static final int ACTION_UPDATE_PRICE=3;
	private long id;
	private long goodsId;
	private String goodsName;
	private String goodsType;
	private double goodsinPrice;
	private long goodsSourceId;
	private String goodsSourceName;
	private double goodsNum;
	private long goodsToStorehouseId;
	private String startdate;
	private String goodsToStorehouseName;
	private long conpanyId;
	private String codeid;//货物的扫码
	private String spell;//拼音简写
	private String goodsModel;//货物型号
	private double salesNum;
	private int action;
	private double price;
	private double totalPrice;
	private double totalInPrice;
	private String createManName;
	private long createManId;
	private long chanceId;
	private String chanceName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public double getGoodsinPrice() {
		return goodsinPrice;
	}
	public void setGoodsinPrice(double goodsinPrice) {
		this.goodsinPrice = goodsinPrice;
	}
	public long getGoodsSourceId() {
		return goodsSourceId;
	}
	public void setGoodsSourceId(long goodsSourceId) {
		this.goodsSourceId = goodsSourceId;
	}
	public String getGoodsSourceName() {
		return goodsSourceName;
	}
	public void setGoodsSourceName(String goodsSourceName) {
		this.goodsSourceName = goodsSourceName;
	}
	public double getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(double goodsNum) {
		this.goodsNum = goodsNum;
	}
	public long getGoodsToStorehouseId() {
		return goodsToStorehouseId;
	}
	public void setGoodsToStorehouseId(long goodsToStorehouseId) {
		this.goodsToStorehouseId = goodsToStorehouseId;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getGoodsToStorehouseName() {
		return goodsToStorehouseName;
	}
	public void setGoodsToStorehouseName(String goodsToStorehouseName) {
		this.goodsToStorehouseName = goodsToStorehouseName;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getCodeid() {
		return codeid;
	}
	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public String getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}
	public double getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(double salesNum) {
		this.salesNum = salesNum;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalInPrice() {
		return totalInPrice;
	}
	public void setTotalInPrice(double totalInPrice) {
		this.totalInPrice = totalInPrice;
	}
	public String getCreateManName() {
		return createManName;
	}
	public void setCreateManName(String createManName) {
		this.createManName = createManName;
	}
	public long getCreateManId() {
		return createManId;
	}
	public void setCreateManId(long createManId) {
		this.createManId = createManId;
	}
	public long getChanceId() {
		return chanceId;
	}
	public void setChanceId(long chanceId) {
		this.chanceId = chanceId;
	}
	public String getChanceName() {
		return chanceName;
	}
	public void setChanceName(String chanceName) {
		this.chanceName = chanceName;
	}
	public static int getActionAdd() {
		return ACTION_ADD;
	}
	public static int getActionReduce() {
		return ACTION_REDUCE;
	}
	public static int getActionUpdatePrice() {
		return ACTION_UPDATE_PRICE;
	}
}
