package com.wxad.silence.persistence;

import com.wxad.silence.domain.DeleteInfo;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface DeleteInfoMapper extends BaseMapper<DeleteInfo>{
	
	int insertDeleteInfo(DeleteInfo deleteInfo);

	DeleteInfo getByPushId(String pushId);
	
	DeleteInfo getById(String id);
}