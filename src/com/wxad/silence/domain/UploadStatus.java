package com.wxad.silence.domain;

public class UploadStatus extends RemarkId {
	
	/**
	 * ���uuid
	 * @return
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * ����uuid
	 * @return
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * ��ð���
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * ���ð���
	 * @return
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	/**
	 * ��ð汾��
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * ���ð汾��
	 * @return
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * ��ö���:active��delete��download��install
	 * @return
	 */
	public String getAction() {
		return action;
	}

	/**
	 * ���ö���:active��delete��download��install
	 * @return
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * ���״̬:fail��success
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * ����״̬:fail��success
	 * @return
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * ��ñ�ע��Ϣ����������ʧ�ܵ�ʱ��������ʧ�ܵ�ԭ��
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ���ñ�ע��Ϣ����������ʧ�ܵ�ʱ��������ʧ�ܵ�ԭ��
	 * @return
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * ��ø��·���ʱ��
	 * @return
	 */
	public String getDatetime() {
		return datetime;
	}
	
	/**
	 * ���ø��·���ʱ��
	 * @return
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	/**
	 * uuid
	 */
	private String uuid;
	
	/**
	 * (����)
	 */
	private String packageName;
	
	/**
	 * (�汾��)
	 */
	private String version;
	
	/**
	 * (����:active��delete��download��install)
	 */
	private String action;
	
	/**
	 * (״̬:fail��success)
	 */
	private String state;
	
	/**
	 * (��ע��Ϣ����������ʧ�ܵ�ʱ��������ʧ�ܵ�ԭ��)
	 */
	private String msg;
	
	/**
	 * upload ʱ��
	 */
	private String datetime;
}
