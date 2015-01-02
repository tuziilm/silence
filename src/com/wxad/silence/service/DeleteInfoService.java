package com.wxad.silence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.DeleteInfo;
import com.wxad.silence.persistence.DeleteInfoMapper;
@Service
public class DeleteInfoService extends BaseService<DeleteInfo>{
	private DeleteInfoMapper deleteInfoMapper;
	
	@Autowired
	public void setDeleteInfoMapper(DeleteInfoMapper deleteInfoMapper) {
		this.mapper = deleteInfoMapper;
		this.deleteInfoMapper=deleteInfoMapper;
	}
	public DeleteInfo getByPushId(int pushId){
		return deleteInfoMapper.getByPushId(pushId);
	}
}
