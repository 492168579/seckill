//存放主要交互逻辑js代码
//javascript 模块化
var seckill ={
    //封装秒杀url
    URL:{
        now :function () {
            return '/seckill/time/now';
        },
        exposer : function (seckillId) {
            return '/seckill/'+seckillId+'/exposer';
        },
        execution : function(seckillId, md5) {
            return  '/seckill/' + seckillId + '/' + md5  + '/execution';
        }
    },
    handleSeckillkill:function (seckillId,node) {
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn" >开始秒杀 </button>');
        $.post(seckill.URL.exposer(seckillId),{} ,function (result) {
            console.log('result:'+result.toString())
            if(result && result['succcess']){
                var exposer = result['data'];
                if(exposer['exposed']){
                    // 开启秒杀
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    console.log('killUrl=' + killUrl);
                    $('#killBtn').one('click', function() {
                        // 执行秒杀请求
                        // 1.先禁用按钮
                        $(this).addClass('disabled');
                        // 2.发送秒杀请求
                         $.post(killUrl, {}, function(result) {
                            console.log("result:"+result)
                            if (result && result['succcess']) {
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                // 3.显示秒杀结果
                                node.html('<span class="label label-success">' + stateInfo + '</span>');
                            }
                        });
                    });
                    node.show();
                }else{
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end   = exposer['end'];
                    //重新计算计时逻辑
                    seckill.countDown(seckillId,now,start,end);
                }
            }else{
                console.log('result:'+result);
            }

        });

    },
    vaildaePhone:function (phone) {
        if(phone && phone.length ==11 && !isNaN(phone)){
            return true ;
        }else{
            return false ;
        }
        
    },
    countDown:function (seckillId,nowtIime,startTime,endTime) {
        //时间判断
        var seckillBox = $('#seckill-box');
        if(nowtIime>endTime){
            seckillBox.html('秒杀结束');
        }else if(nowtIime<startTime){
            //秒杀未开始计时
            var killTime = new Date(startTime+1000);
            seckillBox.html('秒杀未开始');
            seckillBox.countdown(startTime,function(event){
                //时间格式
                var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown',function () {
                //获取秒杀地址,执行秒杀
                seckill.handleSeckillkill(seckillId,seckillBox);
            });
        }else{
            //秒杀开始
            seckill.handleSeckillkill(seckillId,seckillBox);
        }

    },
    //详情页秒杀逻辑
    detail:{
        init:function(params){
            //手机校验和登录,及时交互
            //规划交互流程
            var killPhone = $.cookie('killPhone');
            console.log('killPhone:'+killPhone);
            //验证手机号
            if(!seckill.vaildaePhone(killPhone)){
                //绑定phone
                //控制输出
                var killPhoneModal = $ ('#killPhoneModal');
                killPhoneModal.modal({
                    show:true, //显示弹出层
                    backdrop:'static',//禁止位置关闭
                    keyboard:false //关闭键盘事件
                });
                $('#killPhoneBtn').click(function () {
                        var inputPhone = $('#killphoneKey').val();
                        if(seckill.vaildaePhone(inputPhone)){
                            //电话写入cookie
                            $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
                            //刷新页面
                            window.location.reload();
                        }else {
                            $('#killphoneMessage').hide().html('<label class="label label-danger">手机号错误! </label>').show(300);
                        }
                    }

                );
            }
            //已经登录
            //计时交互
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(seckill.URL.now(),{},function(result){
                   if(result && result['succcess']){
                        var nowTimes = result['data'];
                        //时间判断
                       // 时间判断，计时交互
                       console.log('seckillId:'+seckillId+'nowTimes:'+nowTimes+"startTime:"+startTime+"endTime:"+endTime);
                       seckill.countDown(seckillId, nowTimes, startTime, endTime);
                   }else{
                       console.log("result:"+result);
                   }
                }
            );

        }

    }
}