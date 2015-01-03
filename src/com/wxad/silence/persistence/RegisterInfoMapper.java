package com.wxad.silence.persistence;

import java.util.List;

import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.RegisterInfo;
import com.wxad.silence.domain.RegisterInfoList;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface RegisterInfoMapper extends BaseMapper<RegisterInfo>{
	RegisterInfo getByUuid(String uuid);
	List<RegisterInfoList> countActivity(Paginator paginator);
	int countAll(Paginator paginator);
}