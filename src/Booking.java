class Booking extends HotelEntity {
    private String bookingId;
    private Guest guest;
    private Room room;
    private int nights;

    public Booking(String bookingId, Guest guest, Room room, int nights) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.nights = nights;
        this.id = "BOOKING_" + bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalPrice() {
        return room.getPrice() * nights;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Booking #" + bookingId + " | Guest: " + guest.getName() +
                " | Room: " + room.getNumber() + " | Nights: " + nights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return bookingId.equals(booking.bookingId);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (char c : bookingId.toCharArray()) {
            result = result * 31 + c;
        }
        return result;
    }

    @Override
    public void display() {
        System.out.println("Бронирование #" + bookingId + " | Гость: " + guest.getName() +
                " | Комната: " + room.getNumber() + " | Ночей: " + nights +
                " | Сумма: $" + getTotalPrice());
    }
}