package ru.ftc.android.shifttemple.features.tasks.presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;

public class ShowTaskActivity extends BaseActivity implements ShowTaskView {



    public static void start(final Context context, Task task) {
        Intent intent = new Intent(context, ShowTaskActivity.class);
        context.startActivity(intent);
        ShowTaskActivity.showedTask(task);


    }
    private ShowTaskPresenter presenter;
    //private TaskListPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);
        initView();
    }

    private TextView addressText;
    private TextView descShort;
    private TextView descFull;
    private TextView updatedText;
    private Button applyButton;
    private static Task task;

    public static void showedTask(Task tasked){
        task = tasked;
    }

    private void initView(){
        addressText = findViewById(R.id.cityFullCardTextView);
        descShort = findViewById(R.id.shortDescFullCardTextView);
        descFull = findViewById(R.id.fullDescFullCardTextView);
        updatedText = findViewById(R.id.udateDateTimeText);
        applyButton = findViewById(R.id.applyButton);
        addressText.setText(task.getAddress());
        descShort.setText(task.getDescriptionShort());
        descFull.setText(task.getDescriptionFull());
        updatedText.setText(task.getUpdateDateTime());

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.applyTask(task);
            }
        });
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
