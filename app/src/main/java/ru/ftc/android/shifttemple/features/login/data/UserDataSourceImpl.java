package ru.ftc.android.shifttemple.features.login.data;

import java.util.ArrayList;
import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;
import ru.ftc.android.shifttemple.network.DefaultCallback;

public final class UserDataSourceImpl implements UserDataSource {

    private final UserApi userApi;

    public UserDataSourceImpl(UserApi userApi) {this.userApi = userApi;}

    @Override
    public List<User> getUserList() {

        final List<User> userList = new ArrayList<>();

        //userList.add(new User("1", " Петя"));
       //userList.add(new User("42", " Вася"));
        //userList.add(new User("43", " Катя"));

        return userList;
    }

    @Override
    public void getUsersList(Carry<List<User>> carry) {
        userApi.getUsersList().enqueue(new DefaultCallback(carry));
    }

    @Override
    public void getUser(String userId, Carry<User> carry) {
        userApi.getUser(userId).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void createUser(User user, Carry<User> carry) {
        userApi.createUser(user).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void authUser(String username, Carry<User> carry) {
        userApi.authUser(username).enqueue(new DefaultCallback(carry));
    }
}