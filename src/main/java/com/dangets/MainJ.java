package com.dangets;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class MainJ {
    public static final void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567")
                .client(okHttpClient)
                .build();

        useClientJ(retrofit);


        // shutdown retrofit/okhttp client for main to exit
        okHttpClient.dispatcher().executorService().shutdown();
    }

    private static void useClientJ(Retrofit baseRetrofit) throws IOException {
        Retrofit retrofit = baseRetrofit.newBuilder()
                .baseUrl("http://localhost:4567")
                .addConverterFactory(JacksonConverterFactory.create(ClientJ.getObjectMapper()))
                .build();

        ClientJ j = retrofit.create(ClientJ.class);

        Response<List<ClientJ.UserDto>> resp = j.getAllUsers().execute();
        if (!resp.isSuccessful()) {
            System.err.println("unsuccessful response: " + resp.code());
            System.err.println("body: " + resp.body());
            return;
        }

        List<ClientJ.UserDto> users = resp.body();
        if (users == null) {
            System.err.println("unexpected null value");
            return;
        }

        users.forEach(System.out::println);
    }
}



