package com.wxad.silence.mvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.wxad.silence.domain.UpdateInfo;
import com.wxad.silence.exception.UploadException;
import com.wxad.silence.service.PushRuleInfoService;
import com.wxad.silence.service.UpdateInfoService;

@Controller
@RequestMapping("/push/update")
public class UpdateInfoController extends CRUDController<UpdateInfo, UpdateInfoService, UpdateInfoController.Form, Query.NameQuery>{
	@Resource
	private PushRuleInfoService pushRuleInfoService;
	
	public UpdateInfoController() {
		super("push/update");
	}
	@Resource
	public void setUpdateInfoService(UpdateInfoService updateInfoService){
		this.service=updateInfoService;
	}
	 @Override
	    protected void postCreate(Model model) {
	    	model.addAttribute("pushRuleList", pushRuleInfoService.getAllPushRulesCache());
	    }
	    @Override
	    protected void postModify(int id, UpdateInfo obj, Model model) {
	    	postCreate(model);
	    }
	    @Override
	    protected void onSaveError(Form form, BindingResult errors, Model model,
	    		HttpServletRequest request, HttpServletResponse response) {
	    	postCreate(model);
	    }
    @Override
    protected boolean preList(int page, Paginator paginator, Query.NameQuery query, Model model) {
        paginator.setNeedTotal(true);
        return super.preList(page, paginator, query, model);
    }

    @Override
	public void innerSave(Form form, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
    	UpdateInfo updateInfo=form.toObj();
		try{
			try{
				if(!form.url.isEmpty()){
					String url = UpLoads.upload(form.url,UploadType.APK);
					updateInfo.setUrl(url);
					updateInfo.setHash(SHA256Util.class.newInstance().getHash(url));
				}
			}catch(UploadException e){
				errors.addError(new ObjectError("upload", "上传失败！"));
				return;
			}
            service.saveOrUpdate(updateInfo);
		} catch (Exception e) {
			errors.addError(new ObjectError("ex", e.getMessage()));
		} 
	}

	public static class Form extends IdForm<UpdateInfo> {
        @NotBlank(message = "version不能为空")
        private String version;
        private MultipartFile url;
        private Integer pushId;

        @Override
        public UpdateInfo newObj() {
            return new UpdateInfo();
        }

        @Override
        public void silenceulateObj(UpdateInfo updateInfo) {
        	updateInfo.setVersion(version);
        	updateInfo.setPushId(pushId);
        	
        }

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public MultipartFile getUrl() {
			return url;
		}

		public void setUrl(MultipartFile url) {
			this.url = url;
		}

		public Integer getPushId() {
			return pushId;
		}

		public void setPushId(Integer pushId) {
			this.pushId = pushId;
		}

    }
}
