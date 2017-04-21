package com.market.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.market.dao.GoodsImageRelationMapper;
import com.market.dao.ImageMapper;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.utils.LoggerUtil;
import com.market.utils.UploadFileUtil;
import com.market.vo.ResponseModel;

@Service
public class FileService {
	
	@Autowired
	ImageMapper imageMapper;
	@Autowired
	GoodsImageRelationMapper goodsImageRelationMapper;

	@Transactional
	public ResponseModel saveFileFromParts(Collection<Part> parts,String absUploadFileFolderPath,String goodsId,String admin) {
		ResponseModel responseModel = null;
		try {
//			String absUploadFileFolderPath = appRootPath + UploadFileUtil.UploadFileFolderPath;
			List<Image> listImage = new ArrayList<Image>();
			for(Part part : parts){
				String header = part.getHeader("content-disposition");
				String fileName = UploadFileUtil.getFileNameByContentDisposition(header);
				// 后缀
				String suffix = fileName.substring(fileName.lastIndexOf(".") , fileName.length());
				String newFileName = UUID.randomUUID().toString() + suffix;
				String absCompleteFilePath = absUploadFileFolderPath + File.separator + newFileName;
				part.write(absCompleteFilePath);
				// 图片信息持久化
				Image image = new Image();
				image.setId(UUID.randomUUID().toString());
				image.setFileName(newFileName);
				image.setRelativePath(UploadFileUtil.UploadFileFolderPath + UploadFileUtil.UploadFileFolderPath_GoodsImage + File.separator + newFileName);
				image.setSuffix(suffix);
				image.setCreateTime(new Date());
				image.setCreateBy(admin);
				image.setIsDeleted(false);
				imageMapper.insert(image);
				// 商品-图片关系
				GoodsImageRelation goodsImageRelation = new GoodsImageRelation();
				goodsImageRelation.setId(UUID.randomUUID().toString());
				goodsImageRelation.setGoodsId(goodsId);
				goodsImageRelation.setImageId(image.getId());
				goodsImageRelation.setCreateTime(new Date());
				goodsImageRelation.setIsDeleted(false);
				goodsImageRelationMapper.insert(goodsImageRelation);
				listImage.add(image);
			}
			responseModel = ResponseModel.buildSuccess(listImage);
		} catch (IOException e) {
			LoggerUtil.getLogger(this).error("保存商品图片异常",e);
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}
	
}
