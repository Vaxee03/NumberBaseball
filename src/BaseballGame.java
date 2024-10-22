import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {

        Set<Integer> resultNumCreate = new HashSet<>();
        Random random = new Random();

        // 정답 숫자 생성
        while (resultNumCreate.size() < 3) {
            resultNumCreate.add(random.nextInt(9) + 1);
        }

        // 정답 숫자 섞기
        ArrayList<Integer> resultNum = new ArrayList<>(resultNumCreate);
        Collections.shuffle(resultNum);

    }

    public int play() {
        while (true) {
            // 1. 유저에게 입력값을 받음
            // 2. 올바른 입력값을 받았는지 검증
            // 3. 게임 진행횟수 증가
            // 4. 스트라이크 개수 계산
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            // 6. 볼 개수 계산
            // 7. 힌트 출력
        }
        // 게임 진행횟수 반환
    }

    protected boolean validateInput(String input) {

    }

    private int countStrike(String input) {

    }

    private int countBall(String input) {

    }
}
