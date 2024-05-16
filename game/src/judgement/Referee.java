package judgement;

import java.util.ArrayList;
import java.util.List;

public class Referee implements JudgeMent{

    private static int gameRuleLength;
    private static Boolean isOut;

    public Referee(String  gameRule) {
        gameRuleLength = Integer.parseInt(gameRule);
    }

    /**
     * @param throwBall
     * @param hitBall
     * @return List<Ball>
     */
    private List<Ball> compareTo(String[] throwBall, String[] hitBall) {

        List<Ball> ballList = new ArrayList<>();

        for (int i = 0; i <= gameRuleLength - 1; i++) {
            for (int j = 0; j <= gameRuleLength- 1; j++) {
                boolean judgementStrike = hitBall[i].equals(throwBall[j]) && i == j;
                boolean judgementBall = hitBall[i].equals(throwBall[j]) && i != j;

                if (judgementStrike) {
                    ballList.add(Ball.STRIKE);
                } else if (judgementBall) {
                    ballList.add(Ball.BALL);
                }
            }

            boolean validBallList = ballList.size() != (i + 1);
            if (validBallList) {
                ballList.add(Ball.NOTHING);
            }
        }

        return ballList;
    }

    private void printResult(int strikeCnt, int ballCnt) {
        StringBuilder strBuilder = new StringBuilder();

        if (strikeCnt == 0 && ballCnt == 0) {
            strBuilder.append("낫싱");
        }
        if (ballCnt != 0) {
            strBuilder.append(ballCnt).append("볼");
        }
        if (strikeCnt != 0) {
            strBuilder.append(strikeCnt).append("스트라이크");
        }
        if (strikeCnt == 3) {
            strBuilder.append(strikeCnt).append("\n아웃! 게임 종료\n");
        }

        System.out.println(strBuilder);
    }
    //    게임의 시작과 종료 여부 판단
    @Override
    public boolean isOut(String[] throwBall, String[] hitBall) {
        List<Ball> result = compareTo(throwBall, hitBall);

        int strikeCnt = (int) result.stream().filter(Ball.STRIKE::equals).count();
        int ballCnt = (int) result.stream().filter(Ball.BALL::equals).count();

        printResult(strikeCnt, ballCnt);
        isOut = (result.size() == strikeCnt);
        return isOut;

    }

}
