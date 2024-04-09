import java.util.Scanner;

public class Game implements GameStatus {

    private static boolean GameStart;
    private static Scanner scanner;
    private static int gameRuleLength;
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
        new ValidInputFactory().validInput(repeat);

        getRepeat(repeat);

        return GameStart;
    }

    @Override
    public boolean start() {
        return GameStart = true;
    }

    @Override
    public boolean end() {
        return GameStart = false;
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
