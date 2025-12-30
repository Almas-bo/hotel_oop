public class Room {
    int number;
    String type;
    boolean occupied;

    Room(int n, String t, boolean o) {
        number = n;
        type = t;
        occupied = o;
    }

    void show() {
        System.out.println("Room " + number + " type: " + type);
        if (occupied) {
            System.out.println("Status: occupied");
        } else {
            System.out.println("Status: free");
        }
    }
}
