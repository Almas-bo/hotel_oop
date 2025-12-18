class Room {
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

class Guest {
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

class Booking {
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

public class Main {
    public static void main(String[] args) {

        Room r = new Room(101, "Deluxe", false);
        r.show();

        System.out.println();

        Guest g = new Guest("Almas", 120);
        g.show();

        System.out.println();

        Booking b = new Booking("B1", 3);
        b.show();
    }
}
