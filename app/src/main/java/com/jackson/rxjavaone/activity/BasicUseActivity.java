package com.jackson.rxjavaone.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jackson.rxjavaone.R;
import com.jackson.rxjavaone.util.CommonMethod;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;

public class BasicUseActivity extends AppCompatActivity {

    @BindView(R.id.et_send)
    EditText mEtSend;
    @BindView(R.id.btn_send)
    Button mBtnSend;
    @BindView(R.id.tv_receive)
    TextView mTvReceive;

    private String mess = "";

    @OnClick(R.id.btn_send)
    //-----------------------------------------第一种方法------------------------------------------------------
    /*public void send() {
        mess="";
        //创建 Observable
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("start");
                subscriber.onNext(mEtSend.getText().toString().trim());
                subscriber.onNext("complete");
                subscriber.onCompleted();
            }
        });

        //创建 Observer
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                CommonMethod.showToast(BasicUseActivity.this, "Completed");
            }

            @Override
            public void onError(Throwable e) {
                CommonMethod.showToast(BasicUseActivity.this, "Error");
            }

            @Override
            public void onNext(String s) {
                // LogUtil.d(s);
                mess += s+"\n";
                mTvReceive.setText(mess);
            }
        };
        //Subscribe (订阅)
        observable.subscribe(observer);
    }*/

    //-----------------------------------------第二种方法----  just  from--------------------------
   /* public void send() {
        mess = "";
        //just方法
      // Observable observable = Observable.just("start", mEtSend.getText().toString().trim(), "complete");
        //from方法
      *//*  String[] words={"start", mEtSend.getText().toString().trim(), "complete"};
        Observable observable=Observable.from(words);*//*
        List<String> list=new ArrayList<>();
        list.add("start");
        list.add(mEtSend.getText().toString().trim());
        list.add("complete");
        Observable observable=Observable.from(list);
        //创建 Observer
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                CommonMethod.showToast(BasicUseActivity.this, "Completed");
            }

            @Override
            public void onError(Throwable e) {
                CommonMethod.showToast(BasicUseActivity.this, "Error");
            }

            @Override
            public void onNext(String s) {
                // LogUtil.d(s);
                mess += s + "\n";
                mTvReceive.setText(mess);
            }
        };
        //Subscribe (订阅)
        observable.subscribe(observer);
    }*/
    //-----------------------------------------第三种方法---- 不完整定义的回调-------------------------
    public void send() {
        mess = "";

        //创建Observable，just方法
        Observable observable = Observable.just("start", mEtSend.getText().toString().trim(), "complete");

        //创建 Observer，不完整定义回调
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                mess += s + "\n";
                mTvReceive.setText(mess);
            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                CommonMethod.showToast(BasicUseActivity.this, "Error");
            }
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_use);
        ButterKnife.bind(this);

    }
}
