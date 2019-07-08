package ru.ftc.android.shifttemple.features.tasks.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

public final class TaskRepositoryImpl implements TasksRepository {

    private final TasksDataSource dataSource;

    public TaskRepositoryImpl(TasksDataSource dataSource) {this.dataSource = dataSource;}

    @Override
    public void loadTasks(Carry<List<Task>> carry) {
        dataSource.getTasks(carry);
    }

    @Override
    public void loadTask(String taskId, Carry<Task> carry) {
        dataSource.getTask(taskId, carry);
    }

    @Override
    public void createTask(Task task, Carry<Task> carry) {
        dataSource.createTask(task, carry);
    }

    @Override
    public void applyTask(String taskId, Carry<Task> carry) {
        dataSource.applyTask(taskId, carry);
    }

    @Override
    public void cancelTask(String taskId, Carry<Task> carry) {
        dataSource.cancelTask(taskId, carry);
    }

    @Override
    public void completeTask(String taskId, Carry<Task> carry) {
        dataSource.completeTask(taskId, carry);
    }
}
