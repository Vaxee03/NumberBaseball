import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    Set<Integer> resultNum = new LinkedHashSet<>();
    Random random = new Random();
    int gameCount = 0;


    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {

        while (resultNum.size() < 3) {
            resultNum.add(random.nextInt(9) + 1);
        }
    }

    // 게임 진행
    public int play() {
        while (true) {
            // 1. 유저에게 입력값을 받음
            System.out.print("숫자를 입력하세요 : ");
            String num = sc.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if (!validateInput(num)) {
                System.out.println("잘못된 입력입니다. 다시 시도해주십시오.");
                continue;
            }

            // 3. 게임 진행횟수 증가
            gameCount++;

            // 4. 스트라이크 개수 계산
            int strike = countStrike(num);

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strike == 3) {
                break;
            }

            // 6. 볼 개수 계산
            int ball = countBall(num);

            // 7. 힌트 출력
            System.out.println("틀렸습니다! "+num+"은 "+strike+"Strike, "+ball+"Ball 입니다!");
        }
        // 게임 진행횟수 반환
        return gameCount;
    }

    protected boolean validateInput(String input) {
        if (input.length() != 3) return false;
        return input.chars().distinct().count() == 3;
    }

    // 스트라이크 개수 계산
    private int countStrike(String input) {
        int strike = 0;

        List<Integer> answerList = new ArrayList<>(resultNum);

        for (int i = 0; i < 3; i++) {
            if (Character.getNumericValue(input.charAt(i)) == answerList.get(i)){
                strike++;
            }
        }
        return strike;
    }


    private int countBall(String input) {
        int ball = 0;

        List<Integer> answerList = new ArrayList<>(resultNum);

        for (int i = 0; i < 3; i++) {
            int checkBall = Character.getNumericValue(input.charAt(i));

            for (int j = 0; j < 3; j++) {
                if (i != j && checkBall == answerList.get(j)) {
                    ball++;
                    break;
                }
            }
        }
        return ball;

    }
}