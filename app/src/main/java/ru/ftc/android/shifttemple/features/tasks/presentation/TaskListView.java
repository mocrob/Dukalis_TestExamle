package ru.ftc.android.shifttemple.features.tasks.presentation;

import java.util.List;

import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;

public interface TaskListView extends MvpView {

    void showProgress();

    void hideProgress();

    void showTaskList(List<Task> list);

    void showError(String message);

    void openCreateTaskScreen();

    void openFullTaskCard(Task task);

    void showSuccess();
}
