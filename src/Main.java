



 class Main {
     static void main(String[] args) {

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
