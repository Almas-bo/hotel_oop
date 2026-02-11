# 🏨 Hotel Reservation System - REST API

REST API для системы бронирования отелей (Hotel Reservation System)

## 📋 Описание проекта

Веб-сервис для управления отелем с возможностью:
- Управления комнатами (Room)
- Управления гостями (Guest)
- Создания и управления бронированиями (Booking)

## 🛠 Технологии

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**

## 📦 Структура проекта

```
hotel-api/
├── src/
│   └── main/
│       ├── java/com/hotel/api/
│       │   ├── entity/          # JPA сущности (Guest, Room, Booking)
│       │   ├── repository/      # Spring Data репозитории
│       │   ├── service/         # Бизнес-логика
│       │   ├── controller/      # REST контроллеры
│       │   └── HotelReservationApiApplication.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

## ⚙️ Установка и запуск

### 1. Требования
- Java 17+
- Maven 3.6+
- PostgreSQL 12+

### 2. Настройка базы данных

Создайте базу данных PostgreSQL:
```sql
CREATE DATABASE hotel_reservation_system;
```

Убедитесь, что существуют таблицы:
```sql
CREATE TABLE guest (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    points INTEGER DEFAULT 0
);

CREATE TABLE room (
    room_id SERIAL PRIMARY KEY,
    room_number INTEGER UNIQUE,
    room_type VARCHAR(50),
    is_booked BOOLEAN DEFAULT false,
    price DECIMAL(10,2)
);

CREATE TABLE booking (
    booking_id SERIAL PRIMARY KEY,
    guest_id INTEGER REFERENCES guest(id),
    room_id INTEGER REFERENCES room(room_id),
    nights INTEGER,
    total_price DECIMAL(10,2)
);
```

### 3. Настройка приложения

Отредактируйте `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_reservation_system
spring.datasource.username=almas
spring.datasource.password=0000
```

### 4. Запуск приложения

```bash
cd hotel-api
mvn clean install
mvn spring-boot:run
```

Приложение будет доступно по адресу: **http://localhost:8080**

## 🌐 API Endpoints

### Guest (Гости)
- `GET /api/guests` - Получить всех гостей
- `GET /api/guests/{id}` - Получить гостя по ID
- `POST /api/guests` - Создать нового гостя
- `PUT /api/guests/{id}` - Обновить данные гостя
- `DELETE /api/guests/{id}` - Удалить гостя

### Room (Комнаты)
- `GET /api/rooms` - Получить все комнаты
- `GET /api/rooms/{id}` - Получить комнату по ID
- `GET /api/rooms/free` - Получить свободные комнаты
- `POST /api/rooms` - Создать новую комнату
- `PUT /api/rooms/{id}` - Обновить комнату
- `DELETE /api/rooms/{id}` - Удалить комнату

### Booking (Бронирования)
- `GET /api/bookings` - Получить все бронирования
- `GET /api/bookings/{id}` - Получить бронирование по ID
- `POST /api/bookings` - Создать новое бронирование
- `DELETE /api/bookings/{id}` - Отменить бронирование

## 📝 Примеры запросов

### Создать гостя (POST /api/guests)
```json
{
  "name": "Алмас",
  "email": "almas@email.com",
  "points": 150
}
```

### Создать комнату (POST /api/rooms)
```json
{
  "roomNumber": 101,
  "roomType": "Стандарт",
  "price": 100.00,
  "isBooked": false
}
```

### Создать бронирование (POST /api/bookings)
```json
{
  "guestId": 1,
  "roomId": 1,
  "nights": 3
}
```

## 👨‍💻 Автор

Almas - [GitHub](https://github.com/yourusername)

## 📄 Лицензия

Учебный проект
