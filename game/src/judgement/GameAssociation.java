package judgement;

import game.GameStatus;

public class GameAssociation implements GameRule{

    private final int gameRuleLength;

    public GameAssociation(int gameRuleLength) {
        this.gameRuleLength = gameRuleLength;
    }
    @Override
    public int getRule() {
        return gameRuleLength;
    }
}
