package player;

import java.util.Scanner;

public class Hitter {

    public String[] HitNumber = new String[3];

    public Hitter(Scanner scanner){

        System.out.print("숫자를 입력해주세요: ");
        String tryNumber = scanner.next();
        validInput(tryNumber);
        this.HitNumber = tryNumber.split("");


    };

    public void validInput(String input) {

        if (input.length() != 3 ) {
            String message = "숫자는 3개 이하여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

}
