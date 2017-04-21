package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.GoodsImageRelationMapper;
import com.market.dao.ImageMapper;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.utils.LoggerUtil;
import com.market.vo.ResponseModel;

@Service
public class ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private GoodsImageRelationMapper goodsImageRelationMapper;
	
	@Transactional
	public ResponseModel deleteGoodsImage(String imageId) {
		ResponseModel responseModel = null;
		try {
			Image image = imageMapper.selectByPrimaryKey(imageId);
			image.setIsDeleted(true);
			imageMapper.updateByPrimaryKey(image);
			List<GoodsImageRelation> listRelation = goodsImageRelationMapper.selectMany("",imageId);
			for(GoodsImageRelation relation : listRelation) {
				relation.setIsDeleted(true);
				goodsImageRelationMapper.updateByPrimaryKey(relation);
			}
			responseModel = ResponseModel.buildSuccess();
		} catch (Exception e) {
			LoggerUtil.getLogger(this).error("删除商品图片以及关联异常",e);
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}	
	
}
