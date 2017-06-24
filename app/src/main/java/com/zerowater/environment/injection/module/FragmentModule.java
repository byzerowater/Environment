package com.zerowater.environment.injection.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.zerowater.environment.injection.ActivityContext;
import com.zerowater.environment.injection.PerFragment;
import com.zerowater.environment.ui.dialog.LoadingDialog;
import com.zerowater.environment.util.LoadingHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by YoungSoo Kim on 2016-09-02.
 * 4ground Ltd
 * byzerowater@gmail.com
 * FragmentModule
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mFragment.getActivity();
    }

    @Provides
    LoadingDialog provideLoadingDialog() {
        return new LoadingDialog(mFragment.getActivity());
    }

    @Provides
    LoadingHelper provideLoadingManager() {
        return new LoadingHelper();
    }
}
