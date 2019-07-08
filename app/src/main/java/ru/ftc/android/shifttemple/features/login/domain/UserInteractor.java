package ru.ftc.android.shifttemple.features.login.domain;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;

public interface UserInteractor {

    List<User> getUserList();
}