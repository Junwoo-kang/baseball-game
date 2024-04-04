package judgement;

import game.Game;
import player.Hitter;
import player.Pitcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Refree {

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
            if (ballList.size() != (i+1)) {
                ballList.add(Ball.NOTHING);
            }
        }

        return ballList;
    }

    public boolean isOut(List<Ball> result) {

        int strikeCnt = (int) result.stream().filter(c-> c.equals(Ball.STRIKE)).count();
        int ballCnt = (int) result.stream().filter(c-> c.equals(Ball.BALL)).count();

        printResult(strikeCnt, ballCnt);

        return result.size() == strikeCnt;

    }

    public void printResult(int strikeCnt, int ballCnt) {
        StringBuilder stBuilder = new StringBuilder();

        if (strikeCnt == 0 && ballCnt == 0) {
            stBuilder.append("낫싱");
        }
        if (ballCnt != 0) {
            stBuilder.append(ballCnt).append("볼");
        }
        if (strikeCnt != 0) {
            stBuilder.append(strikeCnt).append("스트라이크");
        }

        System.out.println(stBuilder+"\n");
    }

    public void play(Game game, Pitcher pitcher) {
        List<Ball> result;
        do {
            Hitter hitter = new Hitter(game.getScanner());
            result = compareTo(pitcher, hitter);
        } while (!isOut(result));

        game.isRepeat();

    }



}
