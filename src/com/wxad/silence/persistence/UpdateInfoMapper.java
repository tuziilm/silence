package com.wxad.silence.persistence;

import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.UpdateInfo;

/**
 * ibatis����ϵͳ�û�����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface UpdateInfoMapper extends BaseMapper<UpdateInfo>{
	
	int insertUpdateInfo(UpdateInfo updateInfo);

	UpdateInfo getByPushId(String pushId);
	
	UpdateInfo getById(String id);
}