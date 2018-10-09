package com.dangets;

import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ClientJ {
    @GET("users")
    Call<List<UserDto>> getAllUsers();


    class UserDto {
        private int id;
        private String name;
        private String email;

        public UserDto() { }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        @Override
        public String toString() {
            return "UserDto{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    static ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        return om;
    }
}
