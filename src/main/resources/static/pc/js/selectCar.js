var carBrand;
var httpUrl = "http://huocheyun.xicp.net:13317";
$(function(){	
	var arrA = new Array();
	var arrB = new Array();
	var arrC = new Array();
	var arrD = new Array();
	var arrF = new Array();
	var arrG = new Array();
	var arrH = new Array();
	var arrJ = new Array();
	var arrK = new Array();
	var arrL = new Array();
	var arrM = new Array();
	var arrN = new Array();
	var arrO = new Array();
	var arrP = new Array();
	var arrQ = new Array();
	var arrR = new Array();
	var arrS = new Array();
	var arrT = new Array();
	var arrW = new Array();
	var arrX = new Array();
	var arrY = new Array();
	var arrZ = new Array();
	var arrHot = new Array();
	//初始化汽车品牌
$.ajax({
			url : httpUrl+"/biz/brand/list",
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
           // jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var htmlInfo="";
				
				for(var j = 0;j<data.length;j++){
					if(data[j].id=="1661"||data[j].id=="1662"||data[j].id=="1663"||data[j].id=="1667"||data[j].id=="1685"||data[j].id=="1703"
					||data[j].id=="1708"||data[j].id=="1677"||data[j].id=="1774"||data[j].id=="1775"||data[j].id=="1668"||data[j].id=="1776"
					||data[j].id=="1777"||data[j].id=="1666"||data[j].id=="1778"||data[j].id=="1779"||data[j].id=="1780"||data[j].id=="1754"
					||data[j].id=="1781"||data[j].id=="1782"){
						arrHot.push(data[j]);
						carBrand = data[j].brand.split("-");
						htmlInfo+= "<li class=\"CarBrand\" title=\""+data[j].brand+"\" data-id=\""+data[j].id+"\" data-brand=\""+data[j].brand+"\"><img class=\"img\" src=\""+data[j].url+"\"><span>"+carBrand[1]+"</span> </li>";
					}
				}
				$("#carsel-list").html(htmlInfo);
				selectCarselList();
				for(var i = 0;i<data.length;i++){
					if(data[i].pid=="A"){
						arrA.push(data[i]);
					}else if(data[i].pid=="B"){
						arrB.push(data[i]);
					}else if(data[i].pid=="C"){
						arrC.push(data[i]);
					}else if(data[i].pid=="D"){
						arrD.push(data[i]);
					}else if(data[i].pid=="F"){
						arrF.push(data[i]);
					}else if(data[i].pid=="G"){
						arrG.push(data[i]);
					}else if(data[i].pid=="H"){
						arrH.push(data[i]);
					}else if(data[i].pid=="J"){
						arrJ.push(data[i]);
					}else if(data[i].pid=="K"){
						arrK.push(data[i]);
					}else if(data[i].pid=="L"){
						arrL.push(data[i]);
					}else if(data[i].pid=="M"){
						arrM.push(data[i]);
					}else if(data[i].pid=="N"){
						arrN.push(data[i]);
					}else if(data[i].pid=="O"){
						arrO.push(data[i]);
					}else if(data[i].pid=="P"){
						arrP.push(data[i]);
					}else if(data[i].pid=="Q"){
						arrQ.push(data[i]);
					}else if(data[i].pid=="R"){
						arrR.push(data[i]);
					}else if(data[i].pid=="S"){
						arrS.push(data[i]);
					}else if(data[i].pid=="T"){
						arrT.push(data[i]);
					}else if(data[i].pid=="W"){
						arrW.push(data[i]);
					}else if(data[i].pid=="X"){
						arrX.push(data[i]);
					}else if(data[i].pid=="Y"){
						arrY.push(data[i]);
					}else if(data[i].pid=="Z"){
						arrZ.push(data[i]);
					}
				}
					
				
			}
		});
		//鼠标hover至指定字母显示对应的汽车品牌
	$("#carnav-letter li").hover(function(){
		$("#carnav-letter li").removeClass("CarZiMuSelect");
		$(this).addClass("CarZiMuSelect");
		var text = $(this).text();
		var html = "";
		var htmlCar = "";
		if(text == "A"){
			for(var i = 0;i<arrA.length;i++){
				carBrand = arrA[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrA[i].brand+"\" data-id=\""+arrA[i].id+"\" data-brand=\""+arrA[i].brand+"\"><img class=\"img\" src=\""+arrA[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "B"){
			for(var i = 0;i<arrB.length;i++){
				carBrand = arrB[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrB[i].brand+"\" data-id=\""+arrB[i].id+"\" data-brand=\""+arrB[i].brand+"\"><img class=\"img\" src=\""+arrB[i].url+"\"><span>"+carBrand[1]+"</span></li>";
			}
		}else if(text == "C"){
			for(var i = 0;i<arrC.length;i++){
				carBrand = arrC[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrC[i].brand+"\" data-id=\""+arrC[i].id+"\" data-brand=\""+arrC[i].brand+"\"><img class=\"img\" src=\""+arrC[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "D"){
			for(var i = 0;i<arrD.length;i++){
				carBrand = arrD[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrD[i].brand+"\" data-id=\""+arrD[i].id+"\" data-brand=\""+arrD[i].brand+"\"><img class=\"img\" src=\""+arrD[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "F"){
			for(var i = 0;i<arrF.length;i++){
				carBrand = arrF[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrF[i].brand+"\" data-id=\""+arrF[i].id+"\" data-brand=\""+arrF[i].brand+"\"><img class=\"img\" src=\""+arrF[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "G"){
			for(var i = 0;i<arrG.length;i++){
				carBrand = arrG[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrG[i].brand+"\" data-id=\""+arrG[i].id+"\"data-brand=\""+arrG[i].brand+"\"><img class=\"img\" src=\""+arrG[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "H"){
			for(var i = 0;i<arrH.length;i++){
				carBrand = arrH[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrH[i].brand+"\" data-id=\""+arrH[i].id+"\" data-brand=\""+arrH[i].brand+"\"><img class=\"img\" src=\""+arrH[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "J"){
			for(var i = 0;i<arrJ.length;i++){
				carBrand = arrJ[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrJ[i].brand+"\" data-id=\""+arrJ[i].id+"\" data-brand=\""+arrJ[i].brand+"\"><img class=\"img\" src=\""+arrJ[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "K"){
			for(var i = 0;i<arrK.length;i++){
				carBrand = arrK[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrK[i].brand+"\" data-id=\""+arrK[i].id+"\" data-brand=\""+arrK[i].brand+"\"><img class=\"img\" src=\""+arrK[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "L"){
			for(var i = 0;i<arrL.length;i++){
				carBrand = arrL[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrL[i].brand+"\" data-id=\""+arrL[i].id+"\"data-brand=\""+arrL[i].brand+"\"><img class=\"img\" src=\""+arrL[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "M"){
			for(var i = 0;i<arrM.length;i++){
				carBrand = arrM[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrM[i].brand+"\" data-id=\""+arrM[i].id+"\" data-brand=\""+arrM[i].brand+"\"><img class=\"img\" src=\""+arrM[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "N"){
			for(var i = 0;i<arrN.length;i++){
				carBrand = arrN[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrN[i].brand+"\" data-id=\""+arrN[i].id+"\" data-brand=\""+arrN[i].brand+"\"><img class=\"img\" src=\""+arrN[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "O"){
			for(var i = 0;i<arrO.length;i++){
				carBrand = arrO[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrO[i].brand+"\" data-id=\""+arrO[i].id+"\" data-brand=\""+arrO[i].brand+"\"><img class=\"img\" src=\""+arrO[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "P"){
			for(var i = 0;i<arrP.length;i++){
				carBrand = arrP[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrP[i].brand+"\" data-id=\""+arrP[i].id+"\" data-brand=\""+arrP[i].brand+"\"><img class=\"img\" src=\""+arrP[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "Q"){
			for(var i = 0;i<arrQ.length;i++){
				carBrand = arrQ[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrQ[i].brand+"\" data-id=\""+arrQ[i].id+"\" data-brand=\""+arrQ[i].brand+"\"><img class=\"img\" src=\""+arrQ[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "R"){
			for(var i = 0;i<arrR.length;i++){
				carBrand = arrR[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrR[i].brand+"\" data-id=\""+arrR[i].id+"\" data-brand=\""+arrR[i].brand+"\"><img class=\"img\" src=\""+arrR[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "S"){
			for(var i = 0;i<arrS.length;i++){
				carBrand = arrS[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrS[i].brand+"\" data-id=\""+arrS[i].id+"\" data-brand=\""+arrS[i].brand+"\"><img class=\"img\" src=\""+arrS[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "T"){
			for(var i = 0;i<arrT.length;i++){
				carBrand = arrT[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrT[i].brand+"\" data-id=\""+arrT[i].id+"\" data-brand=\""+arrT[i].brand+"\"><img class=\"img\" src=\""+arrT[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "W"){
			for(var i = 0;i<arrW.length;i++){
				carBrand = arrW[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrW[i].brand+"\" data-id=\""+arrW[i].id+"\" data-brand=\""+arrW[i].brand+"\"><img class=\"img\" src=\""+arrW[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "X"){
			for(var i = 0;i<arrX.length;i++){
				carBrand = arrX[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrX[i].brand+"\" data-id=\""+arrX[i].id+"\" data-brand=\""+arrX[i].brand+"\"><img class=\"img\" src=\""+arrX[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "Y"){
			for(var i = 0;i<arrY.length;i++){
				carBrand = arrY[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrY[i].brand+"\" data-id=\""+arrY[i].id+"\" data-brand=\""+arrY[i].brand+"\"><img class=\"img\" src=\""+arrY[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else if(text == "Z"){
			for(var i = 0;i<arrZ.length;i++){
				carBrand = arrZ[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrZ[i].brand+"\" data-id=\""+arrZ[i].id+"\" data-brand=\""+arrZ[i].brand+"\"><img class=\"img\" src=\""+arrZ[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}else{
			for(var i = 0;i<arrHot.length;i++){
				carBrand = arrHot[i].brand.split("-");
				htmlCar+= "<li class=\"CarBrand\" title=\""+arrHot[i].brand+"\" data-id=\""+arrHot[i].id+"\" data-brand=\""+arrHot[i].brand+"\"><img class=\"img\" src=\""+arrHot[i].url+"\"><span>"+carBrand[1]+"</span> </li>";
			}
		}
		$("#carsel-list").html(htmlCar);
		selectCarselList();
	});
	//selectCarselList();
	
	function success_jsonpCallback(data){
		console.info(data);
	}
	
})
//显示品牌下的车系（vehicleseries=null直接显示车名）
function selectCarselList(){
	$("#carsel-list li").click(function(){
		$("#cx2").attr("class","head_div2");
		$("#cx2 span").attr("class","round");
		$("#div2").hide();
		$("#div3").show();
		var CarHistoryTitle = $(this).find("span").text();
		var pId = $(this).attr("data-id");
		var title = '<div class="CarHistoryTitlediv"><div class="CarHistoryTitle">'+CarHistoryTitle+'</div><div class="CarHistoryTitleDel" onClick="closeDiv3()" data-index="1">X</div></div>';
		$("#carselSelect").append(title);
		$.ajax({
			url : httpUrl+"/biz/brand/getModel?pid="+pId,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html = "";
				/*for(var i = 0;i<data.length;i++){
					html += "<li class=\"CarVecl2\" onClick=\"CarBrandClick('"+i+"',this,'"+data[i].brand+"','"+data[i].carname+"')\" data-id=\""+data[i].id+"\" data-vehicle=\""+data[i].brand+"\">"+data[i].carname+"</li>";
				}*/
				var arr = new Array();
				var arr2 = new Array();
				var arr3 = new Array();
				var arr4 = new Array();
				for(var i = 0;i<data.length;i++){
					arr.push(data[i].brandtype);
					if(data[i].vehicleseries != null && data[i].vehicleseries){
						arr3.push(data[i].vehicleseries);
					}
					
				}
				for(var j = 0;j<arr.length;j++){
					if(arr2.indexOf(arr[j])==-1){
						if(arr[j] != null){
							arr2.push(arr[j]);
						}
					}
				}
				for(var m = 0;m<arr3.length;m++){
					if(arr4.indexOf(arr3[m])==-1){
						arr4.push(arr3[m]);
					}
				}
				var arrCar = new Array();
				var arrCar2 = new Array();
				if(arr2.length != 0){
					for(var s = 0;s<arr2.length;s++){
						html += '<li class="CarBrandTitle" >'+arr2[s]+':</li>';
						if(arr4.length != 0){
							for(var r = 0;r<arr4.length;r++){
								for(var h = 0;h<data.length;h++){
									if(arr2[s] == data[h].brandtype && arr4[r] == data[h].vehicleseries){
										arrCar.push(data[h].vehicleseries);
										//html += '<li class="CarVecl2" onClick="CarBrandClick('+h+',this)" data-id="VE-FTNZY" //data-vehicle="'+data[h].vehicle+'">'+data[h].vehicleseries+'</li>'
									}
								}
							}
							for(var l = 0;l<arrCar.length;l++){
								if(arrCar2.indexOf(arrCar[l])==-1){
									arrCar2.push(arrCar[l]);
								}
							}
							for(var t = 0;t<arrCar2.length;t++){
								html += "<li class=\"CarVecl2\" onClick=\"showCarNameClick('"+arrCar2[t]+"','"+data[t].pid+"','"+arr2[s]+"')\" data-id=\""+data[t].id+"\" data-vehicle=\"\">"+arrCar2[t]+"</li>";
							}
						}else{
							for(var o =0;o<data.length;o++){
								if(arr2[s] == data[o].brandtype){
									html += "<li class=\"CarVecl2\" onClick=\"CarBrandClick('"+o+"',this,'"+data[o].brand+"','"+data[o].carname+"','"+data[o].pid+"')\" data-id=\""+data[o].id+"\" data-vehicle=\"\">"+data[o].carname+"</li>";
								}
							}
						}
					
					$("#carVecl").html(html);
					}
				}
			}
		});
	})
}
//显示品牌下的车系和汽车名称
function showCarNameClick(vehicleseries,pid,brandType){
	$.ajax({
			url : httpUrl+"/biz/brand/getModel?pid="+pid,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data){
				
				var html = "";
				html += '<li class="CarBrandTitle" >'+brandType+':</li>';
				for(var i = 0;i<data.length;i++){
					if(vehicleseries == data[i].vehicleseries){
						html += "<li class=\"CarVecl2\" onClick=\"CarBrandClick('"+i+"',this,'"+data[i].brand+"','"+data[i].carname+"','"+data[i].pid+"')\" data-id=\""+data[i].id+"\" data-vehicle=\"\">"+data[i].carname+"</li>";
					}
				}
				$("#carVecl").html(html);
			}
		});
}

//显示排量
function CarBrandClick(i,obj,brand,carname,pid){
	$("#cx3").attr("class","head_div2");
	$("#cx3 span").attr("class","round");
	var CarHistoryTitle = $(obj).text();
	var pId = $(obj).attr("data-id");
	var title = '<div class="CarHistoryTitlediv" id="CarHistoryTitlediv'+i+'"><div class="CarHistoryTitle">'+CarHistoryTitle+'</div><div class="CarHistoryTitleDel" onClick="closeCarType(\'CarHistoryTitlediv'+i+'\',this,'+pid+')" data-index="">X</div></div>';
	$("#carselSelect").append(title);
	//var data =  {"list":[{"pailiang":"2.0T","text":"2.0T"},{"pailiang":"2.1T-柴油","text":"2.1T-柴油"},{"pailiang":"2.2T-柴油","text":"2.2T-柴油"},{"pailiang":"2.5L","text":"2.5L"}]};
	$.ajax({
			url : httpUrl+"/biz/brand/getPailiang?pid="+pId,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data){
				
				var html = "";
				for(var i=0;i<data.length;i++){
					html += "<li class=\"CarVecl2\" onClick=\"CarPaiLiangClick('"+i+"',this,'"+brand+"','"+carname+"','"+data[i].name+"')\" data-id=\""+data[i].id+"\" data-pailiang=\""+data[i].pkey+"\">"+data[i].name+"</li>";
				}
				$("#carVecl").html(html);
			}
		});
	
}
//显示生产年份
function CarPaiLiangClick(id,obj,brand,carname,pName){
	$("#cx4").attr("class","head_div2");
	$("#cx4 span").attr("class","round");
	var CarHistoryTitle = $(obj).text();
	var pId = $(obj).attr("data-id");
	var title = "<div class=\"CarHistoryTitlediv\" id=\"CarHistoryPaiLiang"+id+"\"><div class=\"CarHistoryTitle\">"+CarHistoryTitle+"</div><div class=\"CarHistoryTitleDel\" onClick=\"closeCarPaiLiang('"+id+"',this,'"+pId+"')\" data-index=\"\">X</div></div>";
	$("#carselSelect").append(title);
	
	//var data =  {"list":[{"nian":"2016","text":"2016"},{"nian":"2015","text":"2015"},{"nian":"2014","text":"2014"},{"nian":"2013","text":"2013"}]};
	$.ajax({
			url : httpUrl+"/biz/brand/getYear?pid="+pId,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data){
				
				var html = "";
				for(var i=0;i<data.length;i++){
					html += "<li class=\"CarVecl2\" onClick=\"CarPaiLiangNian('"+i+"',this,'"+brand+"','"+carname+"','"+pName+"','"+data[i].name+"')\" data-id='"+data[i].id+"' data-nian='"+data[i].name+"'>"+data[i].name+"年生产</li>"
				}
				$("#carVecl").html(html);
			}
		});
	
}

//显示产品
function CarPaiLiangNian(id,obj,brand,carname,pName,yName){
	$("#select-list").hide();
	$(".inventory").show();
	$("#proInfo").html("<ul><li style='width:100%;'>产品信息："+brand+">"+carname+">"+pName+">"+yName+"年生产</li></ul>");
	var pId = $(obj).attr("data-id");
	$.ajax({
			url : httpUrl+"/biz/brand/getProduct?pid="+pId,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html = "";
				
				html = '<table><tbody>';
				for(var i=0;i<data.length;i++){
					html += '<tr id="tr_'+i+'" data-id=""><td class=""><div class="more_info item clearfix"><div class="more_info item clearfix"><img class="img" src="https://img4.tuhu.org/Images/Products/6c00/99ba/c29ebfce10dd8f542b59e716_w820_h820.png@163w_163h_100Q.png" style="float:left;"><div class="pack_biaoti">'+data[i].prodName+'<div style="display: none" class="data_pid" data_pid="OL-SHELL-HELIXULTRA|4"></div><span class="itemTag qianscp">全合成</span></div></div></td></tr>'
				}
				html += "</tbody></table>";
				
				$("#table").html(html);
			}
		});
}
function decClick(obj){
	var val = $(obj).parent().find("input").val();
	val--;
	if(val < 1){
		val = 1;
	}
	$(obj).parent().find("input").val(val);
	var num = $(obj).parent().parent().find(".pck_price").attr("val");
	var price = (val * num).toFixed(2);
	$(obj).parent().parent().find(".pck_price").html("¥"+price);
	totalPrice();
}
function addClick(obj){
	var val = $(obj).parent().find("input").val();
	val++;
	
	$(obj).parent().find("input").val(val);
	var num = $(obj).parent().parent().find(".pck_price").attr("val");
	var price = (val * num).toFixed(2);
	$(obj).parent().parent().find(".pck_price").html("¥"+price);
	totalPrice();
}
function totalPrice(){
	var totalPrice = 0;
	var price = 0;
	$(".pck_price").each(function(){
		price += parseInt($(this).text().replace("¥","")) * 100;
	});
	totalPrice = (price/100).toFixed(2);
	$(".price").html(totalPrice);
}

function delTr(id,obg){
	$("#tr_"+id).remove();
}

//关闭生产年份显示排量信息
function closeCarPaiLiang(id,obj){
	$("#CarHistoryPaiLiang"+id).remove();
	$("#cx4").attr("class","head_div5");
	$("#cx4 span").attr("class","round2");
	$.ajax({
			url : httpUrl+"/biz/brand/getPailiang?pid="+id,
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html = "";
				
				for(var i=0;i<data.length;i++){
					html += "<li class=\"CarVecl2\" onClick=\"CarPaiLiangClick('"+i+"',this)\" data-id='"+data[i].pid+"' data-pailiang='"+data[i].pkey+"'>"+data[i].name+"</li>"
				}
				$("#carVecl").html(html);
			}
		});
}

//关闭排量显示车系及车名
function closeCarType(id,obj,pid){
	$("#"+id).remove();
	$("#cx3").attr("class","head_div5");
	$("#cx3 span").attr("class","round2");
	$.ajax({
			url : httpUrl+"/biz/brand/getModel?pid="+pid,
			dataType : "json",
			type : "POST",
			async:true,
			//jsonp:"jsonpCallback",
            //jsonpCallback:"success_jsonpCallback",
			success : function(data2){
				
				var html = "";
				//for(var i = 0;i<data.length;i++){
					//html += '<li class="CarVecl2" onClick="CarBrandClick('+i+',this)" data-id="'+data[i].pid+'" data-vehicle="'+data[i].brand+'">'+data[i].carname+'</li>'
				//}
				var arr = new Array();
				var arr2 = new Array();
				var arr3 = new Array();
				var arr4 = new Array();
				for(var i = 0;i<data.length;i++){
					arr.push(data[i].brandtype);
					if(data[i].vehicleseries != null && data[i].vehicleseries){
						arr3.push(data[i].vehicleseries);
					}
					
				}
				for(var j = 0;j<arr.length;j++){
					if(arr2.indexOf(arr[j])==-1){
						if(arr[j] != null){
							arr2.push(arr[j]);
						}
					}
				}
				for(var m = 0;m<arr3.length;m++){
					if(arr4.indexOf(arr3[m])==-1){
						arr4.push(arr3[m]);
					}
				}
				var arrCar = new Array();
				var arrCar2 = new Array();
				if(arr2.length != 0){
					for(var s = 0;s<arr2.length;s++){
						html += '<li class="CarBrandTitle" >'+arr2[s]+':</li>';
						if(arr4.length != 0){
							for(var r = 0;r<arr4.length;r++){
								for(var h = 0;h<data.length;h++){
									if(arr2[s] == data[h].brandtype && arr4[r] == data[h].vehicleseries){
										arrCar.push(data[h].vehicleseries);
										//html += '<li class="CarVecl2" onClick="CarBrandClick('+h+',this)" data-id="VE-FTNZY" //data-vehicle="'+data[h].vehicle+'">'+data[h].vehicleseries+'</li>'
									}
								}
							}
							for(var l = 0;l<arrCar.length;l++){
								if(arrCar2.indexOf(arrCar[l])==-1){
									arrCar2.push(arrCar[l]);
								}
							}
							for(var t = 0;t<arrCar2.length;t++){
								html += "<li class=\"CarVecl2\" onClick=\"showCarNameClick('"+arrCar2[t]+"','"+data[t].pid+"','"+arr2[s]+"')\" data-id=\""+data[t].id+"\" data-vehicle=\"\">"+arrCar2[t]+"</li>";
							}
						}else{
							for(var o =0;o<data.length;o++){
								if(arr2[s] == data[o].brandtype){
									html += "<li class=\"CarVecl2\" onClick=\"CarBrandClick('"+o+"',this,'"+data[o].brand+"','"+data[o].carname+"','"+data[o].pid+"')\" data-id=\""+data[o].id+"\" data-vehicle=\"\">"+data[o].carname+"</li>";
								}
							}
						}
					
					$("#carVecl").html(html);
					}
				}	
				
			}
		});
}

function closeDiv3(){
	$("#cx2").attr("class","head_div3");
	$("#cx2 span").attr("class","round2");
	$("#div2").show();
	$("#div3").hide();
	$("#carselSelect .CarHistoryTitlediv").remove();
}

function tabSelect(type,obj){
	$(".tab-nav li").removeClass("active");
	$(obj).addClass("active");
	if(type==0){
		$("#select-list").show();
		$("#search-list").hide();
		$(".line").css("left","0");
		$("#div2").show();
		$("#div3").hide();
		$(".CarHistoryTitlediv").remove();
		$(".carsel-progress li").removeClass("head_div2");
		$(".carsel-progress li:eq(0)").addClass("head_div2");
		$(".carsel-progress li span").removeClass("round");
		$(".carsel-progress li:eq(0) span").addClass("round2");
		$(".inventory").hide();
	}else{
		$("#select-list").hide();
		$("#search-list").show();
		$(".line").css("left","140px");
		$(".inventory").hide();
	}
}