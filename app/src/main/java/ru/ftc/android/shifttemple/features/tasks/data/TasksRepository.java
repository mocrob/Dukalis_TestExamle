package ru.ftc.android.shifttemple.features.tasks.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

public interface TasksRepository {

    void loadTasks(Carry<List<Task>> carry);

    void loadTask(String taskId, Carry<Task> carry);

    void createTask(Task task, Carry<Task> carry);/*Interface of createTask DataSource*/

    void applyTask(String taskId, Carry<Task> carry); /*Interface of applyTask DataSource*/

    void cancelTask(String taskId, Carry<Task> carry); /*Interface of cancelTask DataSource*/

    void completeTask(String taskId, Carry<Task> carry); /*Interface of completeTask DataSource*/
}
