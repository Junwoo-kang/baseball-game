package judgement;

import game.GameStatus;

public interface GameRule {

    void play();

    void setRule(GameStatus game);

    int getRule();
}
