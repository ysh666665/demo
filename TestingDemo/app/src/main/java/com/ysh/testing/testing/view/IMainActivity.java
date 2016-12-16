package com.ysh.testing.testing.view;

/**
 * 这是Boss秘书的条件
 * 因为Boss需要一个接口来替他干活
 * 用于办完事儿后的显示
 * Created by ysh on 2016/12/16.
 */

public interface IMainActivity {
    public void showProgress();

    public void hideProgress();

    public void showBeatResult(String result);

    public void showBuyResult(String result);

    public void showZBResult(String result);
}
