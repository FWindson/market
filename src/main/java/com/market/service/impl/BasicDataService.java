package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.market.dao.BasicDataMapper;
import com.market.domain.BasicData;
import com.market.service.IBasicDatatService;

@Service("basicDataService")
public class BasicDataService implements IBasicDatatService {

	@Autowired
	private BasicDataMapper basicDataMapper;
	
	@Override
	public List<BasicData> getBasicDatas() {
		List<BasicData> listBasicData = basicDataMapper.selectAll();
		return listBasicData;
	}

}
