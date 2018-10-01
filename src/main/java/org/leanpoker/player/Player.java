package org.leanpoker.player;

import com.google.gson.JsonElement;
public class Player {

    static final String VERSION = "1.1";

    public static int betRequest(JsonElement request) {
        System.out.println(request);
        return 100;
    }

    public static void showdown(JsonElement game) {
        System.out.println("asd");
    }
}

//bassSnake