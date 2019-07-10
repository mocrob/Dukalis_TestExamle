package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.content.Context;

public final class ShowTaskPresenterFactory {
    static ShowTaskPresenter createPresenter(Context context){
        return new ShowTaskPresenter();
    }
}
