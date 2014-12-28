package com.wxad.silence.mvc;

import com.wxad.base.util.DesUtil;
import com.wxad.base.util.Utils;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.UploadDataInfo;
import com.wxad.silence.service.RegisterInfoService;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 数据上传
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
@Controller
@RequestMapping(value="/rs")
public class RegisterInfoController{

	private static final Logger logger = Logger
			.getLogger(RegisterInfoController.class);

	@Resource
	private RegisterInfoService registerInfoService;
	
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
			
			registerInfoService.save(registerInfo);

			return Utils.responseCode(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			return Utils.responseCode(Boolean.FALSE);
		}
	}
	
}
