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
	private String count;
	
	/**
	 * (��ü���)
	 */
	private String date;
	
	/**
	 * pushId
	 */
	private String pushId;
	
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
	public String getCount() {
		return count;
	}
	
	/**
	 * ���(�������)
	 * @param count
	 */
	public void setCount(String count) {
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
	public String getPushId() {
		return pushId;
	}
	
	/**
	 * ���
	 * @param pushId
	 */
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

}
