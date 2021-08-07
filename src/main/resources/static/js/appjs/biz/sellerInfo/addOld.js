$().ready(function() {
	$("#cardNo").focus();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});



function save() {

	var cardType = $('#cardType').val();
	var cardId = $('#cardId').val();
	var mobile = $('#mobile').val();

	if (cardType=='老年卡' && cardId==''){
		alert("老年卡身份证必填！");
		return ;
	}
	// if (mobile.length!=11){
	// 	alert("手机号必须是11位！");
	// 	return ;
	// }

	$.ajax({
		cache : true,
		type : "POST",
		url : "/biz/sellerInfo/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}