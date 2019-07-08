package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.content.Context;

import ru.ftc.android.shifttemple.App;
import ru.ftc.android.shifttemple.features.tasks.data.TaskRepositoryImpl;
import ru.ftc.android.shifttemple.features.tasks.data.TasksApi;
import ru.ftc.android.shifttemple.features.tasks.data.TasksDataSource;
import ru.ftc.android.shifttemple.features.tasks.data.TasksDataSourceImpl;
import ru.ftc.android.shifttemple.features.tasks.data.TasksRepository;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractorImpl;

public final class PresenterFactory {

    static  TaskListPresenter createPresenter(Context context){
        final TasksApi api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(TasksApi.class);

        final TasksDataSource dataSource = new TasksDataSourceImpl(api);
        final TasksRepository repository = new TaskRepositoryImpl(dataSource);
        final TasksInteractor interactor = new TasksInteractorImpl(repository);

        return new TaskListPresenter(interactor);
    }
}
