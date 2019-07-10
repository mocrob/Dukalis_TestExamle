package ru.ftc.android.shifttemple.features.tasks.presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;

public class ShowTaskActivity extends BaseActivity implements ShowTaskView {


    public static void start(final Context context) {
        Intent intent = new Intent(context, ShowTaskActivity.class);
        context.startActivity(intent);
    }
    private ShowTaskPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

    }


    @Override
    protected MvpPresenter<ShowTaskView> getPresenter() {
        presenter = ShowTaskPresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Empty field", Toast.LENGTH_LONG);
    }
}
