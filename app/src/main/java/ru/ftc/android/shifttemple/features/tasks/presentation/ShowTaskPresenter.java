package ru.ftc.android.shifttemple.features.tasks.presentation;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;


public class ShowTaskPresenter extends MvpPresenter<ShowTaskView> {

    private final TasksInteractor interactor;

    public ShowTaskPresenter(TasksInteractor interactor) {
        this.interactor = interactor;
    }

    public void applyTask(Task task){
        interactor.applyTask(String.valueOf(task.getId()), new Carry<Task>() {
            @Override
            public void onSuccess(Task result) {

            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError();
            }
        });
    }
}
