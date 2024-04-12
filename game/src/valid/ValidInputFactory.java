package valid;

import game.Game;
import judgement.GameAssociation;
import judgement.GameOption;

public class ValidInputFactory implements ValidInput {

    @Override
    public void hitAble(int ruleLength, String input) {

        String message;
        boolean validInput = (input.length() == ruleLength);
        try {
            if (validInput) {
                Integer.parseInt(input);
            }else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            message = "입력은 숫자로 해주세요";
            throw new IllegalArgumentException(message);
        } catch (IllegalArgumentException e) {
            message = "숫자는 3개 이하여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public void gameRepeatAble(String input) {

//        String s = GameOption.findValueByInput(input);
        GameOption gameOption = GameOption.findAnyValuebyInput(input);

        boolean validInput = (gameOption == null);
        if (validInput) {
            String message = String.format(
                    "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요",
                    GameOption.CONTINUE.getValue(),
                    GameOption.EXIT.getValue()
            );
            throw new IllegalArgumentException(message);
        }
    }

}