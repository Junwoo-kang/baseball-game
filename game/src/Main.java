import game.Game;
import game.GameStatus;
import judgement.GameRule;
import judgement.Referee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameStatus game = setGameRuleOnLength();
        do {
            GameRule referee = new Referee(game);
            game.start();
            referee.play();
        } while (game.isRepeat());

    }

    public static GameStatus setGameRuleOnLength() {
        Scanner scanner = new Scanner(System.in);

        return new Game( scanner, 3);
    }
}