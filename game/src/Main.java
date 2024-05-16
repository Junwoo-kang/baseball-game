import game.GameStatus;
import judgement.GameAssociation;
import judgement.GameRule;

public class Main {

    public static void main(String[] args) {
        GameRule gameAssociation = gameInit();
        GameStatus game = gameAssociation.declareRule();
        do {
            game.play();
        } while (game.isRepeat());

    }

    public static GameRule gameInit() {
        String  gameRuleLength = "3";

        return new GameAssociation(gameRuleLength);
    }
}