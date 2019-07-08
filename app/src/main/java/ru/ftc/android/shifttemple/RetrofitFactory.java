package ru.ftc.android.shifttemple;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.ftc.android.shifttemple.features.login.data.SessionDataSource;
import ru.ftc.android.shifttemple.features.login.data.SessionDataSourceImpl;
import ru.ftc.android.shifttemple.network.RetrofitProvider;
import ru.ftc.android.shifttemple.network.SessionInterceptor;

final class RetrofitFactory {

    static RetrofitProvider createRetrofitProvider(Context context) {
        final HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final SessionDataSource dataSource = new SessionDataSourceImpl(context);
        final SessionInterceptor sessionInterceptor = new SessionInterceptor(dataSource);

        final List<Interceptor> interceptorList = new ArrayList<>();
        interceptorList.add(logInterceptor);
        interceptorList.add(sessionInterceptor);

        return new RetrofitProvider(interceptorList);
    }
}
