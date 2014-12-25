package com.wxad.silence.domain;

/**
 * �ϴ�ע������
 * @author xuzhenqin
 *
 */
public class RegisterInfo extends RemarkId {
	
	/**
	 * uuid
	 */
	private String uuid;
	
	/**
	 * ��ǰ�汾
	 */
	private String version;
	
	/**
	 * ��������
	 */
	private String netType;
	
	/**
	 * ������
	 */
	private String channel;
	
	/**
	 * �Ƿ���ƽ��(���ܲ�׼ȷ)
	 */
	private String isTablet;
	
	/**
	 * ����ʱ��
	 */
	private String datetime;
	
	/**
	 * mac��ַ
	 */
	private String macAddress;
	
	/**
	 * ϵͳ�汾
	 */
	private String systemVersion;
	
	/**
	 * sdk�汾
	 */
	private String sdkVersion;
	
	/**
	 * �����ͺ�
	 */
	private String model;
	
	/**
	 * ϵͳ����(���Ҵ���_���Դ���)
	 */
	private String language;
	
	/**
	 * ���γߴ�
	 */
	private String size;

	/**
	 * ��Ļ�ֱ���
	 */
	private String resolution;
	
	/**
	 * ram��С(��������_������)
	 */
	private String ram;
	
	/**
	 * rom��С(��������_������)
	 */
	private String rom;
	
	/**
	 * �Ƿ���SIM��
	 */
	private String hasSim;
	
	/**
	 * �Ƿ��Ѿ�root
	 */
	private String isRoot;
	
	/**
	 * ����Ƿ��Ѿ�root
	 * @return
	 */
	public String getIsRoot() {
		return isRoot;
	}

	/**
	 * �����Ƿ��Ѿ�root
	 * @param isRoot
	 */
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	/**
	 * ��������
	 */
	private String country;
	
	/**
	 * ����Ƿ�����豸��Ϣ
	 */
	public String getIsTablet() {
		return isTablet;
	}

	/**
	 * �����Ƿ�����豸��Ϣ
	 */
	public void setIsTablet(String isTablet) {
		this.isTablet = isTablet;
	}

	/**
	 * ������γߴ�
	 */
	public String getSize() {
		return size;
	}

	/**
	 * �������γߴ�
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * ���ram��С(��������_������)
	 * @return
	 */
	public String getRam() {
		return ram;
	}

	/**
	 * ����ram��С(��������_������)
	 * @return
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}

	/**
	 * ���rom��С(��������_������)
	 * @return
	 */
	public String getRom() {
		return rom;
	}

	/**
	 * ����rom��С(��������_������)
	 * @return
	 */
	public void setRom(String rom) {
		this.rom = rom;
	}

	/**
	 * ����Ƿ���SIM��
	 * @return
	 */
	public String getHasSim() {
		return hasSim;
	}

	/**
	 * �����Ƿ���SIM��
	 * @return
	 */
	public void setHasSim(String hasSim) {
		this.hasSim = hasSim;
	}

	/**
	 * ���������
	 * @return
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * ����������
	 * @return
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}


	/**
	 * �������ʱ��
	 * @return
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * ��������ʱ��
	 * @return
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


	/**
	 * ���mac��ַ
	 * @return
	 */
	public String getMacAddress() {
		return macAddress;
	}


	/**
	 * ����mac��ַ
	 * @return
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * ���ϵͳ�汾
	 * @return
	 */
	public String getSystemVersion() {
		return systemVersion;
	}

	/**
	 * ����ϵͳ�汾
	 * @return
	 */
	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	/**
	 * ���sdk�汾
	 * @return
	 */
	public String getSdkVersion() {
		return sdkVersion;
	}

	/**
	 * ����sdk�汾
	 * @return
	 */
	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	/**
	 * ��������ͺ�
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * ���������ͺ�
	 * @return
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * ���ϵͳ����(���Ҵ���_���Դ���)
	 * @return
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * ����ϵͳ����(���Ҵ���_���Դ���)
	 * @return
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * �����Ļ�ֱ���
	 * @return
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * ������Ļ�ֱ���
	 * @return
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * ��ù�������
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * ���ù�������
	 * @return
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * ����uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * ����uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * ��õ�ǰ�汾
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * ���õ�ǰ�汾
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * �����������
	 */
	public String getNetType() {
		return netType;
	}

	/**
	 * ������������
	 */
	public void setNetType(String netType) {
		this.netType = netType;
	}
}
