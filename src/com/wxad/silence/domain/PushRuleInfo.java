package com.wxad.silence.domain;

/**
 * 下发业务条件信息
 * @author xuzhenqin
 *
 */
public class PushRuleInfo extends RemarkId {
	private String pushId;
	private int apkNum;
	private String pushUrl;
	private String deviceUrl;
	private String requestRate;
	private String country;
	private String size;
	private String ram;
	private String channel;
	private String isTablet;
	private String systemVersion;
	private String sdkVersion;
	private String model;
	private String resolution;
	private String rom;
	private String hasSim;
	private String isRoot;
	private String hardware;
	
	/**
	 * 获得业务ID
	 * @return
	 */
	public String getPushId() {
		return pushId;
	}
	
	/**
	 * 设置业务ID
	 */
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}
	
	/**
	 * 获得安装个数
	 * @return
	 */
	public int getApkNum() {
		return apkNum;
	}
	
	/**
	 * 设置安装个数
	 */
	public void setApkNum(int apkNum) {
		this.apkNum = apkNum;
	}
	
	/**
	 * 获得业务请求地址
	 * @return
	 */
	public String getPushUrl() {
		return pushUrl;
	}
	
	/**
	 * 设置业务请求地址
	 */
	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	
	/**
	 * 获得登记设备信息地址
	 * @return
	 */
	public String getDeviceUrl() {
		return deviceUrl;
	}
	
	/**
	 * 设置登记设备信息地址
	 */
	public void setDeviceUrl(String deviceUrl) {
		this.deviceUrl = deviceUrl;
	}
	
	/**
	 * 获得登业务请求频率(单位为天)
	 * @return
	 */
	public String getRequestRate() {
		return requestRate;
	}
	
	/**
	 * 设置业务请求频率(单位为天)
	 */
	public void setRequestRate(String requestRate) {
		this.requestRate = requestRate;
	}
	
	/**
	 * 获得国家
	 * @return
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * 设置国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * 获得屏幕大小
	 * @return
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * 设置屏幕大小
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * 获得ram大小(可用容量_总容量)
	 * @return
	 */
	public String getRam() {
		return ram;
	}
	
	/**
	 * 设置ram大小(可用容量_总容量)
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	/**
	 * 获得渠道号
	 * @return
	 */
	public String getChannel() {
		return channel;
	}
	
	/**
	 * 设置渠道号
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	/**
	 * 获得是否是平板(可能不准确)
	 * @return
	 */
	public String getIsTablet() {
		return isTablet;
	}
	
	/**
	 * 设置是否是平板(可能不准确)
	 */
	public void setIsTablet(String isTablet) {
		this.isTablet = isTablet;
	}
	
	/**
	 * 获得系统版本
	 * @return
	 */
	public String getSystemVersion() {
		return systemVersion;
	}
	
	/**
	 * 设置系统版本
	 */
	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}
	
	/**
	 * 获得sdk版本
	 * @return
	 */
	public String getSdkVersion() {
		return sdkVersion;
	}
	
	/**
	 * 设置sdk版本
	 */
	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}
	
	/**
	 * 获得设置型号
	 * @return
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置设置型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * 获得屏幕分辨率
	 * @return
	 */
	public String getResolution() {
		return resolution;
	}
	
	/**
	 * 设置屏幕分辨率
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	/**
	 * 获得rom大小(可用容量_总容量)
	 * @return
	 */
	public String getRom() {
		return rom;
	}
	
	/**
	 * 设置rom大小(可用容量_总容量)
	 */
	public void setRom(String rom) {
		this.rom = rom;
	}
	
	/**
	 * 获得是否有SIM卡
	 * @return
	 */
	public String getHasSim() {
		return hasSim;
	}
	
	/**
	 * 设置是否有SIM卡
	 */
	public void setHasSim(String hasSim) {
		this.hasSim = hasSim;
	}
	
	/**
	 * 获得是否已经root
	 * @return
	 */
	public String getIsRoot() {
		return isRoot;
	}
	
	/**
	 * 设置是否已经root
	 */
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
	
	/**
	 * 获得包含wmt也直接下发status=true，不下发业务信息
	 * @return
	 */
	public String getHardware() {
		return hardware;
	}
	
	/**
	 * 设置包含wmt也直接下发status=true，不下发业务信息
	 */
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}
}
