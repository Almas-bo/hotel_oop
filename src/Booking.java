import java.util.Date;

class Booking extends HotelEntity {
    private String bookingId;
    private String guestId;
    private String roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    public Booking(String bookingId, String guestId, String roomId, Date checkInDate, Date checkOutDate, double totalPrice) {
        this.bookingId = bookingId;
        this.id = bookingId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
        this.id = bookingId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public void display() {
        System.out.println("Бронирование: " + bookingId + " | Гость: " + guestId +
                " | Комната: " + roomId + " | Цена: " + totalPrice);
    }
}