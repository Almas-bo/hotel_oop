class Room {
    private int number;
    private String type;
    private boolean occupied;
    private double price;

    public Room(int number, String type, boolean occupied, double price) {
        this.number = number;
        this.type = type;
        this.occupied = occupied;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public double getPrice() {
        return price;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Room #" + number + " (" + type + ") - $" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Room)) return false;
        Room room = (Room) o;
        return number == room.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public void show() {
        System.out.println("Номер: " + number + " | Тип: " + type +
                " | Статус: " + (occupied ? "ЗАНЯТА" : "СВОБОДНА") + " | Цена: $" + price);
    }
}