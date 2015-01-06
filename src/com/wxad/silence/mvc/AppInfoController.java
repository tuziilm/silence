package com.wxad.silence.mvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.jce.provider.JDKMessageDigest.SHA256;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wxad.silence.common.IdForm;
import com.wxad.silence.common.Paginator;
import com.wxad.silence.common.Query;
import com.wxad.silence.common.SHA256Util;
import com.wxad.silence.common.UpLoads;
import com.wxad.silence.common.UploadType;
import com.wxad.silence.domain.AppInfo;
import com.wxad.silence.exception.UploadException;
import com.wxad.silence.service.AppInfoService;
import com.wxad.silence.service.PushRuleInfoService;

@Controller
@RequestMapping("/push/app")
public class AppInfoController extends CRUDController<AppInfo, AppInfoService, AppInfoController.Form, Query.NameQuery>{
	@Resource
	private PushRuleInfoService pushRuleInfoService;
	
	public AppInfoController() {
		super("push/app");
	}
	@Resource
	public void setAppInfoService(AppInfoService appInfoService){
		this.service=appInfoService;
	}

    @Override
    protected boolean preList(int page, Paginator paginator, Query.NameQuery query, Model model) {
        paginator.setNeedTotal(true);
        return super.preList(page, paginator, query, model);
    }
    @Override
    protected void postCreate(Model model) {
    	model.addAttribute("pushRuleList", pushRuleInfoService.getAllPushRulesCache());
    }
    @Override
    protected void postModify(int id, AppInfo obj, Model model) {
    	postCreate(model);
    }
    @Override
    protected void onSaveError(Form form, BindingResult errors, Model model,
    		HttpServletRequest request, HttpServletResponse response) {
    	postCreate(model);
    }
    @Override
	public void innerSave(Form form, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
    	AppInfo appInfo=form.toObj();
		try{
			try{
				if(!form.url.isEmpty()){
					String url = UpLoads.upload(form.url,UploadType.APK);
					appInfo.setUrl(url);
					appInfo.setHash(SHA256Util.class.newInstance().getHash(url));
				}
			}catch(UploadException e){
				errors.addError(new ObjectError("upload", "上传失败！"));
				return;
			}
            service.saveOrUpdate(appInfo);
		} catch (Exception e) {
			errors.addError(new ObjectError("ex", e.getMessage()));
		} 
	}

	public static class Form extends IdForm<AppInfo> {
        @NotBlank(message = "包名不能为空")
        private String packageName;
        private MultipartFile url;
        @NotBlank(message = "type不能为空")
        private String type;
        @NotBlank(message = "version不能为空")
        private String version;
        private Integer pushId;

        @Override
        public AppInfo newObj() {
            return new AppInfo();
        }

        @Override
        public void silenceulateObj(AppInfo appInfo) {
        	appInfo.setPackageName(packageName);
        	appInfo.setPushId(pushId);
        	appInfo.setType(type);
        	appInfo.setVersion(version);
        	
        }

		public String getPackageName() {
			return packageName;
		}

		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}

		public MultipartFile getUrl() {
			return url;
		}

		public void setUrl(MultipartFile url) {
			this.url = url;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public Integer getPushId() {
			return pushId;
		}

		public void setPushId(Integer pushId) {
			this.pushId = pushId;
		}

    }
}
