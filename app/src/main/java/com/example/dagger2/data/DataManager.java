package com.example.dagger2.data;

import android.content.res.Resources;

import com.example.dagger2.data.model.Hotgirl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    DBHelper dbHelper;
    SharedPrefsHelper sharedPrefsHelper;


    // Khi Dagger cần khởi tạo DataManager, nó sẽ tìm trong Dependency Graph các class cần có trong hàm khởi tạo của lớp này.
    // Ở đây là Context, SharePrefsHelper, và DBHelper.
    // SharePrefsHelper, và DBHelper đã được thêm vào graph thông qua Annotation @Inject nên Dagger sẽ tự động gọi hàm khởi tạo của 2 lớp này ra.
    // Vậy còn @ApplicationContext Context context  sẽ được Dagger tìm đến class ApplicationComponent do mình tạo.
    //      Mình cần tạo thêm 3 class nữa: 1 là Application để mình khai báo và tiêm (inject) đúng Application Context vào Dagger
    //                                      2 là ApplicationComponent để để liên kế giữa class Application và class ApplicationModule
    //                                      3 là ApplicationModule để cung cấp cái Application Context đã được tiêm vào Dagger

    @Inject
    public DataManager(DBHelper dbHelper, SharedPrefsHelper sharedPrefsHelper){
        this.dbHelper = dbHelper;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    public Long addHotGirl(Hotgirl girl) {
        return dbHelper.insertUser(girl);
    }

    public List<Hotgirl> getAllGirl() throws Resources.NotFoundException, NullPointerException {
        return dbHelper.getAllGirl();
    }

    public void clearDatabase() {
        dbHelper.clearDatabase();
    }

    public void saveAccessToken(String accessToken) {
        sharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }



}
