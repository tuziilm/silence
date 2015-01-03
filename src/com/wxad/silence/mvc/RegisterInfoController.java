package com.wxad.silence.mvc;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxad.base.util.DesUtil;
import com.wxad.base.util.Utils;
import com.wxad.silence.common.Country;
import com.wxad.silence.common.LoginContext;
import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.RegisterInfoList;
import com.wxad.silence.domain.UploadDataInfo;
import com.wxad.silence.service.RegisterInfoService;

/**
 * 数据上传
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
@Controller
@RequestMapping(value="/rs")
public class RegisterInfoController extends ListController<RegisterInfo, RegisterInfoService, com.wxad.silence.mvc.RegisterInfoController.Query>{
	public RegisterInfoController() {
		super("rs");
	}

	private static final Logger logger = Logger
			.getLogger(RegisterInfoController.class);

	@Resource
	public void RegisterInfoService(RegisterInfoService registerInfoService){
		this.service=registerInfoService;
	}
	@RequestMapping(value="/registerinfo",method=RequestMethod.POST)
	public  @ResponseBody  String registerInfo(UploadDataInfo data,
			HttpServletRequest request) {
		String txt = data.getData().replaceAll("\\\\", "");
		String jsonInfo = DesUtil.decode(txt);
		
		RegisterInfo registerInfo = new RegisterInfo();
		
		try{
			JSONObject registerInfoObject = new JSONObject(jsonInfo);
			registerInfo.setUuid(registerInfoObject.get("uuid").toString());
			registerInfo.setVersion(registerInfoObject.get("version").toString());
			registerInfo.setNetType(registerInfoObject.get("netType").toString());
			registerInfo.setChannel(registerInfoObject.get("channel").toString());
			registerInfo.setIsTablet(registerInfoObject.get("isTablet").toString());
			registerInfo.setMacAddress(registerInfoObject.get("macAddress").toString());
			registerInfo.setSystemVersion(registerInfoObject.get("systemVersion").toString());
			registerInfo.setSdkVersion(registerInfoObject.get("sdkVersion").toString());
			registerInfo.setModel(registerInfoObject.get("model").toString());
			registerInfo.setLanguage(registerInfoObject.get("language").toString());
			registerInfo.setCountry(Utils.shieldIp(request));
			registerInfo.setResolution(registerInfoObject.get("resolution").toString());
			registerInfo.setSize(registerInfoObject.get("size").toString());
			registerInfo.setRam(registerInfoObject.get("ram").toString());
			registerInfo.setRom(registerInfoObject.get("rom").toString());
			registerInfo.setHasSim(registerInfoObject.get("hasSim").toString());
			registerInfo.setIsRoot(registerInfoObject.get("isRoot").toString());
			registerInfo.setDatetime(Utils.getDateTime());
			
			service.save(registerInfo);

			return Utils.responseCode(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			return Utils.responseCode(Boolean.FALSE);
		}
	}
	 @Override
	 protected boolean preList(int page, Paginator paginator, Query query, Model model) {
	       model.addAttribute("countries", Country.countries);
	       model.addAttribute("countryMap", Country.shortcut2CountryMap);
	       query.datetime=query.datetime.replace("/", "-");
	       if(query.country.equals("all")){
	    	   query.country=null;
	       }
	       return super.preList(page, paginator, query, model);
	   }
	 @Override
	protected void postList(int page, Paginator paginator, Query query, 
			Model model) {
		int total = service.countAll(paginator);
		model.addAttribute("total", total);
		List<RegisterInfoList> countData = service.countActivity(paginator);
		model.addAttribute("countDatas", countData);
		model.addAttribute("date", query.datetime);
		super.postList(page, paginator, query, model);
	}
	 public static class Query extends com.wxad.silence.common.Query {
		private String channel;
		private String datetime;
		private String country;
		public Query() {
			this.datetime = DateFormatUtils.format(DateUtils.addDays(new Date(), -1), "yyyy-MM-dd");
			if(LoginContext.isAdmin()){
				this.channel=null;
			}else{
				this.channel=LoginContext.getUserChannel();
			}
			setCountry("all");
		}	

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
			addItem("channel", channel);
		}

		public String getDatetime() {
			return datetime;
		}

		public void setDatetime(String datetime) {
			this.datetime = datetime;
			addItem("datetime", datetime);
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
			addItem("country", country);
		}
		
	 }
	
}
