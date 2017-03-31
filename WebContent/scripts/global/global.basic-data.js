// 基础数据

var globalBasicData = [ {
	domain : 'goods_status',
	code : 1,
	label : '初始化'
}, {
	domain : 'goods_status',
	code : 2,
	label : '即将上市'
}, {
	domain : 'goods_status',
	code : 3,
	label : '上架'
}, {
	domain : 'goods_status',
	code : 4,
	label : '下架'
}, {
	domain : 'product_nature',
	code : 1,
	label : '服务'
}, {
	domain : 'product_nature',
	code : 2,
	label : '实物'
} ];

// 产品性质
var BasicData_ProductNature = "product_nature";
// 商品状态
var BasicData_GoodsStatus = "goods_status";

function getBasicDataLabel(paramDomain, paramCode) {
	var result = '';
	for (var i = 0; i < globalBasicData.length; i++) {
		if (globalBasicData[i].domain == paramDomain && globalBasicData[i].code == paramCode) {
			result = globalBasicData[i].label;
			break;
		}
	}
	return result;
}