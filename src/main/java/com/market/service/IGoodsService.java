package com.market.service;

import java.util.List;

import com.market.domain.Goods;
import com.market.requestmodel.GoodsForm;
import com.market.vo.ResponseModel;

public interface IGoodsService {
	
	int addGoods(GoodsForm goodsForm,String admin);
	
	List<Goods> getAll();

	List<Goods> getList(int pageIndex, int pageSize, String keyword, String orderby);
}
