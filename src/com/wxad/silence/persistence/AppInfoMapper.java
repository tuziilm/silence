package com.wxad.silence.persistence;

import com.wxad.silence.domain.AppInfo;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface AppInfoMapper extends BaseMapper<AppInfo>{
	AppInfo getByPushId(int pushId);
}