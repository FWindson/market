package com.market.service;

import java.util.List;

import com.market.domain.Goods;
import com.market.requestmodel.GoodsForm;
import com.market.vo.GoodsEditModel;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

public interface IGoodsService {
	
	int addGoods(GoodsForm goodsForm,String admin);
	
	int updateGoods(GoodsForm goodsForm,String admin);
	
	ResponseModel deleteGoods(String goodsId,String admin);
	
	List<Goods> getAll();

	PageDataModel getList(int pageIndex, int pageSize, String keyword, String orderby);
	
	Goods getSingle(String id);
	
	ResponseModel getGoodsEditModel(String goodsId);
	
}
