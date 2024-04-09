import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameStatus game = setGameRuleOnLength();
        do {
            GameRule refree = new Refree(game);
            game.start();
            refree.play();
        } while (game.isRepeat());

    }

    public static GameStatus setGameRuleOnLength() {
        Scanner scanner = new Scanner(System.in);

        return new Game( scanner, 3);
    }
}