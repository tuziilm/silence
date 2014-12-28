package com.wxad.silence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.persistence.PushRuleInfoMapper;

@Service
public class PushRuleInfoService extends SimpleCacheSupportService<PushRuleInfo> {
	private PushRuleInfoMapper pushRuleInfoMapper;
	@Autowired
	public void setLinkMapper(PushRuleInfoMapper pushRuleInfoMapper) {
		this.mapper = pushRuleInfoMapper;
		this.pushRuleInfoMapper=pushRuleInfoMapper;
	}
}
