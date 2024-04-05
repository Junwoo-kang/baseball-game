import java.util.Scanner;

public class Hitter implements InputValue {

    public String[] HitNumber;
    private Scanner scanner;

    public Hitter(int rule,Scanner scanner) {
        this.HitNumber = new String[rule];
        this.scanner = scanner;
    }

    public void validInput(String input) {

        if (input.length() != 3) {
            String message = "숫자는 3개 이하여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public void create() {
        create(scanner);
    }

    @Override
    public String[] getcreatedNumber() {
        return HitNumber;
    }

    private void create(Scanner scanner) {
        System.out.print("숫자를 입력해주세요: ");
        String tryNumber = scanner.next();
        validInput(tryNumber);
        this.HitNumber = tryNumber.split("");
    }
}
