package player;

public class Pitcher implements ThrowBall {

    public String[] randomScore = new String[3];

    public Pitcher() {
        StringBuilder randomNum = new StringBuilder();
        String[] randomScore = new String[3];
        String number;
        int pitch = 3;
        int i = 0;
        while (i < pitch) {
            number = String.valueOf((int) (Math.random() * 9) + 1);
            if (randomNum.indexOf(number) == -1) {
                randomNum.append(number);
                randomScore[i] = number;
                i++;
            }
        }
        this.randomScore = randomScore;
    }

}
