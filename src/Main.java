import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


class Main {


   private static final String db_user = "almas";
   private static final String db_password = "0000";
   private static final String db_url = "jdbc:postgresql://localhost:5432/hotel_reservation_system";


   public static void main(String[] args) throws SQLException{
      boolean cycle = true;
      boolean answer = true;

      Scanner scanner = new Scanner(System.in);

      while (cycle==true){
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


      Connection connection = null;



      try {
         Class.forName("org.postgresql.Driver");

         connection = DriverManager.getConnection(db_url, db_user, db_password);

      } catch (ClassNotFoundException e) {
         System.out.println("Ошибка: драйвер не найден.");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("Ошибка подключения к базе данных.");
         e.printStackTrace();
      }

      while (true){
         System.out.println("1. Register");
         System.out.println("2. show all rooms list");;
         System.out.println("3. Change user's info");
         System.out.println("4. Delete user");
         System.out.println("5. Add room");
         System.out.println("6. Delete room");
         System.out.println("7. Open website (link)");
         System.out.println("8. Exit");

         int command = scanner.nextInt();

         if (command == 1 ){
            if (answer == true){
               System.out.println("you are already registered!");
            }
            else if(answer == false){
               scanner.nextLine();

               System.out.println("enter your name: ");
               String name = scanner.nextLine();

               System.out.println("enter your guest points: ");
               int points = scanner.nextInt();
               scanner.nextLine();

               System.out.println("enter your email: ");
               String email = scanner.nextLine();

               answer = true;

               Statement statement = connection.createStatement(); // Это чтобы уже с бд связываться
               String sql_tasks = "INSERT INTO guest (name, points, email) VALUES (?, ?, ?)";
               try (PreparedStatement preparedStatement = connection.prepareStatement(sql_tasks, Statement.RETURN_GENERATED_KEYS)) {
                  preparedStatement.setString(1, name);
                  preparedStatement.setInt(2, points);
                  preparedStatement.setString(3, email);

                  int update = preparedStatement.executeUpdate();


                  ResultSet resultSet = preparedStatement.getGeneratedKeys();
                  if (resultSet.next()) {
                     int userId = resultSet.getInt(1);
                     System.out.println("Registration successful! Your ID is: " + userId);
                  }
               } catch (SQLException e) {
                  e.printStackTrace();
               }

//               String sql_tasks = "insert into guest (name,points,email) values (?, ?, ?);";
//               PreparedStatement preparedStatement = connection.prepareStatement(sql_tasks);
//               preparedStatement.setString(1, name);
//               preparedStatement.setInt(2, points);
//               preparedStatement.setString(3, email);
//               int update = preparedStatement.executeUpdate();
//               ResultSet resultSet = preparedStatement.executeQuery();
//               int userId = resultSet.getInt("id");
//               System.out.println("Registration successful! Your ID is: " + userId);
            }

         }

         if (command == 2){
            Statement statement = connection.createStatement();
            String sql_select = "select * from room order by room_number asc";
            ResultSet result = statement.executeQuery(sql_select);

            while (result.next()){
               boolean isBooked = result.getBoolean("is_booked");
               String status = isBooked ? "occupied" : "free";
               System.out.println(result.getInt("room_number")
                          + " " + result.getString("room_type")
                          + " " + status
                          + " " + result.getInt("price"));
            }

         }
         if (command == 3) {
            System.out.println("Enter your ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("What do you want to change?\n1. Name \n2. Email");
            int change = scanner.nextInt();
            scanner.nextLine();

            if (change == 1) {
               System.out.println("Enter your new name: ");
               String newName = scanner.nextLine();

               String sql_name = "UPDATE guest SET name = ? WHERE id = ?";

               try (PreparedStatement preparedStatement = connection.prepareStatement(sql_name)) {
                  preparedStatement.setString(1, newName);
                  preparedStatement.setInt(2, userId);

                  int updateCount = preparedStatement.executeUpdate();
                  if (updateCount > 0) {
                     System.out.println("Name updated successfully!");
                  } else {
                     System.out.println("No user found with the given ID.");
                  }
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            else if (change == 2) {
               System.out.println("Enter your new email: ");
               String newEmail = scanner.nextLine();

               String sql_email = "UPDATE guest SET email = ? WHERE id = ?";

               try (PreparedStatement preparedStatement = connection.prepareStatement(sql_email)) {
                  preparedStatement.setString(1, newEmail);
                  preparedStatement.setInt(2, userId);

                  int updateCount = preparedStatement.executeUpdate();
                  if (updateCount > 0) {
                     System.out.println("Email updated successfully!");
                  } else {
                     System.out.println("No user found with the given ID.");
                  }
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            else {
               System.out.println("wrong option.");
            }
         }

         if (command == 4) {
            System.out.println("Enter user ID to delete: ");
            int userId = scanner.nextInt();
            scanner.nextLine();

            String sql_delete = "DELETE FROM guest WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql_delete)) {
               preparedStatement.setInt(1, userId);

               int updateCount = preparedStatement.executeUpdate();
               if (updateCount > 0) {
                  System.out.println("User deleted successfully!");
               } else {
                  System.out.println("No user found with the given ID.");
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         if (command == 5) {
            System.out.println("Enter room number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter room type: ");
            String roomType = scanner.nextLine();

            System.out.println("Enter price: ");
            int price = scanner.nextInt();
            scanner.nextLine();

            String sql_add_room = "INSERT INTO room (room_number, room_type, is_booked, price) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql_add_room)) {
               preparedStatement.setInt(1, roomNumber);
               preparedStatement.setString(2, roomType);
               preparedStatement.setBoolean(3, false);
               preparedStatement.setInt(4, price);

               preparedStatement.executeUpdate();
               System.out.println("Room added successfully!");
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         if (command == 6) {
            System.out.println("Enter room number to delete: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();

            String sql_delete_room = "DELETE FROM room WHERE room_number = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql_delete_room)) {
               preparedStatement.setInt(1, roomNumber);

               int updateCount = preparedStatement.executeUpdate();
               if (updateCount > 0) {
                  System.out.println("Room deleted successfully!");
               } else {
                  System.out.println("No room found with the given number.");
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         if (command == 7) {
            System.out.println("Website link: http://localhost:8080");
            System.out.println("IMPORTANT: To make the website work, you must start the backend.");
            System.out.println("You can do this by running the 'hotel-api' Spring Boot application.");
         }

         if (command == 8) {
            System.out.println("Exiting...");
            break;
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