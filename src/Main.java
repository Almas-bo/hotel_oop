// Bekenov Almas SE-2506

class Room {
    private final int roomNumber;
    private final String type;
    private final double pricePerNight;
    private final boolean isOccupied;

    public Room(int roomNumber, String type, double pricePerNight, boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isOccupied = isOccupied;
    }

    public void checkAvailability() {
        if (isOccupied) {
            System.out.println("Room " + roomNumber + " is currently occupied.");
        } else {
            System.out.println("Room " + roomNumber + " is available for booking.");
        }
    }

    public void Info() {
        System.out.println("Room: #" + roomNumber + ", Type: " + type +
                ", Price: $" + pricePerNight + ", Occupied: " + isOccupied);
    }
}

class Guest {
    private final String fullName;
    private final String email;
    private final int loyaltyPoints;

    public Guest(String fullName, String email, int loyaltyPoints) {
        this.fullName = fullName;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    public void checkVIPStatus() {
        if (loyaltyPoints > 100) {
            System.out.println(fullName + " is a VIP Guest!");
        } else {
            System.out.println(fullName + " is a Regular Guest.");
        }
    }

    public void Info() {
        System.out.println("Guest: " + fullName + ", Email: " + email +
                ", Loyalty Points: " + loyaltyPoints);
    }
}

class Booking {
    private final String bookingId;
    private final int nights;
    private final double totalPrice;

    public Booking(String bookingId, int nights, double totalPrice) {
        this.bookingId = bookingId;
        this.nights = nights;
        this.totalPrice = totalPrice;
    }

    public void checkBookingValue() {
        if (totalPrice > 500) {
            System.out.println("Booking " + bookingId + " is a High-Value reservation.");
        } else {
            System.out.println("Booking " + bookingId + " is a standard reservation.");
        }
    }

    public void Info() {
        System.out.println("Booking ID: " + bookingId + ", Duration: " + nights +
                " nights, Total Price: $" + totalPrice);
    }
}

public class Main {
    public static void main(String[] args) {

        Room r1 = new Room(101, "Deluxe", 150.0, false);
        Room r2 = new Room(205, "Suite", 300.0, true);

        r1.info();
        r2.info();
        r1.checkAvailability();

        System.out.println();

        Guest g1 = new Guest("Almas Bekenov", "almasbekenov@gmail.com", 150);
        g1.info();
        g1.checkVIPStatus();

        System.out.println();

        Booking b1 = new Booking("BK-9921", 3, 450.0);
        b1.info();
        b1.checkBookingValue();
    }
}
