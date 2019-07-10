package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.content.Context;

public final class CreateTaskPresenterFactory {
    static  CreateTaskPresenter createPresenter(Context context){
        return new CreateTaskPresenter();
    }
}
