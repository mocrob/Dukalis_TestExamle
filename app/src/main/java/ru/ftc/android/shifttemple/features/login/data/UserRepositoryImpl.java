package ru.ftc.android.shifttemple.features.login.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class UserRepositoryImpl implements UserRepository {

    private final UserDataSource dataSource;

    public UserRepositoryImpl(final UserDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getUserList() {
        return dataSource.getUserList();
    }
}