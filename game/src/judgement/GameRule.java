package judgement;

public interface GameRule {
    int getRule();

    Ball throwBallRule(String hitBall, String throwBall,int i, int j);

    void setGameRule();
}
