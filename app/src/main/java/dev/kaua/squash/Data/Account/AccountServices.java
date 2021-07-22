package dev.kaua.squash.Data.Account;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface    AccountServices {

    @POST("user/register")
    Call<DtoAccount> registerUser (@Body DtoAccount account);

    @POST("user/edit")
    Call<DtoAccount> edit (@Body DtoAccount account);

    @POST("user/login")
    Call<DtoAccount> login (@Body DtoAccount account);

    @POST("user/info/user")
    Call<DtoAccount> getUserInfo (@Body DtoAccount account);

    @POST("user/action/get-followers-following")
    Call<DtoAccount> get_followers_following (@Body DtoAccount account);

    @POST("user/action/follow")
    Call<DtoAccount> follow_a_user (@Body DtoAccount account);

    @POST("user/action/un-follow")
    Call<DtoAccount> un_follow_a_user (@Body DtoAccount account);
}
