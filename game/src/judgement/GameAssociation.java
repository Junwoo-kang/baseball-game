package judgement;

import java.util.Arrays;

public class GameAssociation implements GameRule{

    private final String gameRuleLength;

    public GameAssociation(String gameRuleLength) {
        this.gameRuleLength = gameRuleLength;
    }
    @Override
    public int getRule() {
//        규칙이 바뀔 경우,
//        해당 메서드만 수정한다.
//        EX_소수일 때,
        if (gameRuleLength.contains(".")) {
            String[] a = gameRuleLength.split("\\.");
            String b = Arrays.toString(a);

            return Integer.parseInt(b.substring(1,2)+1);
        }

        return Integer.parseInt(gameRuleLength);
    }
}
