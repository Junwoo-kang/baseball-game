package ground;

import judgement.GameRule;
import valid.ValidInput;
import valid.ValidInputFactory;

import java.util.Scanner;

public class Hitter implements NumberProducer {

    private String[] HitNumber;
    private final Scanner scanner;
    private final ValidInput validInput = new ValidInputFactory();

    public Hitter(GameRule gameRule, Scanner scanner) {
        this.HitNumber = new String[gameRule.getRule()];
        this.scanner = scanner;
    }

    @Override
    public String[] swing() {

        System.out.print("숫자를 입력해주세요: ");
        String inputNumber = scanner.next();
        validInput.hitAble(HitNumber.length,inputNumber);

        this.HitNumber = inputNumber.split("");
        return HitNumber;
    }
}
