package game;

import player.Hitter;
import player.Pitcher;

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
        Hitter hitter = new Hitter(scanner);





    }

    public void end() {

    }
}
