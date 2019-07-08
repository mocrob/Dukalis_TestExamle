package ru.ftc.android.shifttemple.features.books.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.ftc.android.shifttemple.features.books.domain.model.Book;
import ru.ftc.android.shifttemple.features.books.domain.model.Success;

/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 22:49
 */

public interface BooksApi {

    //@GET("books")
    //Call<List<Book>> getBookList();

    //@Headers("userId: 1")
    @GET("tasks")
  //  Call<List<Book>> getBookList(@Header("userId") int userId);
    Call<List<Book>> getBookList();

    @GET("books/{id}")
    Call<Book> getBook(@Path("id") String id);

    @POST("books")
    Call<Book> createBook(@Body Book book);

    @DELETE("books/{id}")
    Call<Success> deleteBook(@Path("id") String id);

}
