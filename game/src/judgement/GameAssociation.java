package judgement;

import game.Game;
import ground.HitAble;
import ground.Hitter;
import ground.PitchAble;
import ground.Pitcher;

public class GameAssociation implements GameRule{

    private final String gameRuleLength;

    public GameAssociation(String gameRuleLength) {
        this.gameRuleLength = gameRuleLength;
    }
    @Override
    public Game declareRule() {

        PitchAble pitcher = new Pitcher(gameRuleLength);
        HitAble hitter = new Hitter(gameRuleLength);
        JudgeMent referee = new Referee(gameRuleLength);

        return new Game(pitcher,hitter,referee);
    }
}
