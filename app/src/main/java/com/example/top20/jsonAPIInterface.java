package com.example.top20;

import java.util.List;

import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface jsonAPIInterface {
    @GET("hours")
    Call<List<Post>> getPosts();


    @GET("skilliq")
    Call<List<skilliq>> getiq();


//    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
//   // @Headers("Content-Type: text/html")
//    @Headers({"Accept: application/json"})
//    @FormUrlEncoded
//    Call<FormPost> createFormPost(
//    @Field ("entry.1824927963") String email,
//    @Field ("entry.1877115667") String fname,
//    @Field ("entry.2006916086") String lname,
//    @Field ("Track") String track   ,
//    @Field ("entry.284483984") String link

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    @Nullable
    Call<Void> createFormPost(
            @Field("entry.1877115667") @Nullable String firstName,
            @Field("entry.2006916086") @Nullable String lastName,
            @Field("entry.284483984") @Nullable String githubLink,
            @Field("entry.1824927963") @Nullable String emailAddress);



}
