package com.example.dalia.x_club;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by Dalia on 03/14/2018.
 */

public class X_Club  extends Application{
    public void oncreate(){
        super.onCreate();
Firebase.setAndroidContext(this);
    }
}
