package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface IGenericService {
	public List<Serializable> list();
	public List<Serializable> findByExample(Class<?> clazz,Serializable obj);
}
