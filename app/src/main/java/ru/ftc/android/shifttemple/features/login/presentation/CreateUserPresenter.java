package ru.ftc.android.shifttemple.features.login.presentation;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractor;
import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;

public final class CreateUserPresenter extends MvpPresenter<CreateUserView> {
    private final UserInteractor interactor;

    public CreateUserPresenter(UserInteractor interactor){this.interactor=interactor;}

    public void createUser(User user){
        interactor.createUser(user, new Carry<User>() {
            @Override
            public void onSuccess(User result) {

            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError();
            }
        });
    }
}
