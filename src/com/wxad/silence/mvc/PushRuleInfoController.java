package com.wxad.silence.mvc;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxad.silence.common.Country;
import com.wxad.silence.common.IdForm;
import com.wxad.silence.common.Paginator;
import com.wxad.silence.common.Query;
import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.service.PushRuleInfoService;

/**
 * push�������
 * @author <a href="tuziilm@gmail.com">tuziilm</a>
 *
 */
@Controller
@RequestMapping("/pushRule")
public class PushRuleInfoController extends CRUDController<PushRuleInfo, PushRuleInfoService, com.wxad.silence.mvc.PushRuleInfoController.PushRuleInfoForm, Query.NameQuery>{
	public PushRuleInfoController() {
		super("pushRule");
	}
	@Resource
	public void setPushRuleInfoService(PushRuleInfoService pushRuleInfoService){
		this.service=pushRuleInfoService;
	}
	
	public static class PushRuleInfoForm extends IdForm<PushRuleInfo> {
		private int apkNum;
		private String pushUrl;
		private String deviceUrl;
		private String requestRate;
		private Set<String> countriesObject;
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
		
		public int getApkNum() {
			return apkNum;
		}

		public void setApkNum(int apkNum) {
			this.apkNum = apkNum;
		}

		public String getPushUrl() {
			return pushUrl;
		}

		public void setPushUrl(String pushUrl) {
			this.pushUrl = pushUrl;
		}

		public String getDeviceUrl() {
			return deviceUrl;
		}

		public void setDeviceUrl(String deviceUrl) {
			this.deviceUrl = deviceUrl;
		}

		public String getRequestRate() {
			return requestRate;
		}

		public void setRequestRate(String requestRate) {
			this.requestRate = requestRate;
		}
		
		public Set<String> getCountriesObject() {
            return countriesObject;
        }

        public void setCountriesObject(Set<String> countriesObject) {
            this.countriesObject = countriesObject;
        }

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getRam() {
			return ram;
		}

		public void setRam(String ram) {
			this.ram = ram;
		}

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getIsTablet() {
			return isTablet;
		}

		public void setIsTablet(String isTablet) {
			this.isTablet = isTablet;
		}

		public String getSystemVersion() {
			return systemVersion;
		}

		public void setSystemVersion(String systemVersion) {
			this.systemVersion = systemVersion;
		}

		public String getSdkVersion() {
			return sdkVersion;
		}

		public void setSdkVersion(String sdkVersion) {
			this.sdkVersion = sdkVersion;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getResolution() {
			return resolution;
		}

		public void setResolution(String resolution) {
			this.resolution = resolution;
		}

		public String getRom() {
			return rom;
		}

		public void setRom(String rom) {
			this.rom = rom;
		}

		public String getHasSim() {
			return hasSim;
		}

		public void setHasSim(String hasSim) {
			this.hasSim = hasSim;
		}

		public String getIsRoot() {
			return isRoot;
		}

		public void setIsRoot(String isRoot) {
			this.isRoot = isRoot;
		}

		public String getHardware() {
			return hardware;
		}

		public void setHardware(String hardware) {
			this.hardware = hardware;
		}

		public int getIsMatching() {
			return isMatching;
		}

		public void setIsMatching(int isMatching) {
			this.isMatching = isMatching;
		}

		@Override
		public PushRuleInfo newObj() {
			return new PushRuleInfo();
		}

		@Override
		public void silenceulateObj(PushRuleInfo obj) {
			obj.setApkNum(apkNum);
			obj.setChannel(channel);
			obj.setCountriesObject(countriesObject);
			obj.setDeviceUrl(deviceUrl);
			obj.setHardware(hardware);
			obj.setHasSim(hasSim);
			obj.setIsMatching(isMatching);
			obj.setIsRoot(isRoot);
			obj.setIsTablet(isTablet);
			obj.setModel(model);
			obj.setPushUrl(pushUrl);
			obj.setRam(ram);
			obj.setRequestRate(requestRate);
			obj.setResolution(resolution);
			obj.setRom(rom);
			obj.setSdkVersion(sdkVersion);
			obj.setSize(size);
			obj.setSystemVersion(systemVersion);
			
		}
	}

	@Override
	public void innerSave(PushRuleInfoForm form, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		//ִ�и��»򱣴�Ĳ���
		PushRuleInfo pushRuleInfo = form.toObj();
		try{
			service.saveOrUpdate(pushRuleInfo);
		}catch(DuplicateKeyException e){
			errors.addError(new ObjectError("database", "�����Ѿ����ڣ�"));
		}
	}
	 @Override
	 protected boolean preList(int page, Paginator paginator, Query.NameQuery query, Model model) {
	       paginator.setNeedTotal(true);//��ҳ
	       model.addAttribute("countryMap", Country.shortcut2CountryMap);
	       return super.preList(page, paginator, query, model);
	   }
	 @Override
	    protected void postCreate(Model model) {
	        model.addAttribute("countries", Country.countries);
	    }

	    @Override
	    protected void postModify(int id, PushRuleInfo obj, Model model) {
	        postCreate(model);
	    }

	    @Override
	    protected void onSaveError(PushRuleInfoForm form, BindingResult errors, Model model, HttpServletRequest request, HttpServletResponse response) {
	        postCreate(model);
	    }
	 
}
