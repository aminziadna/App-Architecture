package com.updown.modelviewexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.updown.modelviewexample.data.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amin on 3/13/2018.
 */

public class UserRepository {
    private Webservice webservice;
    // ...
    public LiveData<User> getUser(int userId) {
        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(String.valueOf(userId)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // error case is left out for brevity
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }
}
