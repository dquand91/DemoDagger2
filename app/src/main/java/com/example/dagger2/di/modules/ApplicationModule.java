package com.example.dagger2.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dagger2.MyApp;
import com.example.dagger2.di.annotation.DatabaseInfo;
import com.example.dagger2.di.annotation.MyApplicationContext;

import dagger.Module;
import dagger.Provides;

// Class này làm nhiệm vụ cung cấp các đối tượng của các class khác nhau.
// Đây là bước rất quan trọng, ta sẽ xây dựng các module cung cấp các Dependency để sử dụng trong activity của ta

// Như bên constructor của class DBHelper cần 3 thành phần
//              @ApplicationContext Context và
//              @DatabaseInfo String và
//              @DatabaseInfo Integer.
//      Ở đây mình sẽ provide những cái đó cho Dagger biết thông qua phương thức:
//              "provideApplicationContext", provideDBName, provideDBVersion bên dưới
//               *** Nhớ là phải thêm custom annotation tương ứng với từng @Provides
//                     ** ví dụ: thêm @MyApplicationContext vào provideApplicationContext()
//                               thêm @DatabaseInfo vào provideDBName()

@Module
public class ApplicationModule {

    // Mình tạo 1 biến application để lưu giữ application lại, class nào cần thì gọi ra sử dụng.
    MyApp application;

    // Mình sẽ gọi constructor của ApplicationModule để truyền vào cái application mình muốn lưu lại.
    // Ví dụ: ở class MyApp, mình gọi DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    public ApplicationModule(MyApp application) {
        this.application = application;
    }

    // Thêm @MyApplicationContext để Dagger biết mà trả đúng kiểu dữ liệu khi dúng @Provides
    @Provides
    @MyApplicationContext
    public Context provideApplicationContext() {
        return application;
    }

    //@DatabaseInfo để Dagger trả về đúng kiểu String của DatabaseInfo mà mình đã định nghĩa
    @Provides
    @DatabaseInfo
    public String provideDBName() {
        return "DaggerExample-DB";
    }

    //@DatabaseInfo để Dagger trả về đúng kiểu Integer của DatabaseInfo mà mình đã định nghĩa
    @Provides
    @DatabaseInfo
    public Integer provideDBVersion() {
        return 1;
    }


    // Ở đây không cần thêm custom Annotation như 3 cái provider trên, vì SharedPreferences này chỉ có 1 class mặc định duy nhât.
    // Nếu mình custom lại SharedPreferences hoặc có nhiều class SharedPreference thì mình phải tạo custom annotation để báo cho Dagger biết mà trả đúng kiểu dữ liệu khi dùng @Provider
    @Provides
    public SharedPreferences provideSharedPreference() {
        return application.getSharedPreferences("DaggerExample-SharedPrefs", Context.MODE_PRIVATE);
    }
}
