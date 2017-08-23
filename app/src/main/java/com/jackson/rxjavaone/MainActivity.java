package com.jackson.rxjavaone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jackson.rxjavaone.activity.BasicUseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.basic_use)
    TextView mBasicUse;

    @OnClick(R.id.basic_use)
    public void jumpToBasic(){
        startActivity(new Intent(MainActivity.this, BasicUseActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
