package ru.ftc.android.shifttemple.features.tasks.presentation;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

public final class CreateTaskPresenter extends MvpPresenter<CreateTaskView> {
    private final TasksInteractor interactor;

    public CreateTaskPresenter(TasksInteractor interactor) {
        this.interactor = interactor;
    }

    public void createTask(Task task)
    {
        interactor.createTask(task, new Carry<Task>(){
            @Override
            public void onSuccess(Task result) {
                view.showSuccess();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError();
            }
        });
    }
}
