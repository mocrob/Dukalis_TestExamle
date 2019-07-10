package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;

public final class CreateUserPresenterFactory {
    static CreateUserPresenter createPresenter(Context context){
        return new CreateUserPresenter();
    }
}
