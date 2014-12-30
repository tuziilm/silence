package com.wxad.silence.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxad.silence.domain.AppInfo;
import com.wxad.silence.persistence.AppInfoMapper;

public class AppInfoService extends BaseService<AppInfo>{
	private AppInfoMapper appInfoMapper;
	
	@Autowired
	public void setAppInfoMapper(AppInfoMapper appInfoMapper) {
		this.mapper = appInfoMapper;
		this.appInfoMapper=appInfoMapper;
	}
	public AppInfo getByPushId(int pushId){
		return appInfoMapper.getByPushId(pushId);
	}
}
