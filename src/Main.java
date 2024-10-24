import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 인스턴트 화
        Scanner sc = new Scanner(System.in);
        List<Integer> scoreboard = new ArrayList<>();
        BaseballGame baseballGame = null;

        //게임 반복
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력하여주세요!");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String start = sc.nextLine();

            // 1. 시작 메뉴 입력값 검증
            // 1 - 1 : if문 검증
//            if (!checkMenuError(start)){
//                System.out.println("올바른 숫자를 입력해주세요!");
//                System.out.println("");
//                continue;
//            }

            // 1 - 2 : try - catch문 검증
            try {
                checkMenuError(start);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                System.out.println("");
                continue;
            }

            //  2. 난이도 설정
            if (start.equals("0")) {
                System.out.println("설정하고자 하는 자리수를 입력하세요!");
                String numCount = sc.nextLine();

                // 3. 난이도 설정 입력값 검증
                // 3 - 1 : if문 검증
//                if (!checkNumcountError(numCount)){
//                    System.out.println("올바른 숫자를 입력해주세요!");
//                    System.out.println();
//                }

                // 3 - 2 : try - count문 검증
                try {
                    checkNumcountError(numCount);
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                    System.out.println("");
                    continue;
                }

                // 3 - 3 : 검증 성공
                baseballGame = new BaseballGame(Integer.parseInt(numCount));
                System.out.println(numCount + "자리수 난이도로 설정되었습니다.");
                System.out.println();

            }

            // 4. 게임 시작
            else if (start.equals("1")) {
                if (baseballGame == null) {
                    baseballGame = new BaseballGame(3);
                    System.out.println("자리수를 3으로 자동 설정합니다!");
                }
                int gameCount = baseballGame.play();
                System.out.println("정답입니다! 당신은 " + gameCount + " 회 만에 정답을 맞추셨습니다!");
                System.out.println("─────────────────────────────────────────────────────────");
                scoreboard.add(gameCount);
            }

            // 5. 저장된 게임기록 출력
            else if (start.equals("2")) {
                if (scoreboard.isEmpty()) {
                    System.out.println("아직 저장된 기록이 없습니다.");
                    System.out.println("");
                    continue;
                }
                for (int i = 0; i < scoreboard.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + scoreboard.get(i));
                }
                System.out.println("─────────────────────────────────────────────────────────");
            }

            // 6. 게임 종료
            else if (start.equals("3")) {
                System.out.println("게임이 종료되었습니다!");
                break;
            }
        }
    }

    // 시작 메뉴 입력값 검증
    // 1 : if문 검증
//    protected static boolean checkMenuError(String start) {
//        return start.equals("0") || start.equals("1") || start.equals("2") || start.equals("3");
//    }

    // 2 : try - catch문 검증
    protected static void checkMenuError(String start) throws InvalidInputException {
        if (!start.equals("0") && !start.equals("1") && !start.equals("2") && !start.equals("3")) {
            throw new InvalidInputException("잘못된 입력입니다. 0 ~ 3 의 값을 입력하여 주십시오!");
        }
    }

    // 난이도 설정 입력값 검증
    // 1 : if문 검증
//    protected static boolean checkNumcountError(String count) {
//        return count.equals("3") || count.equals("4") || count.equals("5");
//    }

    // 2 : try - catch문 검증
    protected static void checkNumcountError(String count) throws InvalidInputException {
        if (!count.equals("3") && !count.equals("4") && !count.equals("5")) {
            throw new InvalidInputException("잘못된 입력입니다. 3 ~ 5 의 값을 입력하여 주십시오!");


        }
    }
}