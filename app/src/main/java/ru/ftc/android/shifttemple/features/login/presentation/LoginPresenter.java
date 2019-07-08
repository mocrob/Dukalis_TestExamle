package ru.ftc.android.shifttemple.features.login.presentation;

import java.util.List;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.login.domain.SessionInteractor;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractor;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class LoginPresenter extends MvpPresenter<LoginView> {

    private final UserInteractor userInteractor;
    private final SessionInteractor sessionInteractor;

    LoginPresenter(UserInteractor userInteractor, SessionInteractor sessionInteractor) {
        this.userInteractor = userInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    protected void onViewReady() {
        final List<User> userList = userInteractor.getUserList();
        view.showUserList(userList);
    }

    void onNavigateNextClick(User selectedUser) {
        if (selectedUser == null) {
            view.showNotSelectedUserError();
        } else {
            sessionInteractor.setSessionId(selectedUser.getSessionId());
            view.openBookListScreen();
        }
    }
}