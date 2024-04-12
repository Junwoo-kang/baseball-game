package game;

import judgement.*;
import player.Hitter;
import player.Pitcher;
import player.NumberProducer;
import valid.ValidInput;
import valid.ValidInputFactory;

import java.util.List;
import java.util.Scanner;

public class Game implements GameStatus {

    private static Boolean isPlaying;
    private final GameRule gameRule;
    private final Scanner scanner;
    private final ValidInput validInput = new ValidInputFactory();
    public Game(GameRule gameRule) {
        this.gameRule = gameRule;
        this.scanner = new Scanner(System.in);
    }

    private void getRepeat(String repeat) {
        if (GameOption.CONTINUE.isContinue(repeat)) {
            start();
        } else end();
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

        getRepeat(repeat);

        return isPlaying;
    }

    //    게임시작
    @Override
    public void start() {
        isPlaying = true;
    }
    @Override
    public void end() {
        isPlaying = false;
    }

    public void play() {
        start();
        List<Ball> result;

        NumberProducer pitcher = new Pitcher(gameRule);
        NumberProducer hitter = new Hitter(gameRule, scanner);
        JudgeMent referee = new Referee(gameRule);
        do {
            hitter.createNumberArray();
            result = referee.compareTo(pitcher, hitter);
        } while (!referee.isOut(result) && isPlaying);

        /**     out     playing result
         *      false   true    true
         *      true    true    false
         *
         *      false   false   false
         *      true    false   false
         */

    }


}
