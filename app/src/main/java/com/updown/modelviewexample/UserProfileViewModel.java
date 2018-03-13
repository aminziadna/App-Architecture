package com.updown.modelviewexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.updown.modelviewexample.data.User;

/**
 * Created by Amin on 3/13/2018.
 */

public class UserProfileViewModel extends ViewModel {
    private String userId;
    private LiveData<User> user;

    public void init(String userId) {
        this.userId = userId;
    }

    public LiveData<User> getUser() {
        return user;
    }
}
