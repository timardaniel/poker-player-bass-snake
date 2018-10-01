package org.leanpoker.player;

import java.util.ArrayList;
import java.util.HashMap;

public class Card {
    public static ArrayList<HashMap<String, String>> holeCards = new ArrayList<>();
    public static ArrayList<HashMap<String, String>> communityCards = new ArrayList<>();

    public static boolean isThereAPair() {
        if (holeCards.get(0).get("rank").equals(holeCards.get(1).get("rank")))
            return true;

        for (HashMap<String, String> card: communityCards) {
            if (card.get("rank").equals(holeCards.get(0).get("rank"))
                    || card.get("rank").equals(holeCards.get(1).get("rank")))
                return true;
        }
        return false;
    }

    public static boolean areCardsSmall() {
        if (Integer.parseInt(holeCards.get(0).get("rank")) < 7 && Integer.parseInt(holeCards.get(1).get("rank")) < 7);
        return true;
    }

}