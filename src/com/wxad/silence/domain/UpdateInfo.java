package com.wxad.silence.domain;

/**
 * ������Ϣ
 * @author xuzhenqin
 *
 */
public class UpdateInfo extends RemarkId {
	
	/**
	 * (�汾��)
	 */
	private String version;
	
	/**
	 * (���ص�ַ)
	 */
	private String url;
	
	/**
	 * (��ϣֵ)
	 */
	private String hash;
	
	/**
	 * pushId
	 */
	private Integer pushId;

	/**
	 * ���(�汾��)
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
	 * ���(���ص�ַ)
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
	 * ���(��ϣֵ)
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
	 * ���push id
	 * @return
	 */
	public Integer getPushId() {
		return pushId;
	}


	/**
	 * ����push id
	 * @param pushId
	 */
	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}

}
