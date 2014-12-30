package com.wxad.silence.persistence;

import com.wxad.silence.domain.ActiveInfo;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface ActiveInfoMapper extends BaseMapper<ActiveInfo>{
	
	ActiveInfo getByPushId(int pushId);
	
}