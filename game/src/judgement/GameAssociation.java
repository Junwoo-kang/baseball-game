package judgement;

import ground.HitAble;
import ground.Hitter;
import ground.PitchAble;
import ground.Pitcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameAssociation implements GameRule{

    private final String gameRuleLength;



    public GameAssociation(String gameRuleLength) {
        this.gameRuleLength = gameRuleLength;
    }
    @Override
    public int getRule() {
        return Integer.parseInt(gameRuleLength);
    }

//  스트라이크 / 볼 / 낫싱 규칙 지정
    @Override
    public Ball throwBallRule(String hitBall, String throwBall,int i, int j) {
//        스트라이크/볼/낫싱/아웃에 대한 규칙을 알려줘야함.
//
        if (hitBall.equals(throwBall) && i == j) {
            return Ball.STRIKE;
        }else if(hitBall.equals(throwBall) && i != j) {
            return Ball.BALL;
        }
        return Ball.NOTHING;
    }

    @Override
    public void setGameRule() {
//<규칙>
//- 낫싱: 입력한 숫자가 존재하지 않을 경우
//- 스트라이크: 입력한 숫자가 있고 위치가 일치할 경우
//- 볼: 입력한 숫자가 있지만 위치가 다른 경우
//- 아웃: 입력한 3자리 숫자와 정답이 같은 경우
//- 잘못된 값을 입력하면 IllegalArgumentException 예외가 발생하며
//          프로그램이 종료된다.

        int pitch;
        String strike;


    }
}
