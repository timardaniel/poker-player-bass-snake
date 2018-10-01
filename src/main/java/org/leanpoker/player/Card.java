package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
    public static ArrayList<HashMap<String, String>> holeCards = new ArrayList<>();
    public static ArrayList<HashMap<String, String>> communityCards = new ArrayList<>();

    String suit;
    String rank;


    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

    }

    public Card(){

    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }


    public List<Card> getHoleCards(JsonElement request) {

        JsonArray cardsJson = returnPlayer(request).get("hole_cards").getAsJsonArray();
        List<Card> cards = new ArrayList();
        for (JsonElement cardJson : cardsJson) {
            JsonObject cardObject = cardJson.getAsJsonObject();
            cards.add(new Card(cardObject.get("rank").getAsString(), cardObject.get("suit").getAsString()));
        }
        return cards;


    }


    private JsonObject returnPlayer(JsonElement request) {
        JsonArray players = request.getAsJsonObject().getAsJsonArray("players");
        JsonObject player = null;
        int result = 0;
        for (int i = 0; i < players.size(); i++) {
            JsonElement element = players.get(i);
            JsonObject pl = element.getAsJsonObject();
            if (pl.get("name").getAsString().equals("Bass Snake")) {
                player = pl;
            }
        }
        return player;
    }

}

