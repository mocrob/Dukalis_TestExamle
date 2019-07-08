package ru.ftc.android.shifttemple.features.login.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;

public interface UserDataSource {

    List<User> getUserList();
}