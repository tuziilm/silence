package com.wxad.silence.persistence;

import com.wxad.silence.domain.RegisterInfo;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface RegisterInfoMapper extends BaseMapper<RegisterInfo>{
	
	int insertResiterInfo(RegisterInfo registerInfo);

	RegisterInfo getByUuid(String uuid);
	
	RegisterInfo getById(String id);
}