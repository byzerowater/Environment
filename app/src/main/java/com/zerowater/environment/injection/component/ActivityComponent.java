package com.zerowater.environment.injection.component;

import com.zerowater.environment.injection.PerActivity;
import com.zerowater.environment.injection.module.ActivityModule;
import com.zerowater.environment.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);

}

