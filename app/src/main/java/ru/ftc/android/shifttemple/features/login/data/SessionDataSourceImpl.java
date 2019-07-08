package ru.ftc.android.shifttemple.features.login.data;

import android.content.Context;
import android.content.SharedPreferences;

public final class SessionDataSourceImpl implements SessionDataSource {

    private final static String SESSION_PREFERENCES_NAME = "SESSION_PREFERENCES_NAME";
    private final static String SESSION_ID_KEY = "SESSION_ID_KEY";

    private SharedPreferences sharedPreferences;

    public SessionDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(SESSION_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public String getSessionId() {
        return sharedPreferences.getString(SESSION_ID_KEY, "");
    }

    @Override
    public void setSessionId(String sessionId) {
        sharedPreferences.edit().putString(SESSION_ID_KEY, sessionId).apply();
    }
}
