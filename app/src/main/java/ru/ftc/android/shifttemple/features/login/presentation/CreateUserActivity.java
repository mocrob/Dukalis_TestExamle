package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;

public final class CreateUserActivity extends BaseActivity implements CreateUserView{

    public static void start(final Context context){
        Intent intent = new Intent(context, CreateUserActivity.class);
        context.startActivity(intent);
    }

    private CreateUserPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_activity);
    }
    @Override
    protected  MvpPresenter<CreateUserView> getPresenter() {
        presenter = CreateUserPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView  getMvpView() {
        return this;
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Some ERROR", Toast.LENGTH_LONG);
    }
}
