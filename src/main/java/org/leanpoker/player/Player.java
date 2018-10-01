package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;


public class Player {

    static final String VERSION = "1.1";
    static List<Card> cardInHand = new ArrayList<>();

    public static int betRequest(JsonElement request) {
        Card card = new Card();
        cardInHand = card.getHoleCards(request);
        printCard();
        return 10000;
    }

    public static void showdown(JsonElement game) {

    }

    static public void printCard(){
        for (Card actualCard : cardInHand
             ) {
            System.err.println(actualCard.getRank() + " " + actualCard.getSuit());
        }
    }
}

//bassSnake