package com.safframework.study.cv4j.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.safframework.injectview.annotations.InjectView;
import com.safframework.study.cv4j.R;
import com.safframework.study.cv4j.app.BaseActivity;
import com.safframework.study.cv4j.utils.RxUtils;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.text1)
    TextView text1;

    @InjectView(R.id.text2)
    TextView text2;

    @InjectView(R.id.text3)
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        RxView.clicks(text1)
                .compose(RxUtils.useRxViewTransformer(MainActivity.this))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {

                        Intent i = new Intent(MainActivity.this,FilterActivity.class);
                        startActivity(i);
                    }
                });

        RxView.clicks(text2)
                .compose(RxUtils.useRxViewTransformer(MainActivity.this))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {

                        Intent i = new Intent(MainActivity.this,GridViewFilterActivity.class);
                        startActivity(i);
                    }
                });

        RxView.clicks(text3)
                .compose(RxUtils.useRxViewTransformer(MainActivity.this))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {

                        Intent i = new Intent(MainActivity.this,DslActivity.class);
                        startActivity(i);
                    }
                });
    }
}
