package com.wxad.silence.persistence;

import com.wxad.silence.domain.UpdateInfo;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface UpdateInfoMapper extends BaseMapper<UpdateInfo>{
	
	int insertUpdateInfo(UpdateInfo updateInfo);

	UpdateInfo getByPushId(String pushId);
	
	UpdateInfo getById(String id);
}