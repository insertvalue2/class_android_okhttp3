package com.nomadlab.myretrofit3.repository;

import static com.nomadlab.myretrofit3.utils.Constants.authorizationValue;

import android.os.Build;
import android.util.Log;

import com.nomadlab.myretrofit3.BuildConfig;
import com.nomadlab.myretrofit3.repository.models.Todo;
import com.nomadlab.myretrofit3.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeService {


    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    @GET("todos/{id}")
    Call<Todo> getTodo(@Path("id") int groupId);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(httpLoggingInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static OkHttpClient httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
}

