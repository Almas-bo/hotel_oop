import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;


class Main {


   private static final String db_user = "almas";
   private static final String db_password = "0000";
   private static final String db_url = "jdbc:postgresql://localhost:5432/hotel_reservation_system";


   public static void main(String[] args) throws SQLException{
      boolean cycle = true;
      Scanner scanner = new Scanner(System.in);

      while (cycle==true){
         boolean answer = true;
         System.out.println("Have you been registered before? (yes/no)");
         String regis = scanner.nextLine(); //это уже сам ответ, да или нет


         if (regis.equalsIgnoreCase("yes")){
             answer = true;
             cycle = false;
         }
         else if (regis.equalsIgnoreCase("no")){
             answer = false;
             cycle = false;
         }
         else {
            System.out.println("wrong response, try again");
         }
      }



      try {
         Class.forName("org.postgresql.Driver");

         Connection connection = DriverManager.getConnection(db_url, db_user, db_password);

      } catch (ClassNotFoundException e) {
         System.out.println("Ошибка: драйвер не найден.");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("Ошибка подключения к базе данных.");
         e.printStackTrace();
      }

      while (true){
         System.out.println("1. Зарегестрироваться");
         System.out.println("2. Показать список номеров");
         System.out.println("3. Изменить данные пользователя");
         System.out.println("4. Выйти");

         int command = scanner.nextInt();

         if (command == 1 ){
            if (answer == true){
               System.out.println("you are already registered!");
            }
            else if(answer == false){
               System.out.println("enter your name: ");
               String name = scanner.nextLine();

               System.out.println("enter your guest points: ");
               int points = scanner.nextLine();

               System.out.println("enter your email: ");
               String email = scanner.nextLine();



               Statement statement = connection.createStatement(); // Это чтобы уже с бд связываться
               String sql_tasks = "insert into guest (name,points,email) values (?, ?, ?);";
               PreparedStatement preparedStatement = connection.prepareStatement(sql_tasks);
               preparedStatement.setString(1, name);
               preparedStatement.setInt(2, points);
               preparedStatement.setString(3, email);
               int update = preparedStatement.executeUpdate();
            }

         }

      }


//      Hotel hotel = new Hotel("Grand Hotel");
//      // +комнаты
//      hotel.addRoom(new Room(101, "Стандарт", false, 100));
//      hotel.addRoom(new Room(102, "Люкс", false, 200));
//      hotel.addRoom(new Room(103, "Стандарт", true, 100));
//      hotel.addRoom(new Room(104, "Люкс", false, 200));
//      hotel.addRoom(new Room(105, "Сюит", false, 300));
//
//      // +гостей
//      Guest g1 = new Guest("Алмас", 150, "almas@email.com");
//      Guest g2 = new Guest("Айда", 75, "aida@email.com");
//      Guest g3 = new Guest("Бахыт", 200, "bakyt@email.com");
//
//      hotel.addGuest(g1);
//      hotel.addGuest(g2);
//      hotel.addGuest(g3);
//
//      // +бронирования
//      hotel.addBooking(new Booking("B001", g1, new Room(101, "Стандарт", false, 100), 3));
//      hotel.addBooking(new Booking("B002", g2, new Room(102, "Люкс", false, 200), 2));
//      hotel.addBooking(new Booking("B003", g3, new Room(105, "Сюит", false, 300), 5));
//
//      // ВЫВОД ВСЕХ ДАННЫХ
//      hotel.showAllRooms();
//      hotel.showAllGuests();
//      hotel.showAllBookings();
//
//      // ФИЛЬТРАЦИЯ
//      hotel.showFreeRooms();
//      hotel.showVIPGuests();
//
//      // СОРТИРОВКА
//      hotel.showRoomsSorted();
//      hotel.showGuestsSorted();
//      hotel.showBookingsSorted();
//
//      // ПОИСК
//      System.out.println("\n==== ПОИСК ====");
//      Guest found = hotel.findGuest("Алмас");
//      if (found != null) {
//         System.out.println("Найден: " + found);
//      }
//
//      Booking foundBooking = hotel.findBooking("B001");
//      if (foundBooking != null) {
//         System.out.println("Найдено: " + foundBooking);
//      }

      //System.out.println("\n==== EQUALS И HASHCODE ====");
      //Guest g4 = new Guest("Новый", 100, "almas@email.com");
      //System.out.println("g1 и g4 - один человек? " + g1.equals(g4));
      //System.out.println("g1.hashCode() == g4.hashCode(): " + (g1.hashCode() == g4.hashCode()));

      //Room r1 = new Room(101, "Стандарт", false, 100);
      //Room r2 = new Room(101, "Люкс", true, 150);
      //System.out.println("r1 и r2 - одна комната? " + r1.equals(r2));
      //System.out.println("r1.hashCode() == r2.hashCode(): " + (r1.hashCode() == r2.hashCode()));
   }
}