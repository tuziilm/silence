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
import com.wxad.silence.domain.ActiveInfo;
import com.wxad.silence.domain.AppInfo;
import com.wxad.silence.mvc.AppInfoController.Form;
import com.wxad.silence.service.ActiveInfoService;
import com.wxad.silence.service.PushRuleInfoService;

@Controller
@RequestMapping("/push/active")
public class ActiveInfoController extends CRUDController<ActiveInfo, ActiveInfoService, ActiveInfoController.Form, Query.NameQuery>{
	@Resource
	private PushRuleInfoService pushRuleInfoService;

	
	public ActiveInfoController() {
		super("push/active");
	}
	@Resource
	public void setActiveInfoService(ActiveInfoService activeInfoService){
		this.service=activeInfoService;
	}

    @Override
    protected boolean preList(int page, Paginator paginator, Query.NameQuery query, Model model) {
        paginator.setNeedTotal(true);
        return super.preList(page, paginator, query, model);
    }
    
    @Override
    protected void postCreate(Model model) {
    	model.addAttribute("pushRuleList", pushRuleInfoService.getAllPushRulesCache());
    	model.addAttribute("pushRuleMap", pushRuleInfoService.getAllPushRulesMapCache());
    }
    
    @Override
    protected void postModify(int id, ActiveInfo obj, Model model) {
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
    	ActiveInfo activeInfo=form.toObj();
		try{
            service.saveOrUpdate(activeInfo);
		} catch (Exception e) {
			errors.addError(new ObjectError("ex", e.getMessage()));
		} 
	}

	public static class Form extends IdForm<ActiveInfo> {
        @NotBlank(message = "包名不能为空")
        private String packageName;
        private Integer count;
        @NotBlank(message = "date不能为空")
        private String date;
        private Integer pushId;

        @Override
        public ActiveInfo newObj() {
            return new ActiveInfo();
        }

        @Override
        public void silenceulateObj(ActiveInfo activeInfo) {
        	activeInfo.setPackageName(packageName);
        	activeInfo.setCount(count);
        	activeInfo.setDate(date);
        	activeInfo.setPushId(pushId);
        	
        }

		public String getPackageName() {
			return packageName;
		}

		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Integer getPushId() {
			return pushId;
		}

		public void setPushId(Integer pushId) {
			this.pushId = pushId;
		}

    }
}
