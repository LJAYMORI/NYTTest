package com.example.jonguk.nyttest.utils.network;

import com.example.jonguk.nyttest.utils.parser.GsonFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class NetworkManager {
    private static final String TAG = "NetworkManager";
    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit sInstance;

    private NetworkManager(){}

    public static Retrofit getInstance() {
        if (sInstance == null) {
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            client.addInterceptor(loggingInterceptor);

            sInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client.build())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create(GsonFactory.getGson()))
                    .build();
        }
        return sInstance;
    }
}
