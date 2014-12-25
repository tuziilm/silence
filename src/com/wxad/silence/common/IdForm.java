package com.wxad.silence.common;

import com.wxad.silence.domain.Id;

/**
 * ����ID�ı�����
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public abstract class IdForm<T extends Id> {
    protected Integer id;

    public abstract T newObj();
    public abstract void silenceulateObj(T obj);

    public T toObj(){
        T t= newObj();
        t.setId(id);
        silenceulateObj(t);
        return t;
    }
    
    public boolean isModified(){
    	return id != null && id > 0;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
