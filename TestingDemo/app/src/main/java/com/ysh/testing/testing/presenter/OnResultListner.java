package com.ysh.testing.testing.presenter;

/**
 * 用于接受Model工作完后接收结果
 * Created by ysh on 2016/12/16.
 */

public interface OnResultListner {
    public void onBeatResult(String result);

    public void onBuyResult(String result);

    public void onZBResult(String result);

}
