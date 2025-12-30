class Guest extends HotelEntity {
    private String name;
    private int points;
    private String email;

    public Guest(String name, int points, String email) {
        this.name = name;
        this.points = points;
        this.email = email;
        this.id = "GUEST_" + email;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getEmail() {
        return email;
    }

    public void addPoints(int p) {
        this.points += p;
    }

    public String getStatus() {
        return points > 100 ? "VIP" : "Обычный";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (" + email + ") - Баллы: " + points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return email.equals(guest.email);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (char c : email.toCharArray()) {
            result = result * 31 + c;
        }
        return result;
    }

    @Override
    public void display() {
        System.out.println("Гость: " + name + " | Email: " + email +
                " | Баллы: " + points + " | Статус: " + getStatus());
    }
}