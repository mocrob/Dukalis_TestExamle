package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;

import ru.ftc.android.shifttemple.App;
import ru.ftc.android.shifttemple.features.login.data.SessionDataSource;
import ru.ftc.android.shifttemple.features.login.data.SessionDataSourceImpl;
import ru.ftc.android.shifttemple.features.login.data.SessionRepository;
import ru.ftc.android.shifttemple.features.login.data.SessionRepositoryImpl;
import ru.ftc.android.shifttemple.features.login.data.UserApi;
import ru.ftc.android.shifttemple.features.login.data.UserDataSource;
import ru.ftc.android.shifttemple.features.login.data.UserDataSourceImpl;
import ru.ftc.android.shifttemple.features.login.data.UserRepository;
import ru.ftc.android.shifttemple.features.login.data.UserRepositoryImpl;
import ru.ftc.android.shifttemple.features.login.domain.SessionInteractor;
import ru.ftc.android.shifttemple.features.login.domain.SessionInteractorImpl;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractor;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractorImpl;

final class PresenterFactory {

    static LoginPresenter createPresenter(Context context) {
        final UserApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(UserApi.class);
        final UserDataSource userDataSource = new UserDataSourceImpl(api);
        final UserRepository userRepository = new UserRepositoryImpl(userDataSource);
        final UserInteractor userInteractor = new UserInteractorImpl(userRepository);

        final SessionDataSource sessionDataSource = new SessionDataSourceImpl(context);
        final SessionRepository sessionRepository = new SessionRepositoryImpl(sessionDataSource);
        final SessionInteractor sessionInteractor = new SessionInteractorImpl(sessionRepository);

        return new LoginPresenter(userInteractor, sessionInteractor);
    }
}