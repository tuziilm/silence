package com.wxad.silence.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.persistence.RegisterInfoMapper;

/**
 * 系统用户数据操作服务类
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 */
@Service
public class RegisterInfoService  extends SimpleCacheSupportService<RegisterInfo> {
	
	@Resource
	private RegisterInfoMapper registerInfoMapper;
	
	public int insertResiterInfo(RegisterInfo registerInfo){
		return registerInfoMapper.insertResiterInfo(registerInfo);
	}

	public RegisterInfo getById(String id) {
		return registerInfoMapper.getById(id);
	}
	
	public RegisterInfo getByUuid(String uuid) {
		return registerInfoMapper.getByUuid(uuid);
	}
}
