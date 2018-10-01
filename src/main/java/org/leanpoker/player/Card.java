package org.leanpoker.player;

import java.util.ArrayList;
import java.util.HashMap;

public class Card {
    public static ArrayList<HashMap<String, String>> holeCards = new ArrayList<>();
    public static ArrayList<HashMap<String, String>> communityCards = new ArrayList<>();

    public static boolean isThereAPairInHand() {
        return (holeCards.get(0).get("rank").equals(holeCards.get(1).get("rank")));
    }

    public static int checkOccurences(String rank) {
        int counter = 0;
        for (HashMap<String, String> card : communityCards) {
            if (card.get("rank").equals(rank))
                counter++;
        }
        return counter;
    }


    public static int chechNumberOfCardsChance() {
        if (isThereAPairInHand()) {
            int counter = checkOccurences(holeCards.get(0).get("rank"));
            switch (counter) {
                case 0:
                    return 4;
                case 1:
                    return 8;
                case 2:
                    return 10;
            }

        } else {
            int counter1 = checkOccurences(holeCards.get(0).get("rank"));
            int counter2 = checkOccurences(holeCards.get(1).get("rank"));
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

            }

        }
    }



    public static boolean areCardsSmall () {
        if (Integer.parseInt(holeCards.get(0).get("rank")) < 7 && Integer.parseInt(holeCards.get(1).get("rank")) < 7)
            return true;
        return false;
    }
}
