//var url=GetRequest();
var httpUrl = "http://huocheyun.xicp.net:13317";
var brand = localStorage.getItem("cType");
var imgUrl = localStorage.getItem("imgUrl");
var carName = localStorage.getItem("carName");
$(function() {
	
	
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
	var pid = localStorage.getItem("cid");
	
	getCarContList(pid);
			

			
	
})

//排量
function getCarContList(pid){
	$(".ths_carDetailHd").html('<div class="th_carDetailHd-icon"><div class="th_icon-box"><img alt="" src='+imgUrl+'></div></div><div class="th_carDetailHd-text">'+brand+'>'+carName+'</div>');
	$.ajax({
			url : httpUrl+"/biz/brand/getPailiang?pid="+pid,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
           // jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html = "";	
				for(var i=0;i<data.length;i++){
				html += "<li class=\"th_carContList-item\" onClick=\"selectCarCont(this,'"+data[i].id+"','"+data[i].name+"')\">"+data[i].name+"</li>"
			}
			$("#ths_carContList").html(html);
				
			}
			})
	//var html = "";
	//for(var i=0;i<10;i++){
	//	html = '<li class="th_carContList-item" onClick="selectCarCont(this)">1.4T(35TFSI)</li>'
	//}
	//$("#ths_carContList").html(html);
}
//选择年份
function selectCarCont(obj,pid,cName){
	var text = $(obj).html();
	$.ajax({
			url : httpUrl+"/biz/brand/getYear?pid="+pid,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
           // jsonpCallback:"success_jsonpCallback",
			success : function(data){
				$(".ths_carDetailMap").prepend('<span class="th_carDetailMap-item" id="selectCarCont" onClick="baclSelectCarCont()">'+text+'</span>');
				$(".th_item-more").html("选择年份");
				var html = "";
				for(var i=0;i<data.length;i++){
					html += "<li class='th_carContList-item'><a href='javascript:;' onClick='selectCarYear(this,\""+data[i].id+"\",\""+cName+"\",\""+data[i].name+"\")'>"+data[i].name+"年生产</a></li>"
				}
				$("#ths_carContList").html(html);
				
			}
			})
	//$(".ths_carDetailMap").prepend('<span class="th_carDetailMap-item" id="selectCarCont" onClick="baclSelectCarCont()">'+text+'</span>');
	//$(".th_item-more").html("选择年份");
	//var html = "";
	//for(var i=0;i<10;i++){
	//	html = '<li class="th_carContList-item" onClick="selectCarYear(this)">2016</li>'
	//}
	//$("#ths_carContList").html(html);
}

function selectCarYear(obj,id,cName,yName){
	//var year = $(obj).html();
	localStorage.setItem("yid",id);
	localStorage.setItem("carInfo",brand+">"+carName+">"+cName+">"+yName+"年生产");
	window.location.href = httpUrl+"/biz/brand/getselect";
}

function baclSelectCarCont(){
	$(".th_item-more").html("选择发动机排量");
	$("#selectCarCont").remove();
	getCarContList(pid);
}
