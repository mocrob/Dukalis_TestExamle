package ru.ftc.android.shifttemple.features.login.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;

public interface UserDataSource {

    List<User> getUserList();

    void getUsersList(Carry<List<User>> carry);

    void getUser(String userId, Carry<User> carry);

    void createUser(User user, Carry<User> carry);

    void authUser(String username, Carry<User> carry);
}