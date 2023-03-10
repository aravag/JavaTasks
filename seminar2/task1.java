package seminar2;
public class task1 {
    public static void main(String[] args) {
        System.out.println(alternateChars(5, 'a', 'b'));
        ;
    }
    public static String alternateChars(int length, char char1, char char2) {
        String result = "" + char1;
        for (int i = 1; i < length; i++) {
            if (result.charAt(i - 1) == char1) {
                result += char2;
            }
            else {
                result += char1;
            }
        }
        return result;
    }
}
