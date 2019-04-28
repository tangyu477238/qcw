var ww=$(window).width();
if(ww>768){
$('.menu-item-has-children').mouseenter(function(){
	$(this).find('.sub-menu').slideDown();
});
$('.menu-item-has-children').mouseleave(function(){
	$(this).find('.sub-menu').slideUp();
});
$('.plan').mouseenter(function(){
	$(this).find('.img2').show();
	$(this).find('.img1').hide();
	$(this).find('.desc').hide();
});

$('.plan').mouseleave(function(){
	$(this).find('.img1').show();
	$(this).find('.img2').hide();
	$(this).find('.desc').show();
});

$('.holder').mouseenter(function(){
	$(this).find('.cover').show();
});

$('.holder').mouseleave(function(){
	$(this).find('.cover').hide();
});

$('#plan1').click(function(){
	$('html,body').animate({scrollTop:$('#product').offset().top},500);
});

$('#plan2').click(function(){
	$('html,body').animate({scrollTop:$('#technology').offset().top},1000);
});

$('#plan3').click(function(){
	$('html,body').animate({scrollTop:$('#ome').offset().top},1500);
});

$('#plan4').click(function(){
	$('html,body').animate({scrollTop:$('#car').offset().top},2000);
});
}
var aList=$('.products .cate li a');
for(var i=0;i<aList.length;i++){
	var href=aList[i].href;
	href=href.replace('category/pro1/pro1','products');
	href=href.replace('category/pro2/pro2','products');
	aList[i].href=href;
}

$('.products .product li').mouseenter(function(){
		$(this).find('#cover img').animate({top:'200px'});
	});
	$('.products .product li').mouseleave(function(){
		$(this).find('#cover img').animate({top:'-20px'});
	});

// var proList=$('.products .product li #com');
// $('.products .product li #com table').hide();
// for(var i=0;i<proList.length;i++){
// 	var pList=[];
// 	var cover=[];
// 	pList=proList[i].getElementsByTagName('p');		
// 	for(var j=0;j<pList.length;j++){
// 		var imgList=pList[j].getElementsByTagName('img');
// 		if(imgList.length==0){
// 		  cover.push(pList[j]);
// 		}
// 		// console.log(cover);
// 		for(var x=0;x<cover.length;x++){
// 			if(x>2){
// 				cover[x].style.display="none";
// 			}
// 		}
		
// 	}
	
// }

	// var newList=$('.wiki ul li ');
	// for(var i=0;i<newList.length;i++){
	// 	var pList=[];
	// 	var cover=[];
	// 	pList=newList[i].getElementsByTagName('p');
	// 	for(var j=0;j<pList.length;j++){
	// 		var imgList=pList[j].getElementsByTagName('img');
	// 		if(imgList.length==0){
	// 		  cover.push(pList[j]);
	// 		}
	// 		console.log(cover);
	// 		for(var x=0;x<cover.length;x++){
	// 			if(x!=0){
	// 				cover[x].style.display="none";
	// 			}
	// 		}
			
	// 	}
		
	// }
	// var newList1=$('.cases ul li ');
	// for(var i=0;i<newList1.length;i++){
	// 	var pList=[];
	// 	var cover=[];
	// 	pList=newList1[i].getElementsByTagName('div');
	// 	for(var j=0;j<pList.length;j++){
	// 		var imgList=pList[j].getElementsByTagName('img');
	// 		if(imgList.length==0){
	// 		  cover.push(pList[j]);
	// 		}
	// 		console.log(cover);
	// 		for(var x=0;x<cover.length;x++){
	// 			if(x!=0){
	// 				cover[x].style.display="none";
	// 			}
	// 		}
			
	// 	}
		
	// }


$(".maonimen p").each(
function(){
	var a = $(this).index() % 4 * 50;
	var b = parseInt($(this).index() / 4) * 100;
	$(this).css(
		{
			"left":a,
			"top": b,
			"background-position":(-a) + "px " + (-b) + "px"
		}
	);
}
);

// $(".products .product li").click(
// 	function(){
// 		// alert(1);
// 		var maonimen =$(this).find('#comm .maonimen ');
// 		var href=$(this).find('a').attr('href');
// 		var src=$(this).find('#comm p img').attr('src');
// 		var wwidth=$(window).width();
// 		if(wwidth>=980){
// 		$(this).parent().parent().find('#comm .maonimen p').css("background-image",'url('+src+')');		
// 		}
// 		dong(maonimen,href);
// 	}
// );

// function dong(maonimen,href){
// 		//加过渡：
// 		var wwidth=$(window).width();
// 		if(wwidth>=980){
// 			maonimen.find('p').css("transition","all 1s ease 0s");
// 			maonimen.addClass("fei");
// 		}
		
// 		// $(".zhentu img").attr("src","images/" + nowimg + ".jpg");
// 		setTimeout(function(){
// 			//去掉过渡
// 			window.location.href=href;
// 		},500);
// 		setTimeout(function(){
// 			//去掉过渡
// 			window.location.href=href;
// 			parent.find(".maonimen p").css("transition","none");
// 			console.log(src);
			
// 			// //我们准备下一张图
			
// 				parent.find(".maonimen").removeClass("fei");

			
// 		},1000);
// }




function fenye(currentPage,pageSize){
	var products=$('.products .product li');
	var num=products.length;
	console.log(num);
	var totalPage=0;//总页数
	if(num/pageSize > parseInt(num/pageSize)){   
            totalPage=parseInt(num/pageSize)+1;   
       }else{   
           totalPage=parseInt(num/pageSize);   
       } 
    var startRow=(currentPage-1)*pageSize+1;  
	console.log(startRow);
	var endRow = currentPage * pageSize;
	endRow =(endRow>num)?num:endRow;
	console.log(endRow);
	for(var i=1;i<(num+1);i++){
		var irow=products[i-1];
		if(i>=startRow&&i<=endRow){
			irow.style.display="inline-block";
		}else{
			irow.style.display="none";
		}
	}
	$('#paging .paging').text('共'+num+'条记录,共'+totalPage+'页,当前为'+currentPage+'页');
	if(endRow==num){
		$('#paging .next').hide();
	}
	else{
		$('#paging .next').show();
	}
	if(currentPage==1){
		$('#paging .last').hide();

	}
	else{
		$('#paging .last').show();
	}
}

var currentPage =1;
var pageSize=9;
fenye(currentPage,pageSize);


$('#paging .next').click(function(){
	currentPage+=1;
	fenye(currentPage,pageSize)
	$('html,body').animate({scrollTop:$('.products').offset().top},500);
});
$('#paging .last').click(function(){
	currentPage-=1;
	fenye(currentPage,pageSize)
	$('html,body').animate({scrollTop:$('.products').offset().top},500);

});



stp=$(window).scrollTop();
console.log(stp);
var whe=200;
    if(stp<=whe)
     {
  	    $('#goTop').hide();
  	  }
    $(window).scroll(function () {
    	if($(window).scrollTop()>=whe){
    		$('#goTop').show();
    	}
    	else{
    		$('#goTop').hide();
    	}
});
 	
var wheight=$(window).height()-100;
$('#goTop').click(function(){
	
	$('html,body').animate({scrollTop:$('body').offset().top},1000);
	$('#goTop').animate({bottom:wheight},500);

	setTimeout(function(){
			$('#goTop').animate({bottom:150+'px'},1);
		},700);
});

