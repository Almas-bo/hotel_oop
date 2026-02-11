import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
class Booking extends HotelEntity {
    @Id
    private Long bookingId;  // Уникальный идентификатор бронирования
    private Long guestId;  // Идентификатор гостя
    private Long roomId;  // Идентификатор комнаты
    private Date checkInDate;  // Дата заезда
    private Date checkOutDate;  // Дата выезда
    private double totalPrice;  // Общая цена за бронирование

    // Геттеры и сеттеры
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
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
}