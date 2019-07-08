package ru.ftc.android.shifttemple.features.login.domain;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.data.UserRepository;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class UserInteractorImpl implements UserInteractor {

    private final UserRepository userRepository;

    public UserInteractorImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }
}