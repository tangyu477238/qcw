//var url=GetRequest();
var httpUrl = "http://huocheyun.xicp.net:13317";

$(function(){
	/*function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串
		var theRequest = new Object();
		 if (url.indexOf("?") != -1) {
		       var str = url.substr(1);
		       strs = str.split("&");
		       for (var i = 0; i < strs.length; i++) {
		           theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
		       }
		   }
		 return theRequest;
	}*/
	var pid = localStorage.getItem("yid");
	var cInfo = localStorage.getItem("carInfo");
	
	showList(pid,cInfo);
})
function showList(pid,cInfo){
	
	$.ajax({
			url : httpUrl+"/biz/brand/getProduct?pid="+pid,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
           // jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html = "";
				html += '<div class="bytitle">'+cInfo+'</div>';
				for(var i=0;i<data.length;i++){

					html += "<ul class='bytitleUl'>"
				html += "<li class='clearfix'>"
				html +=	
						"<div class='time1 clearfix'>"+
							'<div data-v-59f76ae0="" class="proItem">'+ 
							'<div data-v-6dfbde68="" data-v-59f76ae0="">'+
							'<div data-v-6dfbde68="" class="itemdes"><span data-v-6dfbde68="" class="imgBg"><img  style="width:80px;height:80px;" data-v-6dfbde68="" src="'+data[i].image+'"></span>' +
							'<div data-v-6dfbde68="" class="rightInfo">'+
							'<div data-v-6dfbde68="" class="titletxt">'+
							'<p data-v-6dfbde68="">'+data[i].displayName+' </p>'+
							
							'</div></div></div></div></div></div>'+
		
					"</li>"
		
		html += "<ul>";
	}
	$("#list").html(html);
	$("#list li .time1").click(function(){
		$("#list li .time2").hide();
		$("#list li").removeClass("on");
		$(this).parent().addClass("on");
		$(this).parent().find(".time2").show();
		$(this).parent().find(".input2").val("1");
		//totalPrice();
	})
	$("#list li:eq(0) .time1").click();
				
			}
			})
	//var data =  [{"name":"常规保养项目","list":[{"text":"小保养服务"},{"text":"大保养服务"}]},
	//			{"name":"空调系统养护","list":[{"text":"空调滤清器"},{"text":"空调管路杀菌"},{"text":"蒸发箱清洗"},{"text":"空调管路杀菌"}]}];
	//var html = "";
	//for(var i=0;i<data.length;i++){
	//	html += '<div class="bytitle">'+data[i].name+'</div>';
	//	html += "<ul class='bytitleUl'>"
	//	for(var j=0;j<data[i].list.length;j++){
	//		if(i==0 && j==0){
	//			html += "<li class='clearfix on'>"
	//		}else{
	//			html += "<li class='clearfix'>"
	//		}
			
	//			html +=	"<div class='time1 clearfix'>"+
						//	"<div class='left'><p>小保养服务<span class='span'>券</span></p><div class=\"warn\">5000km或6个月/次</div></div>" +
							//"<div class='right'><span class='org'>领券</span><span  class=\"seperator\">|</span></div>" +
					//	"</div>"+
					//	"<div class='time2'>"+
						//	'<div data-v-59f76ae0="" class="proItem">'+ 
						//	'<div data-v-6dfbde68="" data-v-59f76ae0="">'+
						//	'<div data-v-6dfbde68="" class="itemdes"><span data-v-6dfbde68="" class="imgBg"><img data-v-6dfbde68="" src="https://img4.tuhu.org/Images/Products/6c00/99ba/c29ebfce10dd8f542b59e716_w820_h820.png@163w_163h_100Q.png"></span>' +
						//	'<div data-v-6dfbde68="" class="rightInfo">'+
						//	'<div data-v-6dfbde68="" class="titletxt">'+
						//	'<p data-v-6dfbde68="">【正品授权】壳牌/Shell 超凡喜力 全合成机油 新中超版 ULTRA 5W-40 SN 灰壳（4L装） </p>'+
						//	'<div data-v-6dfbde68="" class="tip"><span data-v-6dfbde68="" style="color: rgb(228, 184, 114); border-color: rgb(228, 184, 114);">全合成</span><span data-v-6dfbde68="" style="color: rgb(141, 151, 247); border-color: rgb(141, 151, 247);">5W-40'+
				//'</span><span data-v-6dfbde68="" style="color: rgb(141, 151, 247); border-color: rgb(141, 151, 247);">SN'+
				//			'</span><span data-v-6dfbde68="" style="color: rgb(141, 151, 247); border-color: rgb(141, 151, 247);">4L</span></div>'+
				//			'<div data-v-6dfbde68="" class="price">'+
				//			'<div data-v-6dfbde68="" class="red"><em data-v-6dfbde68="">¥</em><span class="pck_price" val="299">299</span></div> <span data-v-6dfbde68="" class="num"><span class="decrease" onClick="decClick(this)"></span><span class="input"><input type="text" class="input2" value="1" readonly="readonly" maxlength="4"></span><span class="increase" onClick="addClick(this)"></span></span>'+
				//			'</div></div></div></div></div>'+
		//'<div data-v-59f76ae0="" class="add1L"><span data-v-59f76ae0="">参考用量：4.0L</span> <span data-v-59f76ae0="" class="suggest">'+
			//	'您也可以：<span data-v-59f76ae0="" class="orange">添加1L装</span></span></div></div>' +
			//				'<div data-v-59f76ae0="" class="last" style=""><div data-v-59f76ae0="" class="proItem"><div data-v-6dfbde68="" data-v-59f76ae0=""><div data-v-6dfbde68="" class="itemdes"><span data-v-6dfbde68="" class="imgBg"><img data-v-6dfbde68="" src="https://img4.tuhu.org/Images/Products/2a6c/5105/8e8b611f04c623490f646dce_w800_h800.jpg@163w_163h_100Q.jpg"></span> <div data-v-6dfbde68="" class="rightInfo"><div data-v-6dfbde68="" class="titletxt"><p data-v-6dfbde68="">曼牌/MANNFILTER 机油滤清器 W712/92</p> <!----> <div data-v-6dfbde68="" class="price"><p data-v-6dfbde68="" class="red"><em data-v-6dfbde68="">¥</em><span class="pck_price" val="36">36</span></p> <span data-v-6dfbde68="" class="num"><span class="decrease" onClick="decClick(this)"></span><span class="input"><input type="text" class="input2" value="1" readonly="readonly" maxlength="4"></span><span class="increase" onClick="addClick(this)"></span></span></div></div> <!----></div></div></div> <!----></div> <!----></div>' +
			//			"</div>" +
			//		"</li>"
		//}
		//html += "<ul>";
	//}
	//$("#list").html(html);
	//$("#list li .time1").click(function(){
	//	$("#list li .time2").hide();
	//	$("#list li").removeClass("on");
	//	$(this).parent().addClass("on");
	//	$(this).parent().find(".time2").show();
	//	$(this).parent().find(".input2").val("1");
	//	totalPrice();
	//})
	//$("#list li:eq(0) .time1").click();
}

function decClick(obj){
	var val = $(obj).parent().find("input").val();
	val--;
	if(val < 1){
		val = 1;
	}
	$(obj).parent().find("input").val(val);
	var num = $(obj).parent().parent().find(".pck_price").attr("val");
	totalPrice();
}
function addClick(obj){
	var val = $(obj).parent().find("input").val();
	val++;
	$(obj).parent().find("input").val(val);
	var num = $(obj).parent().parent().find(".pck_price").attr("val");
	totalPrice();
}
function totalPrice(){
	var totalPrice = 0;
	var price = 0;
	$(".bytitleUl li.on .pck_price").each(function(){
		price += parseInt($(this).text()) * $(this).parent().parent().find(".input2").val();
	});
	totalPrice =price.toFixed(0);
	$("#totalprice").html("¥"+totalPrice);
}