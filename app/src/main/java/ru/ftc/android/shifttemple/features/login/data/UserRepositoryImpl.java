package ru.ftc.android.shifttemple.features.login.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;

public final class UserRepositoryImpl implements UserRepository {

    private final UserDataSource dataSource;

    public UserRepositoryImpl(final UserDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getUserList() {
        return dataSource.getUserList();
    }

    @Override
    public void loadUsers(Carry<List<User>> carry) {
        dataSource.getUsersList(carry);
    }

    @Override
    public void loadUser(String userId, Carry<User> carry) {
        dataSource.getUser(userId, carry);
    }

    @Override
    public void createUser(User user, Carry<User> carry) {
        dataSource.createUser(user, carry);
    }

    @Override
    public void auth(String username, Carry<User> carry) {
        dataSource.authUser(username, carry);
    }
}