package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "1.1";

    public static int betRequest(JsonElement request) {
        Map<String,Object> result = new Gson().fromJson(request, Map.class);
        System.err.println(result.get("players"));


        if (Card.chechNumberOfCardsChance() > 0 ) {
            return 10000;
        } else {
            return Card.areCardsSmall() ? 0 : 10000;
       }
    }

    public static void showdown(JsonElement game) {

    }
}

//bassSnake