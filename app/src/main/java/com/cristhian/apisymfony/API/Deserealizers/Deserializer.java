package com.cristhian.apisymfony.API.Deserealizers;

import com.cristhian.apisymfony.Models.User;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Cristhian on 20-12-2017.
 */

public class Deserializer implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String status = json.getAsJsonObject().get("status").getAsString();

        int id = json.getAsJsonObject().get("user").getAsJsonObject().get("id").getAsInt();
        String role = json.getAsJsonObject().get("user").getAsJsonObject().get("role").getAsString();

        String name = json.getAsJsonObject().get("user").getAsJsonObject().get("name").getAsString();
        String surname = json.getAsJsonObject().get("user").getAsJsonObject().get("surname").getAsString();

        String email = json.getAsJsonObject().get("user").getAsJsonObject().get("email").getAsString();
        String password = json.getAsJsonObject().get("user").getAsJsonObject().get("password").getAsString();

        User user = new User(id, role, name, surname, email, password);

        return user;
    }
}
