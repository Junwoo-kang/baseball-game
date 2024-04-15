package game;

import judgement.*;
import ground.Destination;
import ground.Hitter;
import ground.Pitcher;
import ground.NumberProducer;
import valid.ValidInput;
import valid.ValidInputFactory;

import java.util.Scanner;

public class Game implements GameStatus {

    private final GameRule gameRule;
    private final Scanner scanner;
    private final ValidInput validInput = new ValidInputFactory();
    public Game(GameRule gameRule) {
        this.gameRule = gameRule;
        this.scanner = new Scanner(System.in);
    }

    private boolean getRepeat(String repeat) {
        if (GameOption.CONTINUE.isContinue(repeat)) {
            return true;
        }
        return false;
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
        validInput.gameRepeatAble(repeat);

        return getRepeat(repeat);
    }

    @Override
    public void play() {

        Destination pitcher = new Pitcher(gameRule);
        NumberProducer hitter = new Hitter(gameRule, scanner);
        JudgeMent referee = new Referee(gameRule);
        String[] hitBall;
        String[] thrownBall = pitcher.throwBall();

        do {
            hitBall = hitter.swing();
        } while(!referee.isOut(thrownBall, hitBall));
    }
}
