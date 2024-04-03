package judgement;

import player.Hitter;
import player.Pitcher;

public class Refree {


    public Ball compareTo(Pitcher pitcher, Hitter hitter) {

        Ball ballobj = new Ball();

        String[] hit = hitter.HitNumber;
        String[] pit = pitcher.randomScore;

        for (int i = 0; i <= hitter.HitNumber.length; i++) {
            for (int j = 0; j <= hitter.HitNumber.length; j++) {
                if (hit[i].equals(pit[j])) {
                    ballobj.STRIKE++;
                } else if (i != j) {
                    ballobj.BALL++;
                }
            }
        }

        return ballobj;
    }

}
