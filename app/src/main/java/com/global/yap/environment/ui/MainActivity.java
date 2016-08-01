package com.global.yap.environment.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.global.yap.environment.R;
import com.global.yap.environment.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
