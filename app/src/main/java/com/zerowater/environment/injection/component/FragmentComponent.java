package com.zerowater.environment.injection.component;


import com.zerowater.environment.injection.PerFragment;
import com.zerowater.environment.injection.module.FragmentModule;

import dagger.Component;

/**
 * Created by YoungSoo Kim on 2016-06-23.
 * 4ground Ltd
 * byzerowater@gmail.com
 * Dagger FragmentComponent
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
}

