package com.zerowater.environment.ui.base;

import android.support.v4.app.Fragment;

import com.zerowater.environment.EnvironmentApplication;
import com.zerowater.environment.injection.component.DaggerFragmentComponent;
import com.zerowater.environment.injection.component.FragmentComponent;
import com.zerowater.environment.injection.module.FragmentModule;

/**
 * Created by YoungSoo Kim on 2016-08-17.
 * 4ground Ltd
 * byzerowater@gmail.com
 * BaseFragment
 */
public abstract class BaseFragment extends Fragment {

    /**
     * FragmentComponent
     */
    private FragmentComponent mFragmentComponent;

    /**
     * FragmentComponent 생성
     *
     * @return FragmentComponent
     */
    protected FragmentComponent fragmentComponent() {
        if (mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .applicationComponent(EnvironmentApplication.get(getActivity()).getComponent())
                    .fragmentModule(new FragmentModule(this))
                    .build();
        }

        return mFragmentComponent;
    }

}
