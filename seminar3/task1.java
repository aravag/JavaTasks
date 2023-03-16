package seminar3;
import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(31, 43, 32, 53, 16, 56, 23, 14, 22, 24, 63, 84, 34));
        System.out.println(list);
        deleteNumbers(list);
        System.out.println(list);
    }

    public static void deleteNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.removeIf(element -> element % 2 != 0);
        }
    }
}