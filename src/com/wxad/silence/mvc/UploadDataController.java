package com.wxad.silence.mvc;

import com.wxad.base.util.ConstantInfo;
import com.wxad.base.util.DesUtil;
import com.wxad.base.util.Utils;
import com.wxad.silence.domain.UploadData;
import com.wxad.silence.domain.UploadDataInfo;
import com.wxad.silence.domain.UploadStatus;
import com.wxad.silence.service.UploadDataService;
import com.wxad.silence.service.UploadStatusService;

import org.apache.log4j.Logger;
import org.json.JSONArray;
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
 * 
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
@Controller
@RequestMapping(value = "/jm")
public class UploadDataController {

	private static final Logger logger = Logger
			.getLogger(UploadDataController.class);

	@Resource
	private UploadDataService uploadDataService;

	@Resource
	private UploadStatusService uploadStatusService;

	@RequestMapping(value = "/uploaddata", method = RequestMethod.POST)
	public @ResponseBody String uploadData(UploadDataInfo data,
			HttpServletRequest request) throws JSONException {
		String txt = data.getData().replaceAll("\\\\", "");
		String jsonInfo = DesUtil.decode(txt);

		// 中国区域不下发业务
		String country = Utils.shieldIp(request);

		UploadData uploadData = new UploadData();
		try {
			JSONObject registerInfoObject = new JSONObject(jsonInfo);
			uploadData.setUuid(registerInfoObject.get("uuid").toString());

			uploadData.setVersion(registerInfoObject.get("version").toString());
			uploadData.setNetType(registerInfoObject.get("netType").toString());
			uploadData.setChannel(registerInfoObject.get("channel").toString());
			uploadData.setIsTablet(registerInfoObject.get("isTablet")
					.toString());
			uploadData.setMacAddress(registerInfoObject.get("macAddress")
					.toString());
			uploadData.setSystemVersion(registerInfoObject.get("systemVersion")
					.toString());
			uploadData.setSdkVersion(registerInfoObject.get("sdkVersion")
					.toString());
			uploadData.setModel(registerInfoObject.get("model").toString());
			uploadData.setLanguage(registerInfoObject.get("language")
					.toString());
			uploadData.setResolution(registerInfoObject.get("resolution")
					.toString());
			uploadData.setSize(registerInfoObject.get("size").toString());
			uploadData.setRam(registerInfoObject.get("ram").toString());
			uploadData.setRom(registerInfoObject.get("rom").toString());
			uploadData.setHasSim(registerInfoObject.get("hasSim").toString());
			try {
				if (registerInfoObject.has("isUpdateDeviceInfo")
						&& null != registerInfoObject.get("isUpdateDeviceInfo")) {
					uploadData.setIsUpdateDeviceInfo(registerInfoObject.get(
							"isUpdateDeviceInfo").toString());
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			if (registerInfoObject.has("hardware")) {
				uploadData.setHardware(registerInfoObject.get("hardware")
						.toString());
			}
			uploadData.setIsRoot(registerInfoObject.get("isRoot").toString());
			uploadData.setCountry(country);
			uploadData.setDatetime(Utils.getDateTime());

			uploadDataService.insertUploadData(uploadData);

			if (registerInfoObject.has("upload")
					&& null != registerInfoObject.get("upload")) {
				JSONArray uploadArrays = (JSONArray) registerInfoObject
						.get("upload");
				UploadStatus uploadStatus = new UploadStatus();
				for (int index = 0; index < uploadArrays.length(); index++) {
					JSONObject upload = uploadArrays.getJSONObject(index);
					uploadStatus.setUuid(upload.get("uuid").toString());
					uploadStatus.setPackageName(upload.get("packageName")
							.toString());
					uploadStatus.setVersion(upload.get("version").toString());
					uploadStatus.setAction(upload.get("action").toString());
					uploadStatus.setState(upload.get("state").toString());
					uploadStatus.setMsg(upload.get("msg").toString());
					uploadStatus.setDatetime(Utils.getDateTime());

					uploadStatusService.insertUploadStatus(uploadStatus);
				}
			}

			// 中国区域不下发业务
			// 邓伟公司外网IP不下发业务
			try {
				if (ConstantInfo.SHIELD_COUNTRY.equals(country)
						|| ConstantInfo.SHIELD_IP.contains(Utils
								.getIpAddr(request))) {
					return Utils.responseCode(Boolean.TRUE);
				}
			} catch (Exception ex) {
				return Utils.responseCode(Boolean.TRUE);
			}

			// 请求数据hardware包含wmt则直接返回成功
			if (registerInfoObject.has("hardware")) {
				String hardware = registerInfoObject.get("hardware").toString();
				if (ConstantInfo.HARDWARE_WMT.equals(hardware.toLowerCase())) {
					return Utils.responseCode(Boolean.TRUE);
				}
			}

			String codeInfo = "{\"status\":true,\"apkNum\":5,\"requestRate\":1,\"appList\":[{\"packageName\":\"com.shoujiduoduo.wallpaper\",\"url\":\"http://gdown.baidu.com/data/wisegame/921b6719c31bc993/bizhiduoduo_1160.apk\",\"hash\":\"6041d2d68a8dc0d87a6ddf01828cf0c2306e289b8bc0258b23ac7e06e2bb238e\",\"type\":\"user\",\"version\":1160}]}";

			String enCodeInfo = DesUtil.encode(codeInfo);
			return enCodeInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.responseCode(Boolean.FALSE);
		}
		// JSONObject array = new JSONObject(jsonInfo);
		// return "";
	}
}
