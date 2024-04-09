import java.util.Scanner;

public class Hitter implements Player {

    public String[] HitNumber;
    private Scanner scanner;

    public Hitter(int rule,Scanner scanner) {
        this.HitNumber = new String[rule];
        this.scanner = scanner;
    }

    @Override
    public void createNumberArray() {
        createNumberArray(scanner);
    }

    @Override
    public String[] getCreatedNumber() {
        return HitNumber;
    }

    private void createNumberArray(Scanner scanner) {
        System.out.print("숫자를 입력해주세요: ");
        String inputNumber = scanner.next();
        new ValidInputFactory().validInput(HitNumber,inputNumber);
        this.HitNumber = inputNumber.split("");
    }
}
