package judgement;

import java.util.Arrays;

public enum GameOption {

    CONTINUE("1"),
    EXIT("2");

//    문자열 저장 필드
    private final String value;

//    생성자
    GameOption(String value) { this.value = value; }

    public String  getValue() { return value; }

    public static boolean isContinue(String option) {
        return GameOption.CONTINUE.getValue().equals(option);
    }

    public static GameOption findAnyValuebyInput(String input) {
        return Arrays.stream(values())
                .filter(gameOption -> gameOption.value.equals(input))
                .findAny()
                .orElse(null);
    }


//    public static String  findValueByInput(String input) {
//        for(GameOption gameOption : GameOption.values()) {
//            if (gameOption.value.equals(input)) {
//                return gameOption.value;
//            }
//        }
//        return null;
//    }
}

