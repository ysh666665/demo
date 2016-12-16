package com.ysh.testing.testing.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ysh.testing.testing.R;
import com.ysh.testing.testing.presenter.PresenterMain;
/*
* 这里只有UI操作的方法
* */
public class MainActivity extends AppCompatActivity implements IMainActivity{

    private PresenterMain mPresenter;
    private ProgressBar progressBar;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //作为Boss，想要一个管事的，还不是new一个就行了
        //然后将Boss自己实现的接口传给Presenter，Presenter对结果的处理直接通过这个接口来实现
        mPresenter = new PresenterMain(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
    }
    /*
    * Boss的日常
    * */
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_beat:
                mPresenter.beatSomeBody("牧狗");
                break;
            case R.id.btn_buy_golden_chain:
                mPresenter.buyGoldenChain();
                break;
            case R.id.btn_zhuang_bi:
                mPresenter.zhuangBi();
                break;
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showBeatResult(String result) {
        textView.setText(result);
        imageView.setImageResource(R.mipmap.beat_somebody);
    }

    @Override
    public void showBuyResult(String result) {
        textView.setText(result);
        imageView.setImageResource(R.mipmap.golden_chain);
    }

    @Override
    public void showZBResult(String result) {
        textView.setText(result);
        imageView.setImageResource(R.mipmap.u_can_u_up);
    }
}
