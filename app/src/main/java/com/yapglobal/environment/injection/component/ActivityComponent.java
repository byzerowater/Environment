package com.yapglobal.environment.injection.component;

import com.yapglobal.environment.injection.PerActivity;
import com.yapglobal.environment.injection.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}

