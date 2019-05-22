package com.example.dagger2.di.modules;

import android.app.Activity;
import android.util.DisplayMetrics;

import com.example.dagger2.data.model.ScreenData;
import com.example.dagger2.di.annotation.MyActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    // Thêm @MyActivityContext để Dagger biết mà trả đúng kiểu dữ liệu khi dúng @Provides
    @Provides
    @MyActivityContext
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    public ScreenData provideScreenData() {
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new ScreenData(dm.widthPixels, dm.widthPixels);
    }
}