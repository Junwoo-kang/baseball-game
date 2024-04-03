package judgement;

import player.Hitter;
import player.Pitcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Refree {

    boolean isContinue;

    public List<Ball> compareTo(Pitcher pitcher, Hitter hitter) {

        List<Ball> ballList=new ArrayList<>();

        String[] hit = hitter.HitNumber;
        String[] pit = pitcher.randomScore;


        for (int i = 0; i <= hitter.HitNumber.length-1; i++) {
            for (int j = 0; j <= hitter.HitNumber.length-1; j++) {
                if (hit[i].equals(pit[j]) && i == j) {
                    ballList.add(Ball.STRIKE);
                } else if (hit[i].equals(pit[j]) && i != j) {
                    ballList.add(Ball.BALL);
                }
            }
        }
        if (ballList.isEmpty()) {
            ballList.add(Ball.NOTHING);
        }

        return ballList;
    }



}
