
var prefix = "/gc/kehu"
$(function() {

    $("#startDate").val(getNowFirstDate());
    $("#endDate").val(getNowFormatDate());

    load();


});


//获取当前时间，格式YYYY-MM-DD
function getNowFirstDate() {
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
    var currentdate = year + seperator1 + month + seperator1 + '01';
    return currentdate;
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


function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 25, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"

                showFooter : true,

                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        startDate:$('#startDate').val(),
                        endDate:$('#endDate').val(),
                        tstartDate:$('#tstartDate').val(),
                        tendDate:$('#tendDate').val(),

                        station:$('#station').val(),
                        carnum:$('#carnum').val(),
                        carrier:$('#carrier').val(),
                        receipt:$('#receipt').val(),
                        deptId:$('#deptId').val()
                        // username:$('#searchName').val()
                    };
                },onLoadSuccess:function () {
                   // var rows =  document.getElementById("exampleTable").rows;
                   //  for (var i = 2; i <rows.length ; i++) {
                   //      if (parseFloat(rows[i].cells[17].innerHTML)<0){
                   //          rows[i].setAttribute("style","background: red;")
                   //      }
                   //
                   //  }
                    
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns : [
                    [{
                        checkbox : true,
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'id',
                        title : 'id',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'orderNo',
                        title : '订单号',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'bizdate',
                        title : '业务发生日期',
                        align: 'center',
                        colspan:1,
                        rowspan:2,
                        footerFormatter: function (value) {

                            return '合计';
                        }
                    },
                    {
                        field : 'carnum',
                        title : '车牌号码',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'station',
                        title : '&nbsp;&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;站&nbsp;&nbsp;&nbsp;&nbsp;',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'tonnage',
                        title : '&nbsp;&nbsp;&nbsp;&nbsp;吨&nbsp;&nbsp;位&nbsp;&nbsp;&nbsp;&nbsp;',
                        align: 'center',
                        colspan:1,
                        rowspan:2,
                        footerFormatter: function (value) {
                            var amount = 0;
                            for (var i in value) {
                                if (value[i].tonnage!='' && value[i].tonnage!=null){
                                    amount += parseFloat(value[i].tonnage);
                                }
                            }
                            return amount.toFixed(3);
                        }
                    },
                    {
                        field : 'adjusttonnage',
                        title : '调吨',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'settletonnage',
                        title : '结算吨位',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'transcost',
                        title : '运价',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'inforfee',
                        title : '信息费',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'colmethod',
                        title : '&nbsp;&nbsp;收取方式&nbsp;&nbsp;',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'transfee',
                        title : '&nbsp;&nbsp;&nbsp;&nbsp;运&nbsp;&nbsp;费&nbsp;&nbsp;&nbsp;&nbsp;',
                        align: 'center',
                        colspan:1,
                        rowspan:2,
                        footerFormatter: function (value) {
                            var amount = 0;
                            for (var i in value) {
                                if (value[i].transfee!='' && value[i].transfee!=null){
                                    amount += parseFloat(value[i].transfee);
                                }
                            }
                            return amount.toFixed(3);
                        }
                    },

                    {
                        field : 'bankpaytwodate',
                        title : '付款<br>约定',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },

                    {
                        //field : 'payType',
                        title : '第一次付款',
                        align: 'center',
                        colspan:3,
                        rowspan:1
                    },
                    {
                        //field : 'forwunit',
                        title : '第二次付款',
                        align: 'center',
                        colspan:3,
                        rowspan:1
                    },
                    {
                        field : 'shoushufei',
                        title : '&nbsp;&nbsp;手续费&nbsp;&nbsp;',
                        align: 'center',
                        colspan:1,
                        rowspan:2,
                        footerFormatter: function (value) {
                            var amount = 0;
                            for (var i in value) {
                                if (value[i].shoushufei!='' && value[i].shoushufei!=null){
                                    amount += parseFloat(value[i].shoushufei);
                                }
                            }
                            return amount.toFixed(3);
                        }
                    },
                    {
                        field : 'acbalance',
                        title : '&nbsp;&nbsp;余&nbsp;&nbsp;额&nbsp;&nbsp;',
                        align: 'center',
                        colspan:1,
                        rowspan:2,
                        footerFormatter: function (value) {
                            var amount = 0;
                            for (var i in value) {
                                if (value[i].acbalance!='' && value[i].acbalance!=null){
                                    amount += parseFloat(value[i].acbalance);
                                }
                            }
                            return amount.toFixed(3);
                        }
                    },
                    {
                        field : 'receipt',
                        title : '回单',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'receiptdate',
                        title : '回单日期',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'carrier',
                        title : '承运人',
                        align: 'center',
                        colspan:1,
                        rowspan:2
                    },
                    {
                        field : 'remark',
                        title : '备注' ,
                        align: 'center',
                        colspan:1,
                        rowspan:2,
                        width: "10%"
                    },
                    {
                        title : '系统操作按钮',
                        field : 'id',
                        align : 'center',
                        colspan:1,
                        rowspan:2,
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '+s_edit_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';

                            return e + d ;
                        }
                    } ],[{
                            field : 'payType',
                            title : '&nbsp;&nbsp;付款方式&nbsp;&nbsp;',
                            align: 'center'
                        },
                        {
                            field : 'fulltrans',
                            title : '&nbsp;&nbsp;金&nbsp;&nbsp;额&nbsp;&nbsp;',
                            align: 'center',
                            footerFormatter: function (value) {
                                var amount = 0;
                                for (var i in value) {
                                    if (value[i].fulltrans!='' && value[i].fulltrans!=null){
                                        amount += parseFloat(value[i].fulltrans);
                                    }
                                }
                                return amount.toFixed(3);
                            }
                        },
                        {
                            field : 'fulpaydate',
                            title : '付款日期',
                            align: 'center'
                        },
                        {
                            field : 'forwunit',
                            title : '&nbsp;&nbsp;付款方式&nbsp;&nbsp;',
                            align: 'center'
                        },
                        {
                            field : 'bankcard',
                            title : '&nbsp;&nbsp;金&nbsp;&nbsp;额&nbsp;&nbsp;',
                            align: 'center',
                            footerFormatter: function (value) {
                                var amount = 0;
                                for (var i in value) {
                                    if (value[i].bankcard!='' && value[i].bankcard!=null){
                                        amount += parseFloat(value[i].bankcard);
                                    }
                                }
                                return amount.toFixed(3);
                            }
                        },
                        {
                            field : 'bankpaydate',
                            title : '付款日期',
                            align: 'center'
                        }]

                ]
            });
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function add() {
    var perContent = layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add' // iframe的url
    });


    layer.full(perContent);

}
function edit(id) {
    var perContent = layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });

    layer.full(perContent);
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    reLoad();
                }else{
                    layer.msg(r.msg);
                }
            }
        });
    })
}


function excel() {

    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    var carnum = $('#carnum').val();
    var carrier = $('#carrier').val();
    var receipt = $('#receipt').val();
    var deptId = $('#deptId').val();
    var station = $('#station').val();
    window.open(prefix+"/export?startDate="+startDate+"&endDate="+endDate
        +"&carnum="+carnum+"&carrier="+carrier+"&receipt="+receipt+"&deptId="+deptId+"&station="+station);

}

function resetPwd(id) {
}
function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {

    });
}