public class Guest {
    String name;
    int points;

    Guest(String n, int p) {
        name = n;
        points = p;
    }

    void show() {
        System.out.println("Guest: " + name);
        if (points > 100) {
            System.out.println("VIP guest");
        } else {
            System.out.println("Normal guest");
        }
    }
}
