package ru.ftc.android.shifttemple.features.tasks.data;

/*
* This file add last part of query
* */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;

/*All methods have personal name, described in TaskDataSource interface*/
public interface TasksApi {
    @GET("tasks")
    Call<List<Task>> getTaskList(); /*Get all tasks what we can made*/

    @POST("tasks")
    Call<Task> createTask(@Body Task task); /*Create new Task*/

    @GET("tasks/{taskId}")
    Call<Task> getTask(@Path("taskId") String taskId); /*Get task by id*/

    @GET("tasks/{taskId}/apply")
    Call<Task> applyTask(@Path("taskId") String taskId); /*Apply the task*/

    @GET("tasks/{taskId}/cancel")
    Call<Task> cancelTask(@Path("taskId") String taskId); /*Cancel the task*/

    @GET("tasks/{taskId}/complete")
    Call<Task> completeTask(@Path("taskId") String taskId); /*Complete the task*/
}
