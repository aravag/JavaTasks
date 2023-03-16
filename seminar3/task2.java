package seminar3;
import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("string", "s", "5", "10", "-12", "my_value"));
        deleteNumbers(list);
        System.out.println(list);
    }
    public static void deleteNumbers(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.removeIf(element -> {
                try {
                    Integer.parseInt(element);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            });
        }
    }
}