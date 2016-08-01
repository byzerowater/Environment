package com.global.yap.environment.injection.component;

import com.global.yap.environment.injection.PerActivity;
import com.global.yap.environment.injection.module.ActivityModule;
import com.global.yap.environment.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);

}

