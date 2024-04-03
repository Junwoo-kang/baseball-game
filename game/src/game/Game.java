package game;

import judgement.Ball;
import judgement.Refree;
import player.Hitter;
import player.Pitcher;

import java.util.List;
import java.util.Scanner;

public class Game implements GameStatus {

    boolean GameStart;
    Scanner scanner;

    public Game(){
        this.GameStart = true;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        Game game = new Game();
        Pitcher pitcher = new Pitcher();
        for (String a : pitcher.randomScore) {
            System.out.println(a);

        }
        Hitter hitter = new Hitter(scanner);

        Refree refree = new Refree();

        List<Ball> result = refree.compareTo(pitcher, hitter);

        System.out.println(result);





    }

    public void end() {

    }
}
