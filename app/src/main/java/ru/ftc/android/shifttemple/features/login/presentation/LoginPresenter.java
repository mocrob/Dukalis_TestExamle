package ru.ftc.android.shifttemple.features.login.presentation;

import java.util.List;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.login.domain.SessionInteractor;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractor;
import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;

public final class LoginPresenter extends MvpPresenter<LoginView> {

    private final UserInteractor userInteractor;
    private final SessionInteractor sessionInteractor;

    LoginPresenter(UserInteractor userInteractor, SessionInteractor sessionInteractor) {
        this.userInteractor = userInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    protected void onViewReady() {
        //final List<User> userList = userInteractor.getUserList();
         userInteractor.loadUsers(new Carry<List<User>>() {
            @Override
            public void onSuccess(List<User> result) {
                view.showUserList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showNotSelectedUserError();
            }
        });
    }

    void onCreateUserClick()
    {
        view.openCreateUserScreen();
    }
    void onNavigateNextClick(User selectedUser) {
        if (selectedUser == null) {
            view.showNotSelectedUserError();
        } else {
            sessionInteractor.setSessionId(String.valueOf(selectedUser.getId()));
            view.openTaskListScreen(selectedUser);
        }
    }

    public void createUser(User user){
        userInteractor.createUser(user, new Carry<User>() {
            @Override
            public void onSuccess(User result) {

            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError();
            }
        });
    }
}