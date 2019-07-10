package ru.ftc.android.shifttemple.features.login.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

public interface UserApi {
    @GET("users")
    Call<List<User>> getUsersList();

    @POST("users")
    Call<User> createUser(@Body User user);

    @GET("users/{userId}")
    Call<User> getUser(@Path("userId") String userId);

    @GET("users/auth/{username}")
    Call<User> authUser(@Path("username") String username);


}
