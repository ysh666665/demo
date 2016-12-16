package com.ysh.testing.testing.model;

import android.os.Handler;

import com.ysh.testing.testing.presenter.OnResultListner;

/**
 * 小弟的实现类
 * 比如网络或数据库请求数据
 * 数据处理转化过程
 * Created by ysh on 2016/12/16.
 */

public class Model implements IModelMain{
    private OnResultListner onResultListner;
    private static Handler mHandler = new Handler();

    public Model(OnResultListner onResultListner) {
        this.onResultListner = onResultListner;
    }

    @Override
    public void beatSombody(final String name) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onResultListner.onBeatResult(
                       name + "已经被教训了一顿"
                );
            }
        },2000);
    }

    @Override
    public void zhuangbi() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onResultListner.onZBResult(
                         "装逼成功"
                );
            }
        },2000);
    }

    @Override
    public void buyGoldenChain() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onResultListner.onBuyResult(
                        "老大，您的金链子"
                );
            }
        },2000);
    }

}
