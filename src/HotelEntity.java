import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class HotelEntity {
    private Long id;

    // Геттеры и сеттеры для id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
