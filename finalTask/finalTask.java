package finalTask;
public class finalTask {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Иван", "Иванов", 25, 'М', "Программист"),
                new Person("Мария", "Петрова", 18, 'Ж', "Студентка"),
                new Person("Петр", "Сидоров", 30, 'М', "Учитель"),
                new Person("Анна", "Смирнова", 22, 'Ж', "Графический дизайнер"),
                new Person("Дмитрий", "Кузнецов", 19, 'М', "Студент")
        };
        System.out.println("-------------------------------------------------");
        for (Person person : people) {
            if (person.getAge() > 20) {
                System.out.println(person);
            }
        }
        System.out.println("-------------------------------------------------");
        int randomIndex = (int) (Math.random() * people.length);
        Person randomPerson = people[randomIndex];
        Person.happyBirthday(randomPerson);
        System.out.println("-------------------------------------------------");
    }
}
