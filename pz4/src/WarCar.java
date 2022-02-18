import java.io.Serializable;
import java.util.Objects;

public class WarCar extends Car implements Serializable {
    private static final long serialVersionUID = 7829136421241571165L;

    private Weapon weapon;

    public WarCar() {
    }

    public WarCar(Double engineVolume, int countOfSeats, String developer, Weapon weapon) {
        super(engineVolume, countOfSeats, developer);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarCar)) return false;
        if (!super.equals(o)) return false;
        WarCar warCar = (WarCar) o;
        return Objects.equals(getWeapon(), warCar.getWeapon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeapon());
    }

    @Override
    public String toString() {
        return "WarCar{\n\t" +
                "weapon=[" + weapon + "]\n\t" +
                "car=[" + super.toString() + "]\n\t}\n";
    }
}
