package com.zerowater.environment.util;

import android.text.TextUtils;

/**
 * Created by YoungSoo Kim on 2016-06-17.
 * company Ltd
 * youngsoo.kim@yap.net
 * 문자열 유틸
 */
public class StringUtil {

    /**
     * 문자열 빈값 확인
     * @param s 확인할 문자
     * @return 빈값 확인 결과
     */
    public static boolean isEmpty(String s) {
        boolean isEmpty = false;

        if (TextUtils.isEmpty(s) || s.trim().length() == 0) {
            isEmpty = true;
        }

        return isEmpty;
    }
}
