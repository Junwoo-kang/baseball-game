package ground;

import java.util.Scanner;

public class Hitter implements HitAble {

    private String[] HitNumber;
    private final Scanner scanner;
    public Hitter(String  gameRule) {
        this.HitNumber =new String[Integer.parseInt(gameRule)];

        this.scanner = new Scanner(System.in);
    }

    @Override
    public String[] hit() {

        System.out.print("숫자를 입력해주세요: ");
        String inputNumber = scanner.next();
        hitAble(HitNumber.length,inputNumber);

        this.HitNumber = inputNumber.split("");
        return HitNumber;
    }

    private void hitAble(int ruleLength, String input) {

        String message;
        boolean validInput = (input.length() == ruleLength);
        try {
            if (validInput) {
                Integer.parseInt(input);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            message = "입력은 숫자로 해주세요";
            throw new IllegalArgumentException(message);
        } catch (IllegalArgumentException e) {
            message = "숫자는 "+ruleLength+"개여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

}

