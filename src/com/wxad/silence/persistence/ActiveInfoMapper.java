package com.wxad.silence.persistence;

import com.wxad.silence.domain.ActiveInfo;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface ActiveInfoMapper extends BaseMapper<ActiveInfo>{
	
	int insertActiveInfo(ActiveInfo activeInfo);

	ActiveInfo getByPushId(int pushId);
	
	ActiveInfo getById(String id);
}