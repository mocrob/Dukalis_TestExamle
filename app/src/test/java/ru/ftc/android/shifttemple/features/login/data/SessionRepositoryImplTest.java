package ru.ftc.android.shifttemple.features.login.data;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public final class SessionRepositoryImplTest {

    private final SessionDataSource dataSource = mock(SessionDataSource.class);

    private final SessionRepository repository = new SessionRepositoryImpl(dataSource);

    @After
    public void tearDown() {
        verifyNoMoreInteractions(dataSource);
    }

    @Test
    public void setSessionId() {
        final String sessionId = "sessionId";

        repository.setSessionId(sessionId);

        verify(dataSource).setSessionId(sessionId);
    }
}