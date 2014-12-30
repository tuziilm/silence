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

import com.wxad.silence.common.IdForm;
import com.wxad.silence.common.Paginator;
import com.wxad.silence.common.Query;
import com.wxad.silence.domain.UpdateInfo;
import com.wxad.silence.service.UpdateInfoService;

@Controller
@RequestMapping("/push/update")
public class UpdateInfoController extends CRUDController<UpdateInfo, UpdateInfoService, UpdateInfoController.Form, Query.NameQuery>{
	public UpdateInfoController() {
		super("push/update");
	}
	@Resource
	public void setUpdateInfoService(UpdateInfoService updateInfoService){
		this.service=updateInfoService;
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
            service.saveOrUpdate(updateInfo);
		} catch (Exception e) {
			errors.addError(new ObjectError("ex", e.getMessage()));
		} 
	}

	public static class Form extends IdForm<UpdateInfo> {
        @NotBlank(message = "version不能为空")
        private String version;
        @NotBlank(message = "hash不能为空")
        private String hash;
        @NotBlank(message = "url不能为空")
        private String url;
        @NotBlank(message = "pushId不能为空")
        private Integer pushId;

        @Override
        public UpdateInfo newObj() {
            return new UpdateInfo();
        }

        @Override
        public void silenceulateObj(UpdateInfo updateInfo) {
        	updateInfo.setVersion(version);
        	updateInfo.setUrl(url);
        	updateInfo.setHash(hash);
        	updateInfo.setPushId(pushId);
        	
        }

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
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
