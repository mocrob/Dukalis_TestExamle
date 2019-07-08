package ru.ftc.android.shifttemple.features.login.data;

public final class SessionRepositoryImpl implements SessionRepository {

    private final SessionDataSource dataSource;

    public SessionRepositoryImpl(SessionDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setSessionId(String sessionId) {
        dataSource.setSessionId(sessionId);
    }
}