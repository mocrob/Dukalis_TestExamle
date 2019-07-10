package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;
import android.content.Intent;

import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;

public final class CreateUserActivity extends BaseActivity {

    public static void start(final Context context){
        Intent intent = new Intent(context, CreateUserActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected <T extends MvpView> MvpPresenter<T> getPresenter() {
        return null;
    }

    @Override
    protected <T extends MvpView> T getMvpView() {
        return null;
    }
}
