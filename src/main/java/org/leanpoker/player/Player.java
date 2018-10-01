package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "1.1";

    public static int betRequest(JsonElement request) {
        JsonObject json = request.getAsJsonObject();
        System.err.println("Hello");
        System.err.println(json.get("hole_cards"));
        return 200;
    }

    public static void showdown(JsonElement game) {

    }
}

//bassSnake