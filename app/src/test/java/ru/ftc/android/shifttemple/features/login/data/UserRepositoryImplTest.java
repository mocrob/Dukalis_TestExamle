package ru.ftc.android.shifttemple.features.login.data;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import ru.ftc.android.shifttemple.features.login.domain.model.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class UserRepositoryImplTest {

    private final UserDataSource dataSource = mock(UserDataSource.class);

    private final UserRepository repository = new UserRepositoryImpl(dataSource);

    @After
    public void tearDown() {
        verifyNoMoreInteractions(dataSource);
    }

    @Test
    public void getUserList() {
        final List<User> userList = mock(List.class);
        when(dataSource.getUserList()).thenReturn(userList);

        final List<User> actual = repository.getUserList();

        assertEquals(userList, actual);
        verify(dataSource).getUserList();
    }
}