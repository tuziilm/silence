package com.wxad.silence.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.JingMoInfo;
import com.wxad.silence.domain.JingMoInfoList;
import com.wxad.silence.persistence.JingMoInfoMapper;

/**
 * 系统用户数据操作服务类
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 */
@Service
public class JingMoInfoService  extends SimpleCacheSupportService<JingMoInfo> {
	
	@Resource
	private JingMoInfoMapper jingMoInfoMapper;
	@Autowired
	public void setJingMoInfoMapper(JingMoInfoMapper jingMoInfoMapper) {
		this.mapper = jingMoInfoMapper;
		this.jingMoInfoMapper=jingMoInfoMapper;
	}
	public List<JingMoInfoList> countActivity(Paginator paginator){
		return jingMoInfoMapper.countActivity(paginator);
	}
	public int countAll(Paginator paginator){
		return jingMoInfoMapper.countAll(paginator);
	}
}
