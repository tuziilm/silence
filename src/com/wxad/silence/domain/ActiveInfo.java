package com.wxad.silence.domain;

/**
 * ������Ϣ��
 * @author xuzhenqin
 *
 */
public class ActiveInfo extends RemarkId {
	
	/**
	 * (����)
	 */
	private String packageName;
	
	/**
	 * (�������)
	 */
	private int count;
	
	/**
	 * (��ü���)
	 */
	private String date;
	
	/**
	 * pushId
	 */
	private Integer pushId;
	
	/**
	 * ����(����)
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}
	
	/**
	 * ���(����)
	 * @param packageName
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	/**
	 * ����(�������)
	 * @return
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * ���(�������)
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * ���� (��ü���)
	 * @return
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * ���(��ü���)
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * ����pushId
	 * @return
	 */
	public Integer getPushId() {
		return pushId;
	}
	
	/**
	 * ���
	 * @param pushId
	 */
	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}

}
