package ru.ftc.android.shifttemple.features.tasks.data;

import java.util.List;

import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

public interface TasksDataSource {

    void getTasks(Carry<List<Task>> carry); /*This is for getTaskList*/

    void getTask(String taskId, Carry<Task> carry); /*Interface of getTask API*/

    void createTask(Task task, Carry<Task> carry); /*Interface of createTask API*/

    void applyTask(String taskId, Carry<Task> carry); /*Interface of applyTask API*/

    void cancelTask(String taskId, Carry<Task> carry); /*Interface of cancelTask API*/

    void completeTask(String taskId, Carry<Task> carry); /*Interface of completeTask API*/
}
