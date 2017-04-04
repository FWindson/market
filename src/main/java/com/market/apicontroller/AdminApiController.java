package com.market.apicontroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Goods;
import com.market.domain.Product;
import com.market.requestmodel.GoodsForm;
import com.market.requestmodel.GoodsFormProduct;
import com.market.service.IGoodsService;
import com.market.service.IProductService;
import com.market.service.impl.GoodsProductRelationService;
import com.market.service.impl.GoodsService;
import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;
import com.market.vo.GoodsEditModel;
import com.market.vo.PageDataModel;
import com.market.vo.ProductOfGoodsEditModel;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/api/admin")
public class AdminApiController {

	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	@Autowired
	@Qualifier("goodsService")
	private IGoodsService goodsService;
	@Autowired
	@Qualifier("goodsProductRelationService")
	private GoodsProductRelationService goodsProductRelationService;

	/**
	 * 获取登录ID
	 * @param session
	 * @return
	 */
	private String getLoginUserID(HttpSession session){
		Object administratorId = session.getAttribute(SessionKeyUtil.LoginAdministratorID);
		if (administratorId != null) 
			return administratorId.toString();
		else //TODO:改为""
			return "Windson";
	}
	/**
	 * 获取登录名
	 * @param session
	 * @return
	 */
	private String getLoginUserName(HttpSession session){
		Object administratorName = session.getAttribute(SessionKeyUtil.LoginAdministratorName);
		if (administratorName != null) 
			return administratorName.toString();
		else //TODO:改为""
			return "Windson";
	}
	
	@RequestMapping(value = "/addProduct", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String addProduct(@RequestParam("name") String name, @RequestParam("nature") short nature,
			@RequestParam("price") double price, @RequestParam("stock") int stock, HttpSession session) {
		ResponseModel responseModel;
		// TODO:修改为登录名
		Product product = productService.addProduct(name, nature, price, stock, getLoginUserName(session));
		if (product != null) {
			responseModel = ResponseModel.buildSuccess(product);
		} else {
			responseModel = ResponseModel.buildFailed("出现异常");
		}
		String json = JSON.toJSONString(responseModel);
		System.out.println(json);
		
		return json;
	}

	@RequestMapping(value = "/updateProduct", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String updateProduct(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("nature") short nature, @RequestParam("price") double price, @RequestParam("stock") int stock,
			HttpSession session) {
		ResponseModel responseModel = ResponseModel.buildFailed("修改失败");
		;
		// TODO:修改为登录名
		String admin = "Windson";
		int influence = productService.update(id, name, price, nature, stock, getLoginUserName(session));
		if (influence > 0) {
			responseModel = ResponseModel.buildSuccess();
		}
		String json = JSON.toJSONString(responseModel);
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/products", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String products(@RequestParam(required = false) Integer start,
			@RequestParam(required = false) Integer length) {
		List<Product> list = productService.getAll();
		ResponseModel response = ResponseModel.buildSuccess(list);
		String json = JSON.toJSONString(response);
		return json;
	}

	@RequestMapping(value = "/deleteProduct", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String deleteProduct(String uuid) {
		ResponseModel responseModel = ResponseModel.buildFailed("删除失败");
		int influence = productService.updateIsDeleted(uuid);
		if (influence > 0) {
			responseModel = ResponseModel.buildSuccess();
		}
		return JSON.toJSONString(responseModel);
	}

//	@RequestMapping(value = "/addGoods", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
//	@ResponseBody()
//	public ResponseModel addGoods(@RequestBody GoodsForm goodsForm,
//			HttpSession session) {
//		ResponseModel responseModel = null;
//		try {
//			int influence = goodsService.addGoods(goodsForm,getLoginUserName(session));
//			responseModel = ResponseModel.buildSuccess();
//		} catch (Exception e) {
//			responseModel = ResponseModel.buildFailed(e.getMessage());
//		}
//		return responseModel;
//	}

	@RequestMapping(value = "/addGoods", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String addGoods(@RequestBody GoodsForm goodsForm,
			HttpSession session) {
		ResponseModel responseModel = null;
		try {
			int influence = goodsService.addGoods(goodsForm,getLoginUserName(session));
			responseModel = ResponseModel.buildSuccess();
		} catch (Exception e) {
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return JSON.toJSONString(responseModel);
	}
	
	@RequestMapping(value = "/goods", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String goods(@RequestParam(required = true) int pageIndex,
			@RequestParam(required = true) int pageSize,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false) String orderby,
			HttpSession session) {
		PageDataModel pageDataModel = null;
		try {
			pageDataModel = goodsService.getList(pageIndex, pageSize, keyword, orderby);
		} catch (Exception e) {
			LoggerUtil.getLogger(this).error(e.getMessage());
			pageDataModel = PageDataModel.buildFailed(e.getMessage());
		}
		return JSON.toJSONString(pageDataModel);
	}
	
	@RequestMapping(value = "/getGoodsDetail", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String getGoodsDetail(String goodsId,
			Model model,
			HttpSession session){
		Goods goods = goodsService.getSingle(goodsId);
		List<ProductOfGoodsEditModel> products = goodsProductRelationService.getProductsOfGoods(goodsId);
		GoodsEditModel goodEditModel = new GoodsEditModel();
		goodEditModel.goods = goods;
		goodEditModel.products = products;
		String json = JSON.toJSONString(ResponseModel.buildSuccess(goodEditModel));
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value = "/updateGoods", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String updateGoods(@RequestBody GoodsForm goodsForm,
			HttpSession session) {
		ResponseModel responseModel = null;
		try {
			int influence = goodsService.updateGoods(goodsForm,getLoginUserName(session));
			responseModel = ResponseModel.buildSuccess();
		} catch (Exception e) {
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		String json = JSON.toJSONString(responseModel);
		System.out.println(json);
		return json;
	}
	
	/*@RequestMapping(value = "/addGoods", produces = "text/json;charset=UTF8", method = RequestMethod.POST)
	@ResponseBody()
	public String addGoods(@RequestParam("goods")GoodsForm goods,@RequestParam("products")GoodsFormProduct[] products) {
		String json = JSON.toJSONString(goods);
		//String json2 = JSON.toJSONString(products);
		System.out.print(json);
		//System.out.print(json2);
		return json;
	}*/
	
}
