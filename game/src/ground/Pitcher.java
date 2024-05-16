package ground;

public class Pitcher implements PitchAble {

    private static String[] randomScore;
    public Pitcher(String gameRule) {
        randomScore = new String[Integer.parseInt(gameRule)];
    }

    @Override
    public String[] pitch() {
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
        return randomScore;
    }

}
