package com.example.dagger2.di.components;

import com.example.dagger2.MainActivity;
import com.example.dagger2.di.annotation.PerActivity;
import com.example.dagger2.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}