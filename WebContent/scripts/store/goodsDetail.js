/**
 * 增加數量
 * 
 * @returns
 */
function addOne() {
	var $num = $('#num');
	/* num.value = parseInt(num.value) + 1; */
	$num.val(parseInt($num.val()) + 1);
	var $sumPrice = $('#sumPrice');
	var $price = $('#price');
	$sumPrice.val($price.val() * $num.val());
	/* sumPrice.value= parseInt(num.value)*parseInt(price.value); */
}
/**
 * 減少數量
 * 
 * @returns
 */
function decOne() {
	var $num = $('#num');
	var $sumPrice = $('#sumPrice');
	var $price = $('#price');
	var number = $num.val() - 1;
	if (number < 1) {
		$num.val(1);
	} else {
		$num.val(parseInt($num.val()) - 1);
	}
	$sumPrice.val($price.val() * $num.val());
}

	$("#discountCode").change(function(){
		var form = {
			discountCode : $('#discountCode').val(),
			goodsId : $('#input-goodsId').val(),
			price : $('#price').val(),
			count : $('#num').val(),
		};
		$.ajax({
			url : HOST + 'api/store/discount',
			type : 'POST',
			data : form,
			success : function(response) {
				if (response.status == 200&&response.result>0) {
					debugger;
					var $sumPrice = $('#sumPrice');
					$sumPrice.val(response.result); 
				} else {
                    alert(response.message);
				}
			},
			error : function(errMsg) {
				 console.log(errMsg); 
			}
		});
	});

