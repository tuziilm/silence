package com.wxad.silence.persistence;

import com.wxad.silence.domain.AppInfo;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface AppInfoMapper extends BaseMapper<AppInfo>{
	
	int insertAppInfo(AppInfo appInfo);

	AppInfo getByPushId(String pushId);
	
	AppInfo getById(String id);
}