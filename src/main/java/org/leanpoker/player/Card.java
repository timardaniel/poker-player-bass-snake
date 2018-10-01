package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Card {

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
        List<Card> cards = new ArrayList<>();
        for (JsonElement cardJson : cardsJson) {
            JsonObject cardObject = cardJson.getAsJsonObject();
            cards.add(new Card(cardObject.get("rank").getAsString(), cardObject.get("suit").getAsString()));
        }
        return cards;


    }

    public List<Card> getCommunityCards(JsonElement request) {

        JsonArray cardsJson = request.getAsJsonObject().get("community_cards").getAsJsonArray();
        List<Card> cards = new ArrayList<>();
        for (JsonElement cardJson : cardsJson) {
            JsonObject cardObject = cardJson.getAsJsonObject();
            cards.add(new Card(cardObject.get("rank").getAsString(), cardObject.get("suit").getAsString()));
        }
        return cards;


    }


    private JsonObject returnPlayer(JsonElement request) {
        JsonArray players = request.getAsJsonObject().getAsJsonArray("players");
        JsonObject player = null;
        for (int i = 0; i < players.size(); i++) {
            JsonElement element = players.get(i);
            JsonObject pl = element.getAsJsonObject();
            if (pl.get("name").getAsString().equals("Bass Snake")) {
                player = pl;
            }
        }
        return player;
    }

    public static boolean isThereAPairInHand() {
        return Player.cardInHand.get(0).getRank().equals(Player.cardInHand.get(1).getRank());
    }

    public static int checkOccurences(String rank) {
        int counter = 0;
        for (Card card : Player.communityCards) {
            if (card.getRank().equals(rank))
                counter++;
        }
        return counter;
    }


    public static int chechNumberOfCardsChance() {
        if (isThereAPairInHand()) {
            int counter = checkOccurences(Player.cardInHand.get(0).getRank());
            switch (counter) {
                case 0:
                    return 4;
                case 1:
                    return 8;
                case 2:
                    return 10;
                default:
                    return 0;
            }

        } else {
            int counter1 = checkOccurences(Player.cardInHand.get(0).getRank());
            int counter2 = checkOccurences(Player.cardInHand.get(1).getRank());
            int count = Math.max(counter1, counter2);

            switch (count) {
                case 0:
                    return 0;
                case 1:
                    return 3;
                case 2:
                    return 7;
                case 3:
                    return 9;
                default:
                    return 0;

            }

        }
    }



    public static boolean areCardsSmall () {
        return Integer.parseInt(Player.cardInHand.get(0).getRank()) < 7 && Integer.parseInt(Player.cardInHand.get(1).getRank()) < 7;
    }
}
