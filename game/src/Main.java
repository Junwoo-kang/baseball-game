import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("정답은"+ Arrays.toString(randomScore));

        while (true) {

            String tryNumber = scanner.next();
            System.out.println(tryNumber);
            String[] mobNumber = tryNumber.split("");

            int BALL=0;
            int STRIKE = 0;
            boolean NOTHING;
            for (int t = 0; t <= tryNumber.length()-1; t++) {
                for (int u = 0; u <= tryNumber.length()-1; u++) {
                    if (mobNumber[t].equals(randomScore[u]))  {
                        if (t == u) {
                            STRIKE++;
                        } else if (t != u) {
                            BALL++;
                        }
                    }
                }
            }

            if (BALL + STRIKE == 0) {
                System.out.println("낫싱");
            } else if (STRIKE == 3) {
                break;
            } else {
                System.out.println(BALL + "볼" + STRIKE + "스트라이크");
            }


        }
    }



}