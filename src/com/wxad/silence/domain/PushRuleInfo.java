package com.wxad.silence.domain;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.wxad.silence.common.JsonSupport;

/**
 * �·�ҵ��������Ϣ
 * @author xuzhenqin
 *
 */
public class PushRuleInfo extends Id implements JsonSupport{
	private Integer apkNum;
	private String pushUrl;
	private String deviceUrl;
	private String requestRate;
	private Set<String> country;
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
	private int isMatching;
	
	@JsonIgnore
    public String getJsonString(){
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
        try {
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "{}";
    }

	/**
	 * ��ð�װ����
	 * @return
	 */
	public Integer getApkNum() {
		return apkNum;
	}
	
	/**
	 * ���ð�װ����
	 */
	public void setApkNum(Integer apkNum) {
		this.apkNum = apkNum;
	}
	
	/**
	 * ���ҵ�������ַ
	 * @return
	 */
	public String getPushUrl() {
		return pushUrl;
	}
	
	/**
	 * ����ҵ�������ַ
	 */
	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	
	/**
	 * ��õǼ��豸��Ϣ��ַ
	 * @return
	 */
	public String getDeviceUrl() {
		return deviceUrl;
	}
	
	/**
	 * ���õǼ��豸��Ϣ��ַ
	 */
	public void setDeviceUrl(String deviceUrl) {
		this.deviceUrl = deviceUrl;
	}
	
	/**
	 * ��õ�ҵ������Ƶ��(��λΪ��)
	 * @return
	 */
	public String getRequestRate() {
		return requestRate;
	}
	
	/**
	 * ����ҵ������Ƶ��(��λΪ��)
	 */
	public void setRequestRate(String requestRate) {
		this.requestRate = requestRate;
	}
	
	/**
	 * �����Ļ��С
	 * @return
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * ������Ļ��С
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
	 */
	public void setRam(String ram) {
		this.ram = ram;
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
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	/**
	 * ����Ƿ���ƽ��(���ܲ�׼ȷ)
	 * @return
	 */
	public String getIsTablet() {
		return isTablet;
	}
	
	/**
	 * �����Ƿ���ƽ��(���ܲ�׼ȷ)
	 */
	public void setIsTablet(String isTablet) {
		this.isTablet = isTablet;
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
	 */
	public void setModel(String model) {
		this.model = model;
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
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
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
	 */
	public void setHasSim(String hasSim) {
		this.hasSim = hasSim;
	}
	
	/**
	 * ����Ƿ��Ѿ�root
	 * @return
	 */
	public String getIsRoot() {
		return isRoot;
	}
	
	/**
	 * �����Ƿ��Ѿ�root
	 */
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
	
	/**
	 * ��ð���wmtҲֱ���·�status=true�����·�ҵ����Ϣ
	 * @return
	 */
	public String getHardware() {
		return hardware;
	}
	
	/**
	 * ���ð���wmtҲֱ���·�status=true�����·�ҵ����Ϣ
	 */
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}
	/**
	 * ��ȡ�Ƿ���Ҫ���ò���ֵ��
	 * @return
	 */
	public int getIsMatching() {
		return isMatching;
	}
	/**
	 * �����Ƿ���Ҫ���ò���ֵ��
	 * @param isMatching
	 */
	public void setIsMatching(int isMatching) {
		this.isMatching = isMatching;
	}
	 public String getCountry() {
	        if(country==null || country.isEmpty()){
	            return "";
	        }
	        return Joiner.on(",").skipNulls().join(country);
	    }

	    public void setCountry(String country) {
	        if(Strings.isNullOrEmpty(country)){
	            return;
	        }
	        this.country = Sets.newHashSet(Splitter.on(",").omitEmptyStrings().trimResults().split(country));
	    }

	    public Set<String> getCountriesObject(){
	        return this.country;
	    }
	    public void setCountriesObject(Set<String> country){
	        this.country = country;
	    }
}
