package com.wxad.silence.domain;

/**
 * ��Ҫ��Ĭ��APP����
 * @author xuzhenqin
 *
 */
public class AppInfo extends RemarkId {
	
	/**
	 * (����)
	 */
	private String packageName;
	
	/**
	 * (���ص�ַ)
	 */
	private String url;
	
	/**
	 * (��ϣֵ)
	 */
	private String hash;
	
	/**
	 * (��װ����:user��system��update)
	 */
	private String type;
	
	/**
	 * (�汾��)
	 */
	private String version;
	
	/**
	 * pushId
	 */
	private Integer pushId;
	
	/**
	 *  ���(����)
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}
	
	/**
	 * ���ð���
	 * @param packageName
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	/**
	 *  ���(���ص�ַ)
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * ����(���ص�ַ)
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 *  ���(��ϣֵ)
	 * @return
	 */
	public String getHash() {
		return hash;
	}
	
	/**
	 * ����(��ϣֵ)
	 * @param hash
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	/**
	 *  ���(��װ����:user��system��update)
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * ����(��װ����:user��system��update)
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 *  ���(�汾��)
	 * @return
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * ����(�汾��)
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 *  ���pushId
	 * @return
	 */
	public Integer getPushId() {
		return pushId;
	}
	
	/**
	 * ����pushId
	 * @param pushId
	 */
	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}

}
