import java.util.Arrays;

public class Pitcher implements Player {

    public String[] randomScore;


    public Pitcher(int rule) {
        this.randomScore = new String[rule];
        createNumberArray();
    }

    @Override
    public void createNumberArray() {
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
            System.out.println(number);
        }


    }

    @Override
    public String[] getCreatedNumber() {
        return randomScore;
    }

}
