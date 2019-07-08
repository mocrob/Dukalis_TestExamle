package ru.ftc.android.shifttemple.features.login.data;

import java.util.ArrayList;
import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class UserDataSourceImpl implements UserDataSource {

    @Override
    public List<User> getUserList() {
        final List<User> userList = new ArrayList<>();

        userList.add(new User("1", " Петя"));
        userList.add(new User("2", " Вася"));
        userList.add(new User("3", " Катя"));

        return userList;
    }
}