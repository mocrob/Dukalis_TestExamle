package ru.ftc.android.shifttemple.features.tasks.domain;

import java.util.List;

import ru.ftc.android.shifttemple.features.tasks.data.TasksRepository;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;
/*Connect interactor with repository*/
public final class TasksInteractorImpl implements TasksInteractor {

    private final TasksRepository repository;

    public TasksInteractorImpl(TasksRepository repository) {this.repository = repository;}

    @Override
    public void loadTasks(Carry<List<Task>> carry) {
        repository.loadTasks(carry);
    }

    @Override
    public void loadTask(String taskId, Carry<Task> carry) {
        repository.loadTask(taskId, carry);
    }

    @Override
    public void createTask(Task task, Carry<Task> carry) {
        repository.createTask(task, carry);
    }

    @Override
    public void applyTask(String taskId, Carry<Task> carry) {
        repository.applyTask(taskId, carry);
    }

    @Override
    public void cancelTask(String taskId, Carry<Task> carry) {
        repository.cancelTask(taskId,carry);
    }

    @Override
    public void completeTask(String taskId, Carry<Task> carry) {
        repository.completeTask(taskId,carry);
    }
}
