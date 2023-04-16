package CompanyHCM;
public class Main {
    public static void main(String[] args) {
        Employers employers = new Employers("db.txt");
        Menu menu = new Menu(employers);
        menu.start();
    }
}
