package player;

import judgement.ValidInput;
import judgement.ValidInputFactory;

import java.util.Scanner;

public class Hitter implements Player {

    public String[] HitNumber;
    private final Scanner scanner;
    private final ValidInput validInput = new ValidInputFactory();

    public Hitter(int ruleLength,Scanner scanner) {
        this.HitNumber = new String[ruleLength];
        this.scanner = scanner;
    }

    @Override
    public void createNumberArray() {

        System.out.print("숫자를 입력해주세요: ");
        String inputNumber = scanner.next();
        validInput.validInput(HitNumber.length,inputNumber);
        this.HitNumber = inputNumber.split("");
    }

    @Override
    public String[] getCreatedNumber() {
        return HitNumber;
    }


}
