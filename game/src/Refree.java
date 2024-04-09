import java.util.*;

public class Refree implements GameRule{

    private static int gameRuleLength;
    private static Scanner scanner;

    public Refree(GameStatus game) {
        setRule(game);
        scanner = game.getScanner();
    }

    private List<Ball> compareTo(Player pitcher, Player hitter) {

        List<Ball> ballList = new ArrayList<>();

        String[] pitNumber = pitcher.getCreatedNumber();
        String[] hitNumber = hitter.getCreatedNumber();

        for (int i = 0; i <= gameRuleLength - 1; i++) {
            for (int j = 0; j <= gameRuleLength - 1; j++) {
                boolean judgementStrike = hitNumber[i].equals(pitNumber[j]) && i == j;
                boolean judgementBall = hitNumber[i].equals(pitNumber[j]) && i != j;

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

    private boolean isOut(List<Ball> result) {

        int strikeCnt = (int) result.stream().filter(c -> c.equals(Ball.STRIKE)).count();
        int ballCnt = (int) result.stream().filter(c -> c.equals(Ball.BALL)).count();

        printResult(strikeCnt, ballCnt);

        return result.size() == strikeCnt;

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

        System.out.println(strBuilder + "\n");
    }

    @Override
    public void play() {
        List<Ball> result;

        Player pitcher = new Pitcher(getRule());
        Player hitter = new Hitter(getRule(),scanner);
        do {
            hitter.createNumberArray();
            result = compareTo(pitcher, hitter);
        } while (!isOut(result));
    }

    @Override
    public void setRule(GameStatus rule) {
        gameRuleLength = rule.getGameRuleLength();
    }

    @Override
    public int getRule() {
        return gameRuleLength;
    }

}
