package ru.ftc.android.shifttemple.features.tasks.presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;


public final class CreateTaskActivity extends BaseActivity implements CreateTaskView {

    public static void start(final Context context){
        Intent intent = new Intent(context, CreateTaskActivity.class);
        context.startActivity(intent);
    }
    private CreateTaskPresenter presenter;

    private EditText shortDesc;
    private EditText fullDesc;
    private Button createButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        initView();
    }

    private void initView(){
        shortDesc = findViewById(R.id.ShortDeskPlace);
        fullDesc = findViewById(R.id.FullDeskPlace);
        createButton = findViewById(R.id.TaskToCreate);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Task task = new Task(String.valueOf(shortDesc.getText()),String.valueOf(fullDesc.getText()),Intent.EXTRA_TEXT);
                presenter.createTask(task);
                shortDesc.setText("");
                fullDesc.setText("");

            }
        });
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

    @Override
    public void showSuccess() {
        Toast.makeText(this,"Success", Toast.LENGTH_LONG);
    }
}
