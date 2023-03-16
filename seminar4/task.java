package seminar4;
import java.util.LinkedList;
import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите строку (text~num, print~num или exit): ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            String[] parts = input.split("~");
            if (parts.length == 2) {
                String text = parts[0];
                int num = Integer.parseInt(parts[1]);
                if (num < 0) {
                    System.out.println("Некорректный номер позиции.");
                } 
                else if (parts[0].equals("print")) {
                    if (num >= list.size()) {
                        System.out.println("Позиция " + num + " в списке не существует.");
                    } 
                    else {
                        System.out.println(list.get(num));
                    }
                } 
                else {
                    while (list.size() <= num) {
                        list.add(null);
                    }
                    list.set(num, text);
                }
            } 
            else {
                System.out.println("Некорректный ввод.");
            }
        }
        scanner.close();
    }
}
