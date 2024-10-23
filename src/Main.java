import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 인스턴트 화
        Scanner sc = new Scanner(System.in);
        BaseballGame baseball = new BaseballGame();
        List<Integer> scoreboard = new ArrayList<>();

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력하여주세요!");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int start = sc.nextInt();
            if (start == 1) {
                int gameCount = baseball.play();
                System.out.println("정답입니다! 당신은 " + gameCount + " 회 만에 정답을 맞추셨습니다!");
                System.out.println("─────────────────────────────────────────────────────────");
                scoreboard.add(gameCount);
            } else if (start == 2) {
                for (int i = 0; i < scoreboard.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + scoreboard.get(i));
                }
                System.out.println("─────────────────────────────────────────────────────────");
            } else {
                System.out.println("게임이 종료되었습니다!");
                break;
            }
        }
    }
}

