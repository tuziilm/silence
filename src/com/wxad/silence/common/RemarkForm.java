package com.wxad.silence.common;

import com.wxad.silence.domain.RemarkId;

/**
 * ����remark�ı�����
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public abstract class RemarkForm<T extends RemarkId> extends IdForm<T>{
    protected String remark;

    @Override
    public T toObj() {
        T t= super.toObj();
        t.setRemark(remark);
        return t;
    }

    public String getRemark() {
		return remark;
	}
    
    public void setRemark(String remark) {
		this.remark = remark;
	}
}
