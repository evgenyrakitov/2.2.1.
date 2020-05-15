package hiber.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "series")
    private String series;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Car() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeries() {
        return series;
    }



    public Car(String name, String series) {
        this.name = name;
        this.series = series;

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeries(String series) {
        this.series = series;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) &&
                Objects.equals(getSeries(), car.getSeries());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSeries());
    }
}
