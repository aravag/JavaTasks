package seminar5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Есть тест. Нужно извлечь из него все слова и отсортировать по длине.
* Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись
*
* и
* ты
* Еще
* день друг Пора
* ..
*
*/

public class task {
    public static void main(String[] args) {
        collectStats("Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись");
    }
    
static void collectStats(String text) {
    Map<Integer, List<String>> stats = new HashMap<>();
    String[] textArr = text.split(" ");
    for (int i = 0; i < textArr.length; i++) {
        int tempLen = textArr[i].length();
        if (stats.containsKey(tempLen)) {
            stats.get(tempLen).add(textArr[i]);
        } else {
            List<String> tempList = new ArrayList<>();
            tempList.add(textArr[i]);
            stats.put(tempLen, tempList);
        }
    }
    System.out.println(stats);
}
}
