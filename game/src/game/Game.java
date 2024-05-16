package game;

import ground.HitAble;
import ground.PitchAble;
import judgement.GameOption;
import judgement.JudgeMent;

import java.util.Optional;
import java.util.Scanner;

public class Game implements GameStatus {

    private final Scanner scanner;
    private final PitchAble pitcher;
    private final HitAble hitter;
    private final JudgeMent referee;

    public Game(PitchAble pitcher, HitAble hitter, JudgeMent referee) {
        scanner    = new Scanner(System.in);
        this.pitcher = pitcher;
        this.hitter = hitter;
        this.referee = referee;
    }

    private void gameRepeatAble(String input) {

//        String s = GameOption.findValueByInput(input);
        Optional<GameOption> gameOption = Optional.ofNullable(GameOption.findAnyValuebyInput(input));

        boolean validInput = gameOption.isEmpty();
        if (validInput) {
            String message = String.format(
                    "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요",
                    GameOption.CONTINUE.getValue(),
                    GameOption.EXIT.getValue()
            );
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public boolean isRepeat() {

        String message = String.format(
                "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요",
                GameOption.CONTINUE.getValue(),
                GameOption.EXIT.getValue()
        );
        System.out.println(message);

        String repeat = scanner.next();
        gameRepeatAble(repeat);

        return GameOption.isContinue(repeat);
    }

    @Override
    public void play() {

        String[] hitBall;
        String[] thrownBall = pitcher.pitch();

        do {
//            생성자를 통해 의존성 주입
            hitBall = hitter.hit();
        } while(!referee.isOut(thrownBall, hitBall));

//        아래처럼 작성할 수 있으나 가독성이 좋지 않음.
//        while(!referee.isOut(thrownBall, hitter.hit()));
    }
}
