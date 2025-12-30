class Booking {
    private String id;
    private Guest guest;
    private Room room;
    private int nights;

    public Booking(String id, Guest guest, Room room, int nights) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.nights = nights;
    }

    public String getId() {
        return id;
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
    public String toString() {
        return "Booking #" + id + " | Guest: " + guest.getName() +
                " | Room: " + room.getNumber() + " | Nights: " + nights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void show() {
        System.out.println("Бронирование #" + id + " | Гость: " + guest.getName() +
                " | Комната: " + room.getNumber() + " | Ночей: " + nights +
                " | Сумма: $" + getTotalPrice());
    }
}
