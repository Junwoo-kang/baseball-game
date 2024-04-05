import java.util.Scanner;

public class Pitcher implements InputValue{

    public String[] randomScore;


    public Pitcher(int rule) {
        this.randomScore = new String[rule];
        create();
    }

    @Override
    public void create() {
        StringBuilder randomNum = new StringBuilder();
        String number;
        int pitch = randomScore.length;
        int i = 0;
        while (i < pitch) {
            number = String.valueOf((int) (Math.random() * 9) + 1);
            if (randomNum.indexOf(number) == -1) {
                randomNum.append(number);
                randomScore[i] = number;
                i++;
            }
        }

    }

    @Override
    public String[] getcreatedNumber() {
        return randomScore;
    }

}
