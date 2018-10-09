package com.dangets.clientj;

import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ClientJ {
    @GET("users")
    Call<List<UserDto>> getAllUsers();

    @GET("user/{id}")
    Call<UserDto> getUser(@Path("id") int id);


    static ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        return om;
    }
}
