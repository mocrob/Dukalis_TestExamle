package ru.ftc.android.shifttemple.features.tasks.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;
import ru.ftc.android.shifttemple.network.DefaultCallback;

/*Connect together API and DataSource*/
public final class TasksDataSourceImpl implements TasksDataSource {

    private final TasksApi tasksApi;

    public TasksDataSourceImpl(TasksApi tasksApi) {this.tasksApi = tasksApi;}

    @Override
    public void getTasks(Carry<List<Task>> carry) {
        tasksApi.getTaskList().enqueue(new DefaultCallback(carry)); /*queue API methods with default callback*/
    }

    @Override
    public void getTask(String taskId, Carry<Task> carry) {
        tasksApi.getTask(taskId).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void createTask(Task task, Carry<Task> carry) {
        tasksApi.createTask(task).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void applyTask(String taskId, Carry<Task> carry) {
        tasksApi.applyTask(taskId).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void cancelTask(String taskId, Carry<Task> carry) {
        tasksApi.cancelTask(taskId).enqueue(new DefaultCallback(carry));
    }

    @Override
    public void completeTask(String taskId, Carry<Task> carry) {
        tasksApi.completeTask(taskId).enqueue(new DefaultCallback(carry));
    }
}
