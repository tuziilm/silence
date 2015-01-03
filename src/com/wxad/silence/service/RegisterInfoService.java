package com.wxad.silence.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.RegisterInfoList;
import com.wxad.silence.persistence.RegisterInfoMapper;

/**
 * 系统用户数据操作服务类
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 */
@Service
public class RegisterInfoService  extends SimpleCacheSupportService<RegisterInfo> {
	
	@Resource
	private RegisterInfoMapper registerInfoMapper;
	@Autowired
	public void setRegisterInfoMapper(RegisterInfoMapper registerInfoMapper) {
		this.mapper = registerInfoMapper;
		this.registerInfoMapper=registerInfoMapper;
	}
	
	public RegisterInfo getByUuid(String uuid) {
		return registerInfoMapper.getByUuid(uuid);
	}
	public List<RegisterInfoList> countActivity(Paginator paginator){
		return registerInfoMapper.countActivity(paginator);
	}
	public int countAll(Paginator paginator){
		return registerInfoMapper.countAll(paginator);
	}
}
