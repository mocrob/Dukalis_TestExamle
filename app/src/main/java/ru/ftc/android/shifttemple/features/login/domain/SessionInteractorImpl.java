package ru.ftc.android.shifttemple.features.login.domain;

import ru.ftc.android.shifttemple.features.login.data.SessionRepository;

public final class SessionInteractorImpl implements SessionInteractor {

    private final SessionRepository sessionRepository;

    public SessionInteractorImpl(final SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void setSessionId(String sessionId) {
        sessionRepository.setSessionId(sessionId);
    }
}