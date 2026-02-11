public class Room extends HotelEntity {
    private String roomId;
    private String roomType;
    private double pricePerNight;
    private String status;

    public Room(String roomId, String roomType, double pricePerNight, String status) {
        this.roomId = roomId;
        this.id = roomId;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
        this.id = roomId;
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

    public boolean isOccupied() {
        return "занята".equalsIgnoreCase(status);
    }

    public String getType() {
        return roomType;
    }

    public double getPrice() {
        return pricePerNight;
    }

    @Override
    public void display() {
        System.out.println("Комната: " + roomId + " | Тип: " + roomType +
                " | Цена: " + pricePerNight + " | Статус: " + status);
    }
}
