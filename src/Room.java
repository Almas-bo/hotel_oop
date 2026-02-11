import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room extends HotelEntity {  // Наследуем от HotelEntity
    @Id
    private Long roomId;  // Уникальный идентификатор комнаты
    private String roomType;  // Тип комнаты (например, одноместная, двухместная)
    private double pricePerNight;  // Цена за ночь
    private String status;  // Статус комнаты: свободна или занята

    // Геттеры и сеттеры для всех полей
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
