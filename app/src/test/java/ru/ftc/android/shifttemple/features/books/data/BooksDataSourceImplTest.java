package ru.ftc.android.shifttemple.features.books.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import ru.ftc.android.shifttemple.features.books.domain.model.Book;
import ru.ftc.android.shifttemple.features.books.domain.model.Success;
import ru.ftc.android.shifttemple.network.Carry;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created: samokryl
 * Date: 04.07.18
 * Time: 9:54
 */
@RunWith(MockitoJUnitRunner.class)
public class BooksDataSourceImplTest {

    private BooksDataSource dataSource;

    private final BooksApi api = mock(BooksApi.class);
    private final Book firstBook = mock(Book.class);
    private final Book secondBook = mock(Book.class);
    private final List<Book> bookList = new ArrayList<>();
    private final String bookId = "123";

    @Before
    public void setUp() {
        bookList.add(firstBook);
        bookList.add(secondBook);

        dataSource = new BooksDataSourceImpl(api);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(api);
    }

    @Test
    public void getBooks() {
        Carry<List<Book>> carry = mock(Carry.class);
        Call<List<Book>> call = mock(Call.class);
        when(api.getBookList(1)).thenReturn(call);

        dataSource.getBooks(carry);

        verify(api).getBookList(1);
    }

    @Test
    public void getBook() {
        Carry<Book> carry = mock(Carry.class);
        Call<Book> call = mock(Call.class);
        when(api.getBook(bookId)).thenReturn(call);

        dataSource.getBook(bookId, carry);

        verify(api).getBook(bookId);

    }

    @Test
    public void createBook() {
        Carry<Book> carry = mock(Carry.class);
        Call<Book> call = mock(Call.class);
        when(api.createBook(secondBook)).thenReturn(call);

        dataSource.createBook(secondBook, carry);

        verify(api).createBook(secondBook);
    }

    @Test
    public void deleteBook() {
        Carry<Success> carry = mock(Carry.class);
        Call<Success> call = mock(Call.class);
        when(api.deleteBook(bookId)).thenReturn(call);

        dataSource.deleteBook(bookId, carry);

        verify(api).deleteBook(bookId);
    }
}