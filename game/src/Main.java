import game.Game;
import game.GameStatus;
import judgement.GameAssociation;
import judgement.GameRule;
import judgement.Referee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameRule gameAssociation = gameInit();
        GameStatus game = new Game(gameAssociation);
        do {
            game.play();
        } while (game.isRepeat());

    }

    public static GameRule gameInit() {
        int gameRuleLength = 3;

        return new GameAssociation(gameRuleLength);
    }
}