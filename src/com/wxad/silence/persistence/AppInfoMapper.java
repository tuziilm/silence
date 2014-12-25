package com.wxad.silence.persistence;

import com.wxad.silence.domain.ActiveInfo;
import com.wxad.silence.domain.AppInfo;
import com.wxad.silence.domain.DeleteInfo;
import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.UpdateInfo;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface AppInfoMapper extends BaseMapper<AppInfo>{
	
	int insertAppInfo(AppInfo appInfo);

	AppInfo getByPushId(String pushId);
	
	AppInfo getById(String id);
}