package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.login.domain.model.User;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;

public final class TaskActivity extends BaseActivity implements TaskListView {

    public static void start(final Context context, User user){
        Intent intent = new Intent(context, TaskActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,user.getCity());
        context.startActivity(intent);
    }

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private Button createTaskButton;
    private TaskAdapter adapter;
    //private String activeUserCity;

    private TaskListPresenter presenter;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_activity);

        initView();
    }

    private void initView(){
        progressBar = findViewById(R.id.tasks_progress);
        recyclerView = findViewById(R.id.tasks_recycle_view);
        createTaskButton = findViewById(R.id.task_create_button);
        final FloatingActionButton floatingActionButton = findViewById(R.id.create_task_fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOpenCreateTaskClicked();
            }
        });

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onCreateTaskClicked();
            }
        });

        adapter = new TaskAdapter(this, new TaskAdapter.SelectTaskListener(){
            @Override
            public void onTaskSelect(Task task) {presenter.onTaskSelected(task);}

            @Override
            public void onTaskLongClick(Task task) {presenter.onTaskLongClicked(task);}
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected MvpPresenter<TaskListView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTaskList(List<Task> list) {
        adapter.setTasks(list);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void openCreateTaskScreen() {
        CreateTaskActivity.start(this);
    }

    @Override
    public void openFullTaskCard() {
        //ShowTaskActivity.start(this);
    }
}
