package com.wxad.silence.persistence;

import com.wxad.silence.domain.UploadStatus;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface UploadStatusMapper extends BaseMapper<UploadStatus>{

	int insertUploadStatus(UploadStatus uploadStatus);
	
	UploadStatus getByUuid(String uuid);
	
	UploadStatus getById(String id);
}