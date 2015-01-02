package com.wxad.silence.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.persistence.PushRuleInfoMapper;

@Service
public class PushRuleInfoService extends ObjectBasedGroupCacheSupportService<PushRuleInfo> {
	private final static String LIST_ALL_KEY="list_all_key";
    private final static String MAP_ALL_KEY="map_all_key";

	private PushRuleInfoMapper pushRuleInfoMapper;
	@Autowired
	public void setLinkMapper(PushRuleInfoMapper pushRuleInfoMapper) {
		this.mapper = pushRuleInfoMapper;
		this.pushRuleInfoMapper=pushRuleInfoMapper;
	}
	@Override
	public String[] cacheGroupKeys() {
		return new String[]{LIST_ALL_KEY, MAP_ALL_KEY};
	}
	@Override
	public Object newObject(String cacheGroupKey) {
		 if(cacheGroupKey.startsWith("map")){
	            return new HashMap();
	        }else{
	            return new ArrayList();
	        }
	}
	@Override
	public void updateCacheList(Map<String, Object> update, PushRuleInfo t) {
		 ((List<PushRuleInfo>)update.get(LIST_ALL_KEY)).add(t);
	     ((Map<Integer, PushRuleInfo>)update.get(MAP_ALL_KEY)).put(t.getId(), t);
		
	}
	  public List<PushRuleInfo> getAllPushRulesCache(){
	        return (List<PushRuleInfo>)getCache(LIST_ALL_KEY);
	    }

	    public Map<Integer, PushRuleInfo> getAllPushRulesMapCache(){
	        return (Map<Integer, PushRuleInfo>)getCache(MAP_ALL_KEY);
	    }
}
