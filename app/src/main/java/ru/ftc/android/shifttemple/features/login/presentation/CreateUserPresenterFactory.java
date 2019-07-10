package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;

import ru.ftc.android.shifttemple.App;
import ru.ftc.android.shifttemple.features.login.data.UserApi;
import ru.ftc.android.shifttemple.features.login.data.UserDataSource;
import ru.ftc.android.shifttemple.features.login.data.UserDataSourceImpl;
import ru.ftc.android.shifttemple.features.login.data.UserRepository;
import ru.ftc.android.shifttemple.features.login.data.UserRepositoryImpl;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractor;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractorImpl;

public final class CreateUserPresenterFactory {
    static CreateUserPresenter createPresenter(Context context){
        final UserApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(UserApi.class);
        final UserDataSource userDataSource = new UserDataSourceImpl(api);
        final UserRepository userRepository = new UserRepositoryImpl(userDataSource);
        final UserInteractor userInteractor = new UserInteractorImpl(userRepository);
        return new CreateUserPresenter(userInteractor);
    }
}
