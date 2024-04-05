import java.util.Scanner;

public class Game implements GameStatus {

    private static boolean GameStart;
    private static Scanner scanner;
    private static int gameRuleLength;

    private void getRepeat(String repeat) {
        if ("1".equals(repeat)) {
            start();
        } else end();
    }

    private void validInput(String input) {

        if (input.length() > gameRuleLength || input.isEmpty()) {
            String message = String.format("숫자는 %d개 이하여야 합니다.",gameRuleLength);
            throw new IllegalArgumentException(message);
        }
    }

    public Game( Scanner scanner, int gameRuleLength){
        Game.scanner = scanner;
        Game.gameRuleLength = gameRuleLength;
    }
    @Override
    public boolean isRepeat(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

        String repeat = scanner.next();
        validInput(repeat);
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
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public int getGameRuleLength() {
        return Game.gameRuleLength;
    }

}
