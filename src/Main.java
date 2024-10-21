import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> resultNumCreate = new HashSet<>();
        Random random = new Random();

        while (resultNumCreate.size() < 3) {
            resultNumCreate.add(random.nextInt(9) + 1);
        }

        ArrayList<Integer> resultNum = new ArrayList<>(resultNumCreate);
        Collections.shuffle(resultNum);
        System.out.println("선택된 번호는 " + resultNum + " 입니다.");
    }
}
