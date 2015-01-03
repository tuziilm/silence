package com.wxad.silence.persistence;

import java.util.List;

import com.wxad.silence.common.Paginator;
import com.wxad.silence.domain.JingMoInfo;
import com.wxad.silence.domain.JingMoInfoList;

/**
 * ibatis操作在线用户表的Mapper接口
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public interface JingMoInfoMapper extends BaseMapper<JingMoInfo>{
	List<JingMoInfoList> countActivity(Paginator paginator);
	int countAll(Paginator paginator);
}