package com.global.yap.environment.util;

import android.content.Context;
import android.widget.Toast;

import com.global.yap.environment.injection.ApplicationContext;

/**
 * Created by YoungSoo Kim on 2016-08-01.
 * company Ltd
 * youngsoo.kim@yap.net
 */
public class ToastManager {
    private Context mContext = null;

    public ToastManager(@ApplicationContext Context context) {
        mContext = context;
    }

    public void showToast(String toastText) {
        Toast.makeText(mContext, toastText, Toast.LENGTH_SHORT).show();
    }
}
