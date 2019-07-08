package ru.ftc.android.shifttemple.features.login.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.data.UserRepository;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class UserInteractorImplTest {

    private final UserRepository repository = mock(UserRepository.class);

    private final UserInteractor interactor = new UserInteractorImpl(repository);

    @After
    public void tearDown() {
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getUserList() {
        final List<User> userList = mock(List.class);
        when(repository.getUserList()).thenReturn(userList);

        final List<User> actual = interactor.getUserList();

        assertEquals(userList, actual);
        verify(repository).getUserList();
    }
}