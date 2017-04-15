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
}, {
	domain : 'sales_status',
	code : 1,
	label : '在职'
},{
	domain : 'sales_status',
	code : 2,
	label : '离职'
},{
	domain : 'sales_status',
	code : 3,
	label : '辞退'
},{
	domain : 'commision_applicant_type',
	code : 1,
	label : '公司'
},{
	domain : 'commision_applicant_type',
	code : 2,
	label : '员工'
},{
	domain : 'company_status',
	code : 1,
	label : '正常'
},{
	domain : 'company_status',
	code : 2,
	label : '解除合作'
}];

// 产品性质
var BasicData_ProductNature = "product_nature";
// 商品状态
var BasicData_GoodsStatus = "goods_status";
// 员工状态
var BasicData_SalesStatus = "sales_status";
// 佣金记录获得者类型
var BasicData_CommisionApplicantType = "commision_applicant_type";
// 公司状态
var BasicData_CompanyStatus = "company_status";

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