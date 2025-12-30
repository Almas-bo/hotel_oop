public class Booking {
    String id;
    int nights;

    Booking(String i, int n) {
        id = i;
        nights = n;
    }

    void show() {
        System.out.println("Booking id: " + id);
        System.out.println("Nights: " + nights);
    }
}
