import java.util.*;

public class Refree implements GameRule{

    private static int gameRuleLength;
    private static Scanner scanner;

    public Refree(GameStatus game) {
        gameRuleLength = setRule(game);
        scanner = game.getScanner();
    }

    private List<Ball> compareTo(InputValue pitcher, InputValue hitter) {

        List<Ball> ballList = new ArrayList<>();

        String[] hit = hitter.getcreatedNumber();
        String[] pit = pitcher.getcreatedNumber();

        for (int i = 0; i <= hit.length - 1; i++) {
            for (int j = 0; j <= hit.length - 1; j++) {
                if (hit[i].equals(pit[j]) && i == j) {
                    ballList.add(Ball.STRIKE);
                } else if (hit[i].equals(pit[j]) && i != j) {
                    ballList.add(Ball.BALL);
                }
            }
            if (ballList.size() != (i + 1)) {
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

        System.out.println(stBuilder + "\n");
    }

    @Override
    public void play() {
        List<Ball> result;

        InputValue pitcher = new Pitcher(getRule());
        InputValue hitter = new Hitter(getRule(),scanner);
        do {
            hitter.create();
            result = compareTo(pitcher, hitter);
        } while (!isOut(result));
    }

    @Override
    public int setRule(GameStatus rule) {
        return rule.getGameRuleLength();
    }

    @Override
    public int getRule() {
        return gameRuleLength;
    }

}
