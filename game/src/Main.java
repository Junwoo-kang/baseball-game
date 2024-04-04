import game.Game;
import judgement.Ball;
import judgement.Refree;
import player.Hitter;
import player.Pitcher;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        do {
            game.start();
            Pitcher pitcher = new Pitcher();
            Refree refree = new Refree();
            refree.play(game,pitcher);
        } while (game.GameStart);

    }



}