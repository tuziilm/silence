package com.wxad.silence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.AppInfo;
import com.wxad.silence.persistence.AppInfoMapper;
@Service
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
