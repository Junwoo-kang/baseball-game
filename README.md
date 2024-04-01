# baseball-game
 
<설명>
- 숫자 야구 게임은 컴퓨터가 무작위로 3개의 서로 다른 숫자를 생성하고, 사용자가 그 숫자를 맞추는 게임이다.
- 사용자는 정답을 맞출 때까지 계속 정답을 입력할 수 있다.

<규칙>
- 낫싱: 입력한 숫자가 존재하지 않을 경우
- 스트라이크: 입력한 숫자가 있고 위치가 일치할 경우
- 볼: 입력한 숫자가 있지만 위치가 다른 경우
- 아웃: 입력한 3자리 숫자와 정답이 같은 경우
- 잘못된 값을 입력하면 IllegalArgumentException 예외가 발생하며 프로그램이 종료된다.

<진행 순서>
1. 게임을 시작하면 컴퓨터는 0에서 9 사이의 서로 다른 숫자 3개를 무작위로 생성한다.
2. 사용자는 3자리의 숫자를 입력한다.
3. 컴퓨터는 사용자의 입력에 대한 스트라이크와 볼 결과를 알려준다.
4. 사용자는 정답(3 스트라이크)을 맞출 때까지 3자리의 숫자를 입력한다.
5. 정답을 맞추면 게임 끝
6. 종료 후 1을 입력하면 게임을 재시작하고 2를 입력하면 프로그램 종료


<예시>
숫자 야구 게임을 시작합니다.

숫자를 입력해주세요.
123
1볼 1스트라이크

숫자를 입력해주세요.
456
1볼

숫자를 입력해주세요.
789
낫싱

숫자를 입력해주세요.
513
아웃! 게임 종료

게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
2

Process finished with exit code 0