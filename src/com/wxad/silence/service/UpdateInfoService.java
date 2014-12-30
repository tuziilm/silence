package com.wxad.silence.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.UpdateInfo;
import com.wxad.silence.persistence.UpdateInfoMapper;

public class UpdateInfoService extends BaseService<UpdateInfo>{
	private UpdateInfoMapper updateInfoMapper;
	
	@Autowired
	public void setUpdateInfoMapper(UpdateInfoMapper updateInfoMapper) {
		this.mapper = updateInfoMapper;
		this.updateInfoMapper=updateInfoMapper;
	}
	public UpdateInfo getByPushId(int pushId){
		return updateInfoMapper.getByPushId(pushId);
	}
}
