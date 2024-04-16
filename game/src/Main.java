import game.Game;
import game.GameStatus;
import judgement.GameAssociation;
import judgement.GameRule;
import judgement.Referee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameRule gameAssociation = gameInit();
        GameStatus game;
        do {
            game = new Game(gameAssociation);
            game.play();
        } while (game.isRepeat());

    }

    public static GameRule gameInit() {
        String  gameRuleLength = "3";

//        GameRule gameRule = new GameAssociation();
//        gameRule.setRule(gameRuleLength);

        return new GameAssociation(gameRuleLength);
    }
}