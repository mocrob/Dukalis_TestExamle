package ru.ftc.android.shifttemple.features.login.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import ru.ftc.android.shifttemple.features.login.data.SessionRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public final class SessionInteractorImplTest {

    private final SessionRepository repository = mock(SessionRepository.class);

    private final SessionInteractor interactor = new SessionInteractorImpl(repository);

    @After
    public void tearDown() {
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void setSessionId() {
        final String sessionId = "sessionId";

        interactor.setSessionId(sessionId);

        verify(repository).setSessionId(sessionId);
    }
}