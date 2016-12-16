package com.ysh.testing.testing.presenter;

import com.ysh.testing.testing.model.Model;
import com.ysh.testing.testing.view.IMainActivity;

/**
 * Presenter的实现类
 * 能力是通知View和指挥Model搞大新闻
 * Created by ysh on 2016/12/16.
 */

public class PresenterMain implements IPresenter, OnResultListner {

    private IMainActivity iMainActivity;
    private Model mModel;


    public PresenterMain(IMainActivity iMainActivity) {
        //Boss当然只能有一个
        this.iMainActivity = iMainActivity;

        //小弟想要几个就new几个
        mModel = new Model(this);
    }

    /*
    * Boss要打人啦
    * */
    @Override
    public void beatSomeBody(String name) {
        //正派小弟去打人，请boss耐心等待
        if (null != iMainActivity) {
            iMainActivity.showProgress();
            mModel.beatSombody(name);
        }
    }

    /*
    * Boss要买金链子
    * */
    @Override
    public void buyGoldenChain() {
        //正派小弟去买金链子
        if (null != iMainActivity) {
            iMainActivity.showProgress();
            mModel.buyGoldenChain();
        }
    }

    /*
    * Boss要装逼
    * */
    @Override
    public void zhuangBi() {
        //这个逼由小弟代您装了
        if (null != iMainActivity) {
            iMainActivity.showProgress();
            mModel.zhuangbi();
        }

    }

    @Override
    public void onBeatResult(String result) {
        iMainActivity.hideProgress();
        iMainActivity.showBeatResult(result);
    }

    @Override
    public void onBuyResult(String result) {
        iMainActivity.hideProgress();
        iMainActivity.showBuyResult(result);
    }

    @Override
    public void onZBResult(String result) {
        iMainActivity.hideProgress();
        iMainActivity.showZBResult(result);
    }

    /*
    * 当View挂了
    * presenter绝不独活
    * 解除与View的持有关系，然后坐等被GC回收
    * */
    @Override
    public void onDestroy() {
        iMainActivity = null;
    }
}
