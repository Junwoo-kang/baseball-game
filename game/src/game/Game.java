package game;

import java.util.Scanner;

public class Game implements GameStatus {

    public boolean GameStart;
    private Scanner scanner;

    public Game(Scanner scanner){
        this.scanner = scanner;
    }

    public void isRepeat(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

        String repeat = scanner.next();
        validInput(repeat);
        getRepeat(repeat);
    }

    private void getRepeat(String repeat) {
        if "1".equals(repeat) ? start() : end();
//        if ("1".equals(repeat)) {
//            start();
//        } else end();
    }

    private void validInput(String input) {

        if (input.length() > 3 || input.isEmpty()) {
            String message = "숫자는 3개 이하여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    public boolean start() {
        return this.GameStart = true;
    }

    public boolean end() {
        return this.GameStart = false;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

}
