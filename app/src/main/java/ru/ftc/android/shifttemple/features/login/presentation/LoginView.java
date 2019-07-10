package ru.ftc.android.shifttemple.features.login.presentation;

import java.util.List;

import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

public interface LoginView extends MvpView {

    void showUserList(List<User> userList);

    void openBookListScreen();

    void openTaskListScreen(User user);

    void showNotSelectedUserError();

    void openCreateUserScreen();

    void showError();
}