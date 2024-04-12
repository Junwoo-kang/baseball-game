package judgement;

import player.NumberProducer;

import java.util.List;

public interface JudgeMent {
    public List<Ball> compareTo(NumberProducer pitcher, NumberProducer hitter);
    public boolean isOut(List<Ball> result);
}
