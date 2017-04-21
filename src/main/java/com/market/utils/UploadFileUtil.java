package com.market.utils;

import java.io.File;

public class UploadFileUtil {
	
	public final static String UploadFileFolderPath = File.separator + "uploads";
	
	public final static String UploadFileFolderPath_GoodsImage = File.separator + "goods";

	/**
	 * 根据Content-Disposition从ContentType为form-data的request里提取文件名
	 * @param header
	 * @return
	 */
	public static String getFileNameByContentDisposition(String header){
		String[] tempArr1 = header.split(";");
		System.out.println(tempArr1);
		String[] tempArr2 = tempArr1[2].split("=");
		System.out.println(tempArr2);
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		
		System.out.println(fileName);
		return fileName;
	}
	
}
