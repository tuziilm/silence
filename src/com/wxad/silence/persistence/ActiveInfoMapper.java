package com.wxad.silence.persistence;

import com.wxad.silence.domain.ActiveInfo;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface ActiveInfoMapper extends BaseMapper<ActiveInfo>{
	
	ActiveInfo getByPushId(int pushId);
	
}