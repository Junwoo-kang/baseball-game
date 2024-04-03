package player;

import java.util.Scanner;

public class Hitter {

    public String[] HitNumber = new String[3];

    public Hitter(Scanner scanner){


        System.out.println("숫자를 입력해주세요: ");
        String tryNumber = scanner.next();
        this.HitNumber = tryNumber.split("");


    };


}
