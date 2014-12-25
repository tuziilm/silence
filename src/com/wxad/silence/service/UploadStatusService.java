package com.wxad.silence.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.UploadData;
import com.wxad.silence.domain.UploadStatus;
import com.wxad.silence.persistence.UploadDataMapper;
import com.wxad.silence.persistence.UploadStatusMapper;

/**
 * ϵͳ�û����ݲ���������
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
@Service
public class UploadStatusService  extends SimpleCacheSupportService<UploadStatus> {
	
	@Resource
	private UploadStatusMapper uploadStatusMapper;

	public int insertUploadStatus(UploadStatus uploadStatus) {
		return uploadStatusMapper.insertUploadStatus(uploadStatus);
	}
	
	public UploadStatus getById(String id) {
		return uploadStatusMapper.getById(id);
	}
	
	public UploadStatus getByUuid(String uuid) {
		return uploadStatusMapper.getByUuid(uuid);
	}
}
