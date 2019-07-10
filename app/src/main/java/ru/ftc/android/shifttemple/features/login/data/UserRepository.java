package ru.ftc.android.shifttemple.features.login.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;

public interface UserRepository {

    List<User> getUserList();

    void loadUsers(Carry<List<User>> carry);

    void loadUser(String userId, Carry<User> carry);

    void createUser(User user, Carry<User> carry);

    void auth(String username, Carry<User> carry);
}