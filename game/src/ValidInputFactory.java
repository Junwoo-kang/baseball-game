import java.util.Optional;

public class ValidInputFactory implements ValidInput {

    @Override
    public void validInput(String[] rule, String input) {
        String message;
        boolean validInput = (input.length() == rule.length);
        try {
            if (validInput) {
                Integer.parseInt(input);
            }else
                throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            message = "입력은 숫자로 해주세요";
            throw new IllegalArgumentException(message);
        } catch (IllegalArgumentException e) {
            message = "숫자는 3개 이하여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public void validInput(String input) {

        boolean validInput = (input.equals("1") || input.equals("2"));

        if (!validInput) {
            String message = "숫자는 1이거나 2여야만 합니다.";
            throw new IllegalArgumentException(message);
        }
    }
}
