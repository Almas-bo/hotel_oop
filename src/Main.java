class Main {
   public static void main(String[] args) {
      Hotel hotel = new Hotel("Мой отель");

      // + комнаты
      hotel.addRoom(new Room(101, "Стандарт", false, 100));
      hotel.addRoom(new Room(102, "Люкс", false, 200));
      hotel.addRoom(new Room(103, "Стандарт", true, 100));
      hotel.addRoom(new Room(104, "Люкс", false, 200));
      hotel.addRoom(new Room(105, "Сюит", false, 300));

      // + гости
      Guest g1 = new Guest("Алмас", 150, "almas@email.com");
      Guest g2 = new Guest("Айда", 75, "aida@email.com");
      Guest g3 = new Guest("Бахыт", 200, "bakyt@email.com");

      hotel.addGuest(g1);
      hotel.addGuest(g2);
      hotel.addGuest(g3);

      // + бронирования
      hotel.addBooking(new Booking("B001", g1, new Room(101, "Стандарт", false, 100), 3));
      hotel.addBooking(new Booking("B002", g2, new Room(102, "Люкс", false, 200), 2));
      hotel.addBooking(new Booking("B003", g3, new Room(105, "Сюит", false, 300), 5));

      // данные
      hotel.showAllRooms();
      hotel.showAllGuests();
      hotel.showAllBookings();

      // Фильтрация
      hotel.showFreeRooms();

      // Сортировка
      hotel.showRoomsSorted();
      hotel.showGuestsSorted();

      // Поиск
      System.out.println("\n==== ПОИСК ====");
      Guest found = hotel.findGuest("Алмас");
      if (found != null) {
         System.out.println("Найден: " + found);
      }

      Booking foundBooking = hotel.findBooking("B001");
      if (foundBooking != null) {
         System.out.println("Найдено: " + foundBooking);
      }

      // Equals проверка
      System.out.println("\n==== EQUALS ====");
      Guest g4 = new Guest("Новый", 100, "almas@email.com");
      System.out.println("g1 и g4 - один человек? " + g1.equals(g4));
   }
}