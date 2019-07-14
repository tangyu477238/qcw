var httpUrl = "http://huocheyun.xicp.net:13317";
$(function() {
	$(".th_inputBox-input").focus(function() {
		$(".th_searchBar-cancel").css("margin-right", "0px");
	});
	$(".th_inputBox-input").blur(function() {
		$(".th_searchBar-cancel").css("margin-right", "-45px");
	})

	var win = $(window); //得到窗口对象
	var sc = $(document); //得到document文档对象。
	win.scroll(function() {
		var top = $(document).scrollTop();
		var menu = $("#entranceNav");
		var items = $(".th_brandList-box");
		var curId = "";
		items.each(function() {
			var m = $(this);
			var itemsTop = m.offset().top;
			if (top > itemsTop - 10) {
				curId = "#" + m.attr("id");
				console.log(curId)
			} else {
				return false;
			}
		});

		var curLink = menu.find(".on");

		if (curId && curLink.attr("href") != curId) {
			curLink.removeClass("on");
			menu.find("[href=" + curId + "]").addClass("on");
		}

	});
	


	//热门品牌
	$.ajax({
			url :httpUrl+"/biz/brand/list",
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
           // jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html=""
				var html2=""
				for(var i = 0;i<data.length;i++){
					//var carName = data[i].brand.split("-");
					if(data[i].id=="1685"){
						html+="<div class=\"th_brand-item\">";
						html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html+="</div>";
					}else if(data[i].id=="1677"){
						html+="<div class=\"th_brand-item\">";
						html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html+="</div>";
					}else if(data[i].id=="1662"){
						html+="<div class=\"th_brand-item\">";
						html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html+="</div>";
					}else if(data[i].id=="1708"){
						html+="<div class=\"th_brand-item\">";
						html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html+="</div>";
					}else if(data[i].id=="1774"){
						html+="<div class=\"th_brand-item\">";
						html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html+="</div>";
					}else if(data[i].id=="1777"){
						html2+="<div class=\"th_brand-item\">";
						html2+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html2+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html2+="</div>";
					}else if(data[i].id=="1661"){
						html2+="<div class=\"th_brand-item\">";
						html2+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html2+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html2+="</div>";
					}else if(data[i].id=="1779"){
						html2+="<div class=\"th_brand-item\">";
						html2+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html2+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html2+="</div>";
					}else if(data[i].id=="1667"){
						html2+="<div class=\"th_brand-item\">";
						html2+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html2+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html2+="</div>";
					}else if(data[i].id=="1703"){
						html2+="<div class=\"th_brand-item\">";
						html2+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+data[i].url+"\"></a></div>"
						html2+="	<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+data[i].id+"','"+data[i].url+"')\">"+data[i].brand+"</a></div>";
						html2+="</div>";
					}
				}
				$(".ths_hotBrandItem").html(html);
				$(".ths_hotBrandItem2").html(html2);
			}
		})
	
	
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
	//初始化汽车品牌列表
	$.ajax({
			url :httpUrl+"/biz/brand/list",
			dataType : "json",
			type : "GET",
			async:true,
			//jsonp:"jsonpCallback",
           // jsonpCallback:"success_jsonpCallback",
			success : function(data){
				var html = "";
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
			
				html+='<div class="ths_cardBox th_brandList-box" id="itemA">';
				html+='<div class="th_cardBox-title" >'+arrA[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var a = 0;a<arrA.length;a++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrA[a].id+"','"+arrA[a].url+"')\"><img alt=\"\" class=\"th_icon\" src=\""+arrA[a].url+"\"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrA[a].id+"','"+arrA[a].url+"')\">"+arrA[a].brand+"</a></div>";
					html+="</div>";
				}
				
				html+='</div>';
				html+='</div>';	
				html+='<div class="ths_cardBox th_brandList-box" id="itemB">';
				html+='<div class="th_cardBox-title" >'+arrB[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var b = 0;b<arrB.length;b++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrB[b].id+"','"+arrB[b].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrB[b].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrB[b].id+"','"+arrB[b].url+"')\">"+arrB[b].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemC">';
				html+='<div class="th_cardBox-title" >'+arrC[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var c = 0;c<arrC.length;c++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrC[c].id+"','"+arrC[c].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrC[c].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrC[c].id+"','"+arrC[c].url+"')\">"+arrC[c].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemD">';
				html+='<div class="th_cardBox-title" >'+arrD[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var d = 0;d<arrD.length;d++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrD[d].id+"','"+arrD[d].url+"')\"><img alt=\"\"  class=\"th_icon\" src="+arrD[d].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrD[d].id+"','"+arrD[d].url+"')\">"+arrD[d].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemF">';
				html+='<div class="th_cardBox-title" >'+arrF[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var f = 0;f<arrF.length;f++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrF[f].id+"','"+arrF[f].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrF[f].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrF[f].id+"','"+arrF[f].url+"')\">"+arrF[f].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemG">';
				html+='<div class="th_cardBox-title" >'+arrG[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var g = 0;g<arrG.length;g++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrG[g].id+"','"+arrG[g].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrG[g].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrG[g].id+"','"+arrG[g].url+"')\">"+arrG[g].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemH">';
				html+='<div class="th_cardBox-title" >'+arrH[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var h = 0;h<arrH.length;h++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('+arrH[h].id+','"+arrH[h].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrH[h].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrH[h].id+"','"+arrH[h].url+"')\">"+arrH[h].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemJ">';
				html+='<div class="th_cardBox-title" >'+arrJ[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var  j= 0;j<arrJ.length;j++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrJ[j].id+"','"+arrJ[j].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrJ[j].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrJ[j].id+"','"+arrJ[j].url+"')\">"+arrJ[j].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		

				html+='<div class="ths_cardBox th_brandList-box" id="itemK">';
				html+='<div class="th_cardBox-title" >'+arrK[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var k = 0;k<arrK.length;k++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrK[k].id+"','"+arrK[k].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrK[k].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrK[k].id+"','"+arrK[k].url+"')\">"+arrK[k].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemL">';
				html+='<div class="th_cardBox-title" >'+arrL[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var l = 0;l<arrL.length;l++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrL[l].id+"','"+arrL[l].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrL[l].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrL[l].id+"','"+arrL[l].url+"')\">"+arrL[l].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemM">';
				html+='<div class="th_cardBox-title" >'+arrM[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var m = 0;m<arrM.length;m++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrM[m].id+"','"+arrM[m].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrM[m].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrM[m].id+"','"+arrM[m].url+"')\">"+arrM[m].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemN">';
				html+='<div class="th_cardBox-title" >'+arrN[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var n = 0;n<arrN.length;n++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('+arrN[n].id+','"+arrN[n].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrN[n].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrN[n].id+"')\">"+arrN[n].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemO">';
				html+='<div class="th_cardBox-title" >'+arrO[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var o = 0;o<arrO.length;o++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrO[o].id+"','"+arrO[o].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrO[o].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrO[o].id+"','"+arrO[o].url+"')\">"+arrO[o].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemP">';
				html+='<div class="th_cardBox-title" >'+arrP[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var p = 0;p<arrP.length;p++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrP[p].id+"','"+arrP[p].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrP[p].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrP[p].id+"','"+arrP[p].url+"')\">"+arrP[p].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemQ">';
				html+='<div class="th_cardBox-title" >'+arrQ[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var q = 0;q<arrQ.length;q++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrQ[q].id+"','"+arrQ[q].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrQ[q].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrQ[q].id+"','"+arrQ[q].url+"')\">"+arrQ[q].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemR">';
				html+='<div class="th_cardBox-title" >'+arrR[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var r = 0;r<arrR.length;r++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrR[r].id+"','"+arrR[r].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrR[r].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrR[r].id+"','"+arrR[r].url+"')\">"+arrR[r].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemS">';
				html+='<div class="th_cardBox-title" >'+arrS[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var s = 0;s<arrS.length;s++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrS[s].id+"','"+arrS[s].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrS[s].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrS[s].id+"','"+arrS[s].url+"')\">"+arrS[s].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemT">';
				html+='<div class="th_cardBox-title" >'+arrT[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var t = 0;t<arrT.length;t++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrT[t].id+"','"+arrT[t].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrT[t].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrT[t].id+"','"+arrT[t].url+"')\">"+arrT[t].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemW">';
				html+='<div class="th_cardBox-title" >'+arrW[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var w = 0;w<arrW.length;w++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrW[w].id+"','"+arrW[w].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrW[w].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrW[w].id+"','"+arrW[w].url+"')\">"+arrW[w].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';	
				html+='<div class="ths_cardBox th_brandList-box" id="itemX">';
				html+='<div class="th_cardBox-title" >'+arrX[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var x = 0;x<arrX.length;x++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrX[x].id+"','"+arrX[x].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrX[x].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrX[x].id+"','"+arrX[x].url+"')\">"+arrX[x].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';	
				html+='<div class="ths_cardBox th_brandList-box" id="itemY">';
				html+='<div class="th_cardBox-title" >'+arrY[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var y = 0;y<arrY.length;y++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrY[y].id+"','"+arrY[y].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrY[y].url+"></a></div>";
					html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrY[y].id+"','"+arrY[y].url+"')\">"+arrY[y].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';		
				html+='<div class="ths_cardBox th_brandList-box" id="itemZ">';
				html+='<div class="th_cardBox-title" >'+arrZ[0].pid+'</div>';
				html+='<div class="th_cardBox-cont">';
				for(var z = 0;z<arrZ.length;z++){
					html+='<div class="ths_brandItem th_cardBox-list-item">';
					html+="<div class=\"th_item-icon\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrZ[z].id+"','"+arrZ[z].url+"')\"><img alt=\"\" class=\"th_icon\" src="+arrZ[z].url+"></a></div>";
				html+="<div class=\"th_item-name\"><a href=\"javascript:;\" onclick=\"showCarInfo('"+arrZ[z].id+"','"+arrZ[z].url+"')\">"+arrZ[z].brand+"</a></div>";
					html+='</div>';
				}
				
				html+='</div>';
				html+='</div>';	
				$(".ths_brandList").html(html);
	
				//$(".th_slider-right-content").html(html);
			}
		});
	
	/*var html = "";
	
	html = '<div class="acs_secHeader"><div class="ac_secHeader-logo"><img alt="" class="ac_logo-img" src="https://img1.tuhu.org/Images/Logo/arcfox.png@NaNw_99q.jpg"></div> <div class="ac_secHeader-name">ARCFOX</div></div>';
	for (var z = 0; z < 3; z++) {
		html += '<div class="th_secBody-sortBox"><div class="acs_titleFixed2">北汽新能源' + z + '</div>';
		for (var i = 0; i < 10; i++) {
			html +=
				'<div class="th_cardBox-cont"><div class="ths_carContList ths_contBox"><div class="th_carContList-item th_carItem"><a href="detail.html">LITE</a></div></div></div>'
		}
		html += '</div>';
	}
	
	$(".th_slider-right-content").html(html);*/
	
	
	/*$("body").on("touchstart", function(e) {

		e.preventDefault();

		startX = e.originalEvent.changedTouches[0].pageX,

			startY = e.originalEvent.changedTouches[0].pageY;

	});*/

	/*$("body").on("touchmove", function(e) {

		e.preventDefault();

		moveEndX = e.originalEvent.changedTouches[0].pageX,

			moveEndY = e.originalEvent.changedTouches[0].pageY,

			X = moveEndX - startX,

			Y = moveEndY - startY;

		if (X > 0) {

			//alert("left 2 right");
			$(".th_slider-right-content").css({
				"width": "0px",
				"transition": "width 0.5s ease 0s"
			});
		} else
		if (X < 0) {

			//alert("right 2 left");

		} else
		if (Y > 0) {

			//alert("top 2 bottom");

		} else
		if (Y < 0) {

			//alert("bottom 2 top");

		} else {

			//alert("just touch");

		}

	});*/
})
function showCarInfo(id,imgUrl){
		console.info(id);
		
		localStorage.setItem("pid",id);
		localStorage.setItem("imgUrl",imgUrl);
		window.location.href= httpUrl+"/biz/brand/getright"
		
	}