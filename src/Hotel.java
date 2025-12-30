class Hotel {
    private String name;
    private Room[] rooms;
    private Guest[] guests;
    private Booking[] bookings;
    private int roomCount = 0;
    private int guestCount = 0;
    private int bookingCount = 0;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new Room[20];
        this.guests = new Guest[20];
        this.bookings = new Booking[20];
    }

    public void addRoom(Room room) {
        if (roomCount < rooms.length) {
            rooms[roomCount++] = room;
        }
    }

    public void addGuest(Guest guest) {
        if (guestCount < guests.length) {
            guests[guestCount++] = guest;
        }
    }

    public void addBooking(Booking booking) {
        if (bookingCount < bookings.length) {
            bookings[bookingCount++] = booking;
        }
    }

    public Room[] getFreeRooms() {
        Room[] free = new Room[roomCount];
        int count = 0;
        for (int i = 0; i < roomCount; i++) {
            if (!rooms[i].isOccupied()) {
                free[count++] = rooms[i];
            }
        }
        Room[] result = new Room[count];
        System.arraycopy(free, 0, result, 0, count);
        return result;
    }

    public Room[] getRoomsByType(String type) {
        Room[] temp = new Room[roomCount];
        int count = 0;
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getType().equals(type)) {
                temp[count++] = rooms[i];
            }
        }
        Room[] result = new Room[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    public Guest[] getVIPGuests() {
        Guest[] temp = new Guest[guestCount];
        int count = 0;
        for (int i = 0; i < guestCount; i++) {
            if (guests[i].getPoints() > 100) {
                temp[count++] = guests[i];
            }
        }
        Guest[] result = new Guest[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    public Guest findGuest(String name) {
        for (int i = 0; i < guestCount; i++) {
            if (guests[i].getName().equals(name)) {
                return guests[i];
            }
        }
        return null;
    }

    public Booking findBooking(String id) {
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i].getBookingId().equals(id)) {
                return bookings[i];
            }
        }
        return null;
    }

    public Room[] sortRoomsByPrice() {
        Room[] sorted = new Room[roomCount];
        System.arraycopy(rooms, 0, sorted, 0, roomCount);

        for (int i = 0; i < roomCount; i++) {
            for (int j = i + 1; j < roomCount; j++) {
                if (sorted[i].getPrice() > sorted[j].getPrice()) {
                    Room temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public Guest[] sortGuestsByPoints() {
        Guest[] sorted = new Guest[guestCount];
        System.arraycopy(guests, 0, sorted, 0, guestCount);

        for (int i = 0; i < guestCount; i++) {
            for (int j = i + 1; j < guestCount; j++) {
                if (sorted[i].getPoints() < sorted[j].getPoints()) {
                    Guest temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public Booking[] sortBookingsByPrice() {
        Booking[] sorted = new Booking[bookingCount];
        System.arraycopy(bookings, 0, sorted, 0, bookingCount);

        for (int i = 0; i < bookingCount; i++) {
            for (int j = i + 1; j < bookingCount; j++) {
                if (sorted[i].getTotalPrice() > sorted[j].getTotalPrice()) {
                    Booking temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public void showAllRooms() {
        System.out.println("\n==== ВСЕ КОМНАТЫ ====");
        for (int i = 0; i < roomCount; i++) {
            rooms[i].display();
        }
    }

    public void showAllGuests() {
        System.out.println("\n==== ВСЕ ГОСТИ ====");
        for (int i = 0; i < guestCount; i++) {
            guests[i].display();
        }
    }

    public void showAllBookings() {
        System.out.println("\n==== ВСЕ БРОНИРОВАНИЯ ====");
        for (int i = 0; i < bookingCount; i++) {
            bookings[i].display();
        }
    }

    public void showFreeRooms() {
        System.out.println("\n==== СВОБОДНЫЕ КОМНАТЫ ====");
        Room[] free = getFreeRooms();
        if (free.length == 0) {
            System.out.println("Нет свободных комнат");
        } else {
            for (Room room : free) {
                room.display();
            }
        }
    }

    public void showVIPGuests() {
        System.out.println("\n==== VIP ГОСТИ ====");
        Guest[] vip = getVIPGuests();
        if (vip.length == 0) {
            System.out.println("Нет VIP гостей");
        } else {
            for (Guest guest : vip) {
                guest.display();
            }
        }
    }

    public void showRoomsSorted() {
        System.out.println("\n==== КОМНАТЫ ПО ЦЕНЕ ====");
        Room[] sorted = sortRoomsByPrice();
        for (int i = 0; i < roomCount; i++) {
            sorted[i].display();
        }
    }

    public void showGuestsSorted() {
        System.out.println("\n==== ГОСТИ ПО БАЛЛАМ (VIP первыми) ====");
        Guest[] sorted = sortGuestsByPoints();
        for (int i = 0; i < guestCount; i++) {
            sorted[i].display();
        }
    }

    public void showBookingsSorted() {
        System.out.println("\n==== БРОНИРОВАНИЯ ПО СУММЕ ====");
        Booking[] sorted = sortBookingsByPrice();
        for (int i = 0; i < bookingCount; i++) {
            sorted[i].display();
        }
    }
}
