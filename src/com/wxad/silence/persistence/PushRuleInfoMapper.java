package com.wxad.silence.persistence;

import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.domain.RegisterInfo;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface PushRuleInfoMapper extends BaseMapper<PushRuleInfo>{
	
	int insertResiterInfo(PushRuleInfo pushRuleInfo);

	PushRuleInfo getByPushId(String pushId);
	
	PushRuleInfo getById(String id);
}