package com.herotculb.qunhaichat.dto;

public class UserDTO {
	private long id;
	private String username;//用户账号
	private String password;//用户密码
	private String email;//用户email
	private String accuntEndDate;//账户到期时间
	private String accuntStartDate;//账户开始日期
	private boolean freeAcccunt;//是不是免费的用户
	private boolean useLogin;//该账户是否启用
	private String image;//员工的照片
	private String phone;//员工电话
	private String address;//员工通讯地址
	private String idImage;//员工身份证照片
	private String state;//员工的状态，如临时工，小时工，合同工，实习工，等等
	private float price;//工资
	private String trueName;//真实姓名
	private long conpanyId;//所属公司
	private String idNum;
	private boolean sex;
	private String marks;
	private boolean conpanyAdmin;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccuntEndDate() {
		return accuntEndDate;
	}
	public void setAccuntEndDate(String accuntEndDate) {
		this.accuntEndDate = accuntEndDate;
	}
	public String getAccuntStartDate() {
		return accuntStartDate;
	}
	public void setAccuntStartDate(String accuntStartDate) {
		this.accuntStartDate = accuntStartDate;
	}
	public boolean isFreeAcccunt() {
		return freeAcccunt;
	}
	public void setFreeAcccunt(boolean freeAcccunt) {
		this.freeAcccunt = freeAcccunt;
	}
	public boolean isUseLogin() {
		return useLogin;
	}
	public void setUseLogin(boolean useLogin) {
		this.useLogin = useLogin;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdImage() {
		return idImage;
	}
	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public long getConpanyId() {
		return conpanyId;
	}
	public void setConpanyId(long conpanyId) {
		this.conpanyId = conpanyId;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public boolean isConpanyAdmin() {
		return conpanyAdmin;
	}
	public void setConpanyAdmin(boolean conpanyAdmin) {
		this.conpanyAdmin = conpanyAdmin;
	}
	
}
