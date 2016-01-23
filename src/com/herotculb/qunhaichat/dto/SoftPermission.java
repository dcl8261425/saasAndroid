package com.herotculb.qunhaichat.dto;
/**
 * Ȩ�ޱ�
 * ��¼�����и���ܵķ���Ȩ��
 * @author Administrator
 *
 */
public class SoftPermission {
	private long id;
	private String functionName;//������
	private long uplevel;//�ϼ�����id
	private String url;//���ܵ�url
	private String marks;//��ע
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public long getUplevel() {
		return uplevel;
	}
	public void setUplevel(long uplevel) {
		this.uplevel = uplevel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
}
