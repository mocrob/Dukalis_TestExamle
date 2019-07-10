package ru.ftc.android.shifttemple.features.login.domain;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.data.UserRepository;
import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;

public final class UserInteractorImpl implements UserInteractor {

    private final UserRepository userRepository;

    public UserInteractorImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }

    @Override
    public void loadUsers(Carry<List<User>> carry) {
        userRepository.loadUsers(carry);
    }

    @Override
    public void loadUser(String userId, Carry<User> carry) {
        userRepository.loadUser(userId, carry);
    }

    @Override
    public void createUser(User user, Carry<User> carry) {
        userRepository.createUser(user, carry);
    }

    @Override
    public void auth(String username, Carry<User> carry) {
        userRepository.auth(username, carry);
    }
}