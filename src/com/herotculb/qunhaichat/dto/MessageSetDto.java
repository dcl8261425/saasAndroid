package com.herotculb.qunhaichat.dto;

public class MessageSetDto {
	public static final int ADD_SCORE=1;//添加积分
	public static final int ADD_PRICE=2;//添加储值
	public static final int REDUCE_SCORE=3;//减少积分
	public static final int REDUCE_PRICE=4;//减少储值
	public static final int WEIXIN_INFO_TO_USER=5;//接受微信
	public static final int ORDER_INFO_TO_USER=6;//接受订单
	public static final int YUDING_INFO_TO_USER=7;//就收预订
	public static final int QUNSEND_INFO=8;//群发信息
	public static final String CONTENT_NOW_SCORE="@NOW_SCORE";//当前积分
	public static final String CONTENT_ADD_SCORE="@ADD_SCORE";//添加的积分
	public static final String CONTENT_ADD_BEFORE_SCORE="@ADD_BEFORE_SCORE";//添加积分之前所剩积分
	public static final String CONTENT_ADD_AFTER_SCORE="@ADD_AFTER_SCORE";//添加积分之后积分总和
	public static final String CONTENT_NOW_PRICE="@NOW_PRICE";//当前余额
	public static final String CONTENT_ADD_PRICE="@ADD_PRICE";//添加的余额
	public static final String CONTENT_ADD_BEFORE_PRICE="@ADD_BEFORE_PRICE";//添加余额之前所剩余额
	public static final String CONTENT_ADD_AFTER_PRICE="@ADD_AFTER_PRICE";//添加余额之后余额总和
	public static final String CONTENT_REDUCE_SCORE="@REDUCE_SCORE";//减少的积分额度
	public static final String CONTENT_REDUCE_BEFORE_SCORE="@REDUCE_BEFORE_SCORE";//减少积分之前所剩积分
	public static final String CONTENT_REDUCE_AFTER_SCORE="@REDUCE_AFTER_SCORE";//减少积分之后积分总和
	public static final String CONTENT_REDUCE_PRICE="@REDUCE_PRICE";//减少的余额
	public static final String CONTENT_REDUCE_BEFORE_PRICE="@REDUCE_BEFORE_PRICE";//减少余额之前所剩余额
	public static final String CONTENT_REDUCE_AFTER_PRICE="@REDUCE_AFTER_PRICE";//减少余额之后余额总和
	public static final String CONTENT_VIP_NAME="@VIP_NAME";//会员名
	public static final String CONTENT_VIP_PHONE="@VIP_PHONE";//会员电话
	public static final String CONTENT_ORDER_NAME="@CONTENT_ORDER_NAME";//订单编号
	public static final String CONTENT_ORDER_DATE="@CONTENT_ORDER_DATE";//订单时间
	public static final String CONTENT_ORDER_DATA="@CONTENT_ORDER_DATA";//订单商品列表
	public static final String CONTENT_WEIXIN_CONTENT="@CONTENT_WEIXIN_CONTENT";//微信内容
	public static final String CONTENT_RESERVATION_NAME="@CONTENT_RESERVATION_NAME";//预订名字
	public static final String CONTENT_RESERVATION_DATE="@CONTENT_RESERVATION_DATE";//预订日期
	public static final String CONTENT_RESERVATION_DATA="@CONTENT_RESERVATION_DATA";//预订商品
	private long id;
	private boolean addscoreToVip; //给会员添加积分时向会员发送消息
	private boolean addPriceToVip; //给会员储值时向会员发送短消息
	private boolean reducePriceToVip; //给会员减少储值时向会员发送短消息
	private boolean reducescoreToVip; //给会员减少积分时向会员发送消息
	private boolean winxinInfoToUser;//会员在微信端向公众账号发送消息时，向用户发送短消息。
	private boolean orderToUser;//用户下订单时向 商户发送短消息
	private boolean yudingToUser; //用户预定时向 商户发送短消息
	private String orderToUserContent; //内容
	private String yudingToUserContent;
	private String addscoreToVipContent;
	private String addPriceToVipContent;
	private String reducesscoreToVipContent;
	private String reducesPriceToVipContent;
	private String winxinInfoToUserContent;
	private long orderToUsernum;//已发送数量
	private long yudingToUsernum;
	private long addscoreToVipnum;
	private long addPriceToVipnum;
	private long winxinInfoToUsernum;
	private long reducesscoreToVipnum;
	private long reducesPriceToVipnum;
	private long num;
	private String winxinInfoToUserPhone;//电话
	private String orderToUserPhone;
	private String yudingToUserPhone; 
	private long conpanyId;
	private String qianMing;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isAddscoreToVip() {
		return addscoreToVip;
	}
	public void setAddscoreToVip(boolean addscoreToVip) {
		this.addscoreToVip = addscoreToVip;
	}
	public boolean isAddPriceToVip() {
		return addPriceToVip;
	}
	public void setAddPriceToVip(boolean addPriceToVip) {
		this.addPriceToVip = addPriceToVip;
	}
	public boolean isReducePriceToVip() {
		return reducePriceToVip;
	}
	public void setReducePriceToVip(boolean reducePriceToVip) {
		this.reducePriceToVip = reducePriceToVip;
	}
	public boolean isReducescoreToVip() {
		return reducescoreToVip;
	}
	public void setReducescoreToVip(boolean reducescoreToVip) {
		this.reducescoreToVip = reducescoreToVip;
	}
	public boolean isWinxinInfoToUser() {
		return winxinInfoToUser;
	}
	public void setWinxinInfoToUser(boolean winxinInfoToUser) {
		this.winxinInfoToUser = winxinInfoToUser;
	}
	public boolean isOrderToUser() {
		return orderToUser;
	}
	public void setOrderToUser(boolean orderToUser) {
		this.orderToUser = orderToUser;
	}
	public boolean isYudingToUser() {
		return yudingToUser;
	}
	public void setYudingToUser(boolean yudingToUser) {
		this.yudingToUser = yudingToUser;
	}
	public String getOrderToUserContent() {
		return orderToUserContent;
	}
	public void setOrderToUserContent(String orderToUserContent) {
		this.orderToUserContent = orderToUserContent;
	}
	public String getYudingToUserContent() {
		return yudingToUserContent;
	}
	public void setYudingToUserContent(String yudingToUserContent) {
		this.yudingToUserContent = yudingToUserContent;
	}
	public String getAddscoreToVipContent() {
		return addscoreToVipContent;
	}
	public void setAddscoreToVipContent(String addscoreToVipContent) {
		this.addscoreToVipContent = addscoreToVipContent;
	}
	public String getAddPriceToVipContent() {
		return addPriceToVipContent;
	}
	public void setAddPriceToVipContent(String addPriceToVipContent) {
		this.addPriceToVipContent = addPriceToVipContent;
	}
	public String getReducesscoreToVipContent() {
		return reducesscoreToVipContent;
	}
	public void setReducesscoreToVipContent(String reducesscoreToVipContent) {
		this.reducesscoreToVipContent = reducesscoreToVipContent;
	}
	public String getReducesPriceToVipContent() {
		return reducesPriceToVipContent;
	}
	public void setReducesPriceToVipContent(String reducesPriceToVipContent) {
		this.reducesPriceToVipContent = reducesPriceToVipContent;
	}
	public String getWinxinInfoToUserContent() {
		return winxinInfoToUserContent;
	}
	public void setWinxinInfoToUserContent(String winxinInfoToUserContent) {
		this.winxinInfoToUserContent = winxinInfoToUserContent;
	}
	public long getOrderToUsernum() {
		return orderToUsernum;
	}
	public void setOrderToUsernum(long orderToUsernum) {
		this.orderToUsernum = orderToUsernum;
	}
	public long getYudingToUsernum() {
		return yudingToUsernum;
	}
	public void setYudingToUsernum(long yudingToUsernum) {
		this.yudingToUsernum = yudingToUsernum;
	}
	public long getAddscoreToVipnum() {
		return addscoreToVipnum;
	}
	public void setAddscoreToVipnum(long addscoreToVipnum) {
		this.addscoreToVipnum = addscoreToVipnum;
	}
	public long getAddPriceToVipnum() {
		return addPriceToVipnum;
	}
	public void setAddPriceToVipnum(long addPriceToVipnum) {
		this.addPriceToVipnum = addPriceToVipnum;
	}
	public long getWinxinInfoToUsernum() {
		return winxinInfoToUsernum;
	}
	public void setWinxinInfoToUsernum(long winxinInfoToUsernum) {
		this.winxinInfoToUsernum = winxinInfoToUsernum;
	}
	public long getReducesscoreToVipnum() {
		return reducesscoreToVipnum;
	}
	public void setReducesscoreToVipnum(long reducesscoreToVipnum) {
		this.reducesscoreToVipnum = reducesscoreToVipnum;
	}
	public long getReducesPriceToVipnum() {
		return reducesPriceToVipnum;
	}
	public void setReducesPriceToVipnum(long reducesPriceToVipnum) {
		this.reducesPriceToVipnum = reducesPriceToVipnum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getWinxinInfoToUserPhone() {
		return winxinInfoToUserPhone;
	}
	public void setWinxinInfoToUserPhone(String winxinInfoToUserPhone) {
		this.winxinInfoToUserPhone = winxinInfoToUserPhone;
	}
	public String getOrderToUserPhone() {
		return orderToUserPhone;
	}
	public void setOrderToUserPhone(String orderToUserPhone) {
		this.orderToUserPhone = orderToUserPhone;
	}
	public String getYudingToUserPhone() {
		return yudingToUserPhone;
	}
	public void setYudingToUserPhone(String yudingToUserPhone) {
		this.yudingToUserPhone = yudingToUserPhone;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getQianMing() {
		return qianMing;
	}
	public void setQianMing(String qianMing) {
		this.qianMing = qianMing;
	}
	public static int getAddScore() {
		return ADD_SCORE;
	}
	public static int getAddPrice() {
		return ADD_PRICE;
	}
	public static int getReduceScore() {
		return REDUCE_SCORE;
	}
	public static int getReducePrice() {
		return REDUCE_PRICE;
	}
	public static int getWeixinInfoToUser() {
		return WEIXIN_INFO_TO_USER;
	}
	public static int getOrderInfoToUser() {
		return ORDER_INFO_TO_USER;
	}
	public static int getYudingInfoToUser() {
		return YUDING_INFO_TO_USER;
	}
	public static int getQunsendInfo() {
		return QUNSEND_INFO;
	}
	public static String getContentNowScore() {
		return CONTENT_NOW_SCORE;
	}
	public static String getContentAddScore() {
		return CONTENT_ADD_SCORE;
	}
	public static String getContentAddBeforeScore() {
		return CONTENT_ADD_BEFORE_SCORE;
	}
	public static String getContentAddAfterScore() {
		return CONTENT_ADD_AFTER_SCORE;
	}
	public static String getContentNowPrice() {
		return CONTENT_NOW_PRICE;
	}
	public static String getContentAddPrice() {
		return CONTENT_ADD_PRICE;
	}
	public static String getContentAddBeforePrice() {
		return CONTENT_ADD_BEFORE_PRICE;
	}
	public static String getContentAddAfterPrice() {
		return CONTENT_ADD_AFTER_PRICE;
	}
	public static String getContentReduceScore() {
		return CONTENT_REDUCE_SCORE;
	}
	public static String getContentReduceBeforeScore() {
		return CONTENT_REDUCE_BEFORE_SCORE;
	}
	public static String getContentReduceAfterScore() {
		return CONTENT_REDUCE_AFTER_SCORE;
	}
	public static String getContentReducePrice() {
		return CONTENT_REDUCE_PRICE;
	}
	public static String getContentReduceBeforePrice() {
		return CONTENT_REDUCE_BEFORE_PRICE;
	}
	public static String getContentReduceAfterPrice() {
		return CONTENT_REDUCE_AFTER_PRICE;
	}
	public static String getContentVipName() {
		return CONTENT_VIP_NAME;
	}
	public static String getContentVipPhone() {
		return CONTENT_VIP_PHONE;
	}
	public static String getContentOrderName() {
		return CONTENT_ORDER_NAME;
	}
	public static String getContentOrderDate() {
		return CONTENT_ORDER_DATE;
	}
	public static String getContentOrderData() {
		return CONTENT_ORDER_DATA;
	}
	public static String getContentWeixinContent() {
		return CONTENT_WEIXIN_CONTENT;
	}
	public static String getContentReservationName() {
		return CONTENT_RESERVATION_NAME;
	}
	public static String getContentReservationDate() {
		return CONTENT_RESERVATION_DATE;
	}
	public static String getContentReservationData() {
		return CONTENT_RESERVATION_DATA;
	}
}
