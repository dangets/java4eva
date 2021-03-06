package com.dangets;

import com.dangets.clientj.ClientJ;
import com.dangets.clientj.UserDto;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class MainJ {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567")
                .client(okHttpClient)
                .build();

        useClientK(retrofit);

        // shutdown retrofit/okhttp client for main to exit
        okHttpClient.dispatcher().executorService().shutdown();
    }



    private static void useClientK(Retrofit baseRetrofit) throws IOException {
        Retrofit retrofit = baseRetrofit.newBuilder()
                .baseUrl("http://localhost:4567")
                .addConverterFactory(JacksonConverterFactory.create(ClientJ.getObjectMapper()))
                .build();

        ClientK j = retrofit.create(ClientK.class);

        Response<List<ClientK.UserDto>> resp = j.getAllUsers().execute();
        printResponse(resp);
    }


    private static void useClientJ(Retrofit baseRetrofit) throws IOException {
        Retrofit retrofit = baseRetrofit.newBuilder()
                .baseUrl("http://localhost:4567")
                .addConverterFactory(JacksonConverterFactory.create(ClientJ.getObjectMapper()))
                .build();

        ClientJ j = retrofit.create(ClientJ.class);

        Response<List<UserDto>> resp = j.getAllUsers().execute();
        printResponse(resp);
    }



    /** helper function to print retrofit response body */
    private static void printResponse(Response<?> resp) {
        if (!resp.isSuccessful()) {
            System.err.println("unsuccessful response: " + resp.code());
            System.err.println("body: " + resp.body());
            return;
        }

        System.out.println(resp.body());
    }
}

