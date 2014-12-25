package com.wxad.silence.persistence;

import com.wxad.silence.domain.UploadData;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface UploadDataMapper extends BaseMapper<UploadData>{
	
	int insertUploadData(UploadData upload);

	UploadData getByUuid(String uuid);
	
	UploadData getById(String id);
}