package com.wxad.silence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.ActiveInfo;
import com.wxad.silence.persistence.ActiveInfoMapper;
@Service
public class ActiveInfoService extends BaseService<ActiveInfo>{
	private ActiveInfoMapper activeInfoMapper;
	
	@Autowired
	public void setActiveInfoMapper(ActiveInfoMapper activeInfoMapper) {
		this.mapper = activeInfoMapper;
		this.activeInfoMapper=activeInfoMapper;
	}
	public ActiveInfo getByPushId(int pushId){
		return activeInfoMapper.getByPushId(pushId);
	}
}
