package ru.ftc.android.shifttemple.features.tasks.presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;


public final class CreateTaskActivity extends BaseActivity implements CreateTaskView {

    public static void start(final Context context){
        Intent intent = new Intent(context, CreateTaskActivity.class);
        context.startActivity(intent);
    }
    private CreateTaskPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
    }

    @Override
    protected MvpPresenter<CreateTaskView> getPresenter() {
        presenter = CreateTaskPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected  MvpView getMvpView() {
        return  this;
    }


    @Override
    public void showError() {
        Toast.makeText(this,"Some ERROR", Toast.LENGTH_LONG);
    }
}
