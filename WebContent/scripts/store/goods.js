$(function() {


	$.ajax({
				url : HOST + '/api/store/getAllGoods',
				type : 'post',
				// dataType:'json',
				success : function(data) {
			        debugger;
					//var testdiv = document.getElementById("testdiv");
					var $testDiv = $('#goodsnDiv');
					var length = data.length;
					var goods = "";
					var companyId = $('#input-companyId').val();
					var salesId = $('#input-salsId').val();
					for (var i = 0; i < length; i++) {
						var path = data[0].imagePath;
						goods = '<div class="col-md-3 col-md2">'
							+'<div class="col-md1 simpleCart_shelfItem">'
							+'<a href="single.html">'
							+'<img class="img-responsive" src="'
							+ HOST
							+ path
							+ '" alt=""/></a>'
							+'<h3><a href="single.html">'+data[0].description+'</a></h3>'
							+'	<div class="price">'
							+'<h5 class="item_price">'+ data[0].goodPrice+'</h5>'
							+ '<a href="'+HOST+'store/goodsDetail?id='
							+ data[0].goodsId+'&companyId='+companyId+'&salesId='+salesId
							+ '" class="details">商品详情</a>'
							+'<div class="clearfix"> </div>'
							+'</div>'
							+'</div>'
							+' </div>'
					      /* + '<div class="col-md-3 col-md2">'
				         	+'<div class="col-md1 simpleCart_shelfItem">'
				         	+'<a href="single.html">'
				         	+'	<img class="img-responsive" src="'
							+ HOST+'images/timg.jpg" alt="" />'
				        	+'	</a>'
					        +'	<h3><a href="single.html">T-Shirt</a></h3>'
					        +'	<div class="price">'
					        +'	<h5 class="item_price">$300</h5>'
				        	+'	<a href="#" class="item_add">Add To Cart</a>'
				         	+'	<div class="clearfix"> </div>'
				        	+'	</div>'	
					        +'	</div>'
				        	+'	</div>'*/;					
						$testDiv.append(goods);
						
					}

					// $testDiv.html('<img src="' + HOST + 'images/ce1.jpg"');
					var jsons = data;
				}
			});
})
