package com.wxad.silence.persistence;

import com.wxad.silence.domain.ActiveInfo;
import com.wxad.silence.domain.DeleteInfo;
import com.wxad.silence.domain.PushRuleInfo;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.UpdateInfo;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface DeleteInfoMapper extends BaseMapper<DeleteInfo>{
	
	int insertDeleteInfo(DeleteInfo deleteInfo);

	DeleteInfo getByPushId(String pushId);
	
	DeleteInfo getById(String id);
}