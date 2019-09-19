package com.example.lishengbo.model;

import com.example.lishengbo.User;
import com.example.lishengbo.callback.RegisCallback;
import com.example.lishengbo.utils.DbUtil;

public class RegisModel {


    public void getData(final User user, final RegisCallback callback){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //插入数据库
                long insert = DbUtil.getDbUtil().insert(user);
                if (insert>=0){
                    //返回结果
                    callback.ok("注册成功");
                }else {
                    //返回结果
                    callback.no("注册失败");
                }
            }
        }).start();

    }
}
