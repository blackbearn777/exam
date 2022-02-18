import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private Double engineVolume;
    private int countOfSeats;
    private String developer;

    public Car() {
    }

    public Car(Double engineVolume, int countOfSeats, String developer) {
        this.engineVolume = engineVolume;
        this.countOfSeats = countOfSeats;
        this.developer = developer;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCountOfSeats() == car.getCountOfSeats() &&
                Objects.equals(getEngineVolume(), car.getEngineVolume()) &&
                Objects.equals(getDeveloper(), car.getDeveloper());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngineVolume(), getCountOfSeats(), getDeveloper());
    }

    @Override
    public String toString() {
        return  "engineVolume=" + engineVolume +
                ", countOfSeats=" + countOfSeats +
                ", developer='" + developer;
    }
}
