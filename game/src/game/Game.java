package game;

import judgement.ValidInput;
import judgement.ValidInputFactory;

import java.util.Scanner;

public class Game implements GameStatus {

    private static Boolean isPlaying;
    private static Scanner scanner;
    private static int gameRuleLength;
    private final ValidInput validInput = new ValidInputFactory();
    private void getRepeat(String repeat) {
        boolean repeatAble = (repeat.equals("1"));

        if (repeatAble) {
            start();
        } else end();
    }

    public Game( Scanner scanner, int gameRuleLength){
        Game.scanner = scanner;
        Game.gameRuleLength = gameRuleLength;
    }
    @Override
    public boolean isRepeat(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String repeat = scanner.next();
        validInput.validInput(repeat);

        getRepeat(repeat);

        return isPlaying;
    }

    @Override
    public boolean start() {
        return isPlaying = true;
    }

    @Override
    public boolean end() {
        return isPlaying = false;
    }

    @Override
    public Scanner getScanner()  {
        return scanner;
    }

    @Override
    public int getGameRuleLength() {
        return Game.gameRuleLength;
    }

}
