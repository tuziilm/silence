package com.wxad.silence.domain;

/**
 * ɾ��ָ����������
 * @author xuzhenqin
 *
 */
public class DeleteInfo extends RemarkId {
	
	/**
	 * Ҫɾ���İ���
	 */
	private String packageName;
	
	/**
	 * push id
	 */
	private String pushId;
	
	/**
	 * ���Ҫɾ���İ���
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}
	
	/**
	 * ����Ҫɾ���İ���
	 * @param packageName
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	/**
	 * ���pushId
	 * @return
	 */
	public String getPushId() {
		return pushId;
	}
	
	/**
	 * ����pushId
	 * @param pushId
	 */
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}
}
