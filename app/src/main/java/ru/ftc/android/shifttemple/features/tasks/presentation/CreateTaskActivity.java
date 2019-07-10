package ru.ftc.android.shifttemple.features.tasks.presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;


public final class CreateTaskActivity extends BaseActivity implements TaskListView {

    public static void start(final Context context, User user){
        Intent intent = new Intent(context, CreateTaskActivity.class);
        context.startActivity(intent);
        fillUser(user);
    }
    private TaskListPresenter presenter;

    private EditText shortDesc;
    private EditText fullDesc;
    private Button createButton;

    private static User user;

    public static void fillUser(User users) {
        user=users;
    }

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

                Task task = new Task(String.valueOf(shortDesc.getText()),String.valueOf(fullDesc.getText()),String.valueOf(user.getCity()));
                presenter.createTask(task);
                shortDesc.setText("");
                fullDesc.setText("");

            }
        });
    }

    @Override
    protected MvpPresenter<TaskListView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected  MvpView getMvpView() {
        return  this;
    }



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showTaskList(List<Task> list) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void openCreateTaskScreen() {

    }

    @Override
    public void openFullTaskCard(Task task) {

    }

    @Override
    public void showSuccess() {
        Toast.makeText(this,"Success", Toast.LENGTH_LONG);
    }
}
