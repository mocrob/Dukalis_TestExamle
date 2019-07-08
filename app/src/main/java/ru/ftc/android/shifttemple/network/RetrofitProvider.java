package ru.ftc.android.shifttemple.network;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 22:32
 */

public final class RetrofitProvider {

    //private static final String BASE_URL = "http://192.168.43.53:8080/api/v001/";
    //private static final String BASE_URL = "http://10.9.48.174:8081/api/v001/";
    private static final String BASE_URL = "https://dukalis.testsitesrv.ru/api/v001/";

    private final Retrofit retrofit;

    public RetrofitProvider(List<Interceptor> interceptorList) {        
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(createClient(interceptorList))
                .build();
    }

    private OkHttpClient createClient(List<Interceptor> interceptorList) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        for (Interceptor interceptor: interceptorList) {
            builder.addInterceptor(interceptor);
        }

        return builder.build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}