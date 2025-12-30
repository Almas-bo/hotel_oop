class Guest {
    private String name;
    private int points;
    private String email;

    public Guest(String name, int points, String email) {
        this.name = name;
        this.points = points;
        this.email = email;
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
        return email.hashCode();
    }

    public void show() {
        System.out.println("Гость: " + name + " | Email: " + email +
                " | Баллы: " + points + " | Статус: " + getStatus());
    }
}
