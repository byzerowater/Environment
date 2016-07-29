package com.global.yap.environment.injection.component;

import com.global.yap.environment.injection.PerActivity;
import com.global.yap.environment.injection.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}

