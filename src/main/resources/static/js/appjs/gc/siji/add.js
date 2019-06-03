$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/gc/siji/save",
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



    $("#pid").val(uuid());
    $("#bizdate").val(getNowFormatDate());
}


// 添加表格数据
function addeasypoi() {
    var url = "/gc/sijiItem/save";
    var pid = $("#pid").val();
    var data = {
        "pid": pid,
        "steelnum":$("#steelnum").val(),
        "specs":$("#specs").val(),
        "packnum":$("#packnum").val(),
        "tonnage":$("#tonnage").val(),
        "baseprice":$("#baseprice").val(),
        "coefficient":$("#coefficient").val()
    };
    if($("#steelnum").val().trim() == ""
		|| $("#specs").val().trim() == ""){
        alert("信息补充完整哟!");
    }else{

		$('#myModal').modal('hide');

        $.post(url,data,function(result){
            //alert("添加成功!!!");
            //初始化表格
            showTable();
        });


    }
}


function uuid() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    )
}



//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}




function deleteItem(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : "/gc/sijiItem/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    showTable();
                }else{
                    layer.msg(r.msg);
                }
            }
        });
    })
}