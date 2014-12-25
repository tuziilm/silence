package com.wxad.silence.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxad.silence.domain.UploadData;
import com.wxad.silence.persistence.UploadDataMapper;

/**
 * 系统用户数据操作服务类
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
@Service
public class UploadDataService  extends SimpleCacheSupportService<UploadData> {
	@Resource
	private UploadDataMapper uploadDataMapper;
	
	public int insertUploadData(UploadData upload){
		return uploadDataMapper.insertUploadData(upload);
	}

	public UploadData getById(String username) {
		return uploadDataMapper.getById(username);
	}
	
	public UploadData getByUuid(String uuid) {
		return uploadDataMapper.getByUuid(uuid);
	}
}
