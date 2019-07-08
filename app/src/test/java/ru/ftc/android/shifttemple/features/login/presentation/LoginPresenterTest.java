package ru.ftc.android.shifttemple.features.login.presentation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.SessionInteractor;
import ru.ftc.android.shifttemple.features.login.domain.UserInteractor;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class LoginPresenterTest {

    private final LoginView view = mock(LoginView.class);

    private final UserInteractor userInteractor = mock(UserInteractor.class);
    private final SessionInteractor sessionInteractor = mock(SessionInteractor.class);

    private LoginPresenter presenter = new LoginPresenter(userInteractor, sessionInteractor);

    private final List<User> userList = mock(List.class);

    @Before
    public void setUp() {
        when(userInteractor.getUserList()).thenReturn(userList);

        presenter.attachView(view);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(view, userInteractor, sessionInteractor);
    }

    @Test
    public void onViewReady() {
        verify(userInteractor).getUserList();
        verify(view).showUserList(userList);
    }

    @Test
    public void onNavigateNextClickAndUserSelected() {
        reset(userInteractor, view);
        final String sessionId = "sessionId";
        final User selectedUser = mock(User.class);
        when(selectedUser.getSessionId()).thenReturn(sessionId);

        presenter.onNavigateNextClick(selectedUser);

        verify(sessionInteractor).setSessionId(sessionId);
        verify(view).openBookListScreen();
    }

    @Test
    public void onNavigateNextClickAndUserNotSelected() {
        reset(userInteractor, view);

        presenter.onNavigateNextClick(null);

        verify(view).showNotSelectedUserError();
    }
}