package game;

import judgement.*;
import ground.PitchAble;
import ground.Hitter;
import ground.Pitcher;
import ground.HitAble;

import java.util.Scanner;

public class Game implements GameStatus {

    private final Scanner scanner;
    private final PitchAble pitcher;
    private final HitAble hitter;
    private final JudgeMent referee;

    public Game(GameRule gameRule) {
        this.scanner    = new Scanner(System.in);
//            생성자를 통한 의존성 주입.
        this.pitcher    = new Pitcher(gameRule);
        this.hitter     = new Hitter(gameRule, scanner);
        this.referee    = new Referee(gameRule);
    }

    private void gameRepeatAble(String input) {

//        String s = GameOption.findValueByInput(input);
        GameOption gameOption = GameOption.findAnyValuebyInput(input);

        boolean validInput = (gameOption == null);
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
