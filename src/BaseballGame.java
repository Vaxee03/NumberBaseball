import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    Set<Integer> resultNum = new LinkedHashSet<>();
    Random random = new Random();
    int gameCount = 0;
    private int numCount;


    // 객체 생성시 정답을 만들도록 함
    public BaseballGame(int numCount) {

        this.numCount = numCount;
        createAnswer();
    }

    // 정답 생성 메서드
    public void createAnswer() {
        resultNum.clear();
        while (resultNum.size() < numCount) {
            resultNum.add(random.nextInt(9) + 1);
        }
    }


    // 게임 진행
    public int play() {

        // 0. 게임 시작 세팅
        gameCount = 0;
        createAnswer();
        System.out.println("게임을 시작합니다!");

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
            if (strike == numCount) {
                break;
            }

            // 6. 볼 개수 계산
            int ball = countBall(num);

            // 7. 힌트 출력
            System.out.println("틀렸습니다! "+num+"은 "+strike+"Strike, "+ball+"Ball 입니다!");
            System.out.println("");
        }
        // 게임 진행횟수 반환
        return gameCount;
    }

    protected boolean validateInput(String num) {
        if (num.length() != numCount) return false;
        return num.chars().distinct().count() == numCount;
    }

    // 스트라이크 개수 계산
    private int countStrike(String input) {
        int strike = 0;

        List<Integer> answerList = new ArrayList<>(resultNum);

        for (int i = 0; i < numCount; i++) {
            if (Character.getNumericValue(input.charAt(i)) == answerList.get(i)){
                strike++;
            }
        }
        return strike;
    }


    private int countBall(String input) {
        int ball = 0;

        List<Integer> answerList = new ArrayList<>(resultNum);

        for (int i = 0; i < numCount; i++) {
            int checkBall = Character.getNumericValue(input.charAt(i));

            for (int j = 0; j < numCount; j++) {
                if (i != j && checkBall == answerList.get(j)) {
                    ball++;
                    break;
                }
            }
        }
        return ball;
    }
}