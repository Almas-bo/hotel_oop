// Bekenov Almas SE-2506

class Room {
    private int roomNumber;
    private String type; // Standard, Deluxe, Suite
    private double pricePerNight;
    private boolean isOccupied;

    public Room(int roomNumber, String type, double pricePerNight, boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isOccupied = isOccupied;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public boolean isOccupied() { return isOccupied; }

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
    private String fullName;
    private String email;
    private int loyaltyPoints;

    public Guest(String fullName, String email, int loyaltyPoints) {
        this.fullName = fullName;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getFullName() { return fullName; }

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
    private String bookingId;
    private int nights;
    private double totalPrice;

    public Booking(String bookingId, int nights, double totalPrice) {
        this.bookingId = bookingId;
        this.nights = nights;
        this.totalPrice = totalPrice;
    }

    public String getBookingId() { return bookingId; }

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
        // Тестируем Room
        Room r1 = new Room(101, "Deluxe", 150.0, false);
        Room r2 = new Room(205, "Suite", 300.0, true);

        r1.Info();
        r2.Info();
        r1.checkAvailability();

        System.out.println();

        // Тестируем Guest
        Guest g1 = new Guest("Ivan Ivanov", "ivan@mail.com", 150);
        Guest g2 = new Guest("Aliya S.", "aliya@mail.com", 50);

        g1.Info();
        g2.Info();
        g1.checkVIPStatus();

        System.out.println();

        // Тестируем Booking
        Booking b1 = new Booking("BK-9921", 3, 450.0);
        Booking b2 = new Booking("BK-1104", 5, 1200.0);

        b1.Info();
        b2.Info();
        b2.checkBookingValue();
    }
}