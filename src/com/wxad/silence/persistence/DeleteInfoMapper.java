package com.wxad.silence.persistence;

import com.wxad.silence.domain.DeleteInfo;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface DeleteInfoMapper extends BaseMapper<DeleteInfo>{
	DeleteInfo getByPushId(int pushId);
}