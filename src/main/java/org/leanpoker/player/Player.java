package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "1.1";

    public static int betRequest(JsonElement request) {
//        JsonObject json = request.getAsJsonObject();
       /* Map jsonJavaRootObject = new Gson().fromJson(request, Map.class);
        System.err.println("Hello");
        System.err.println(jsonJavaRootObject.get("hole_cards").toString());
*/
        return 10000;
    }

    public static void showdown(JsonElement game) {

    }
}

//bassSnake