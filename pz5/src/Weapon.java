import java.util.Objects;

public class Weapon implements Comparable{
    private final String name;
    private final float caliber;
    private final int fireRange;
    private final int rateOfFire;

    public Weapon() {
        caliber = 0;
        name = null;
        fireRange = 0;
        rateOfFire = 0;
    }

    public Weapon(WeaponBuilder builder) {
        this.name = builder.name;
        this.caliber = builder.caliber;
        this.fireRange = builder.fireRange;
        this.rateOfFire = builder.rateOfFire;
    }

    public String getName() {
        return name;
    }

    public float getCaliber() {
        return caliber;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return Float.compare(weapon.getCaliber(), getCaliber()) == 0 &&
                getFireRange() == weapon.getFireRange() &&
                getRateOfFire() == weapon.getRateOfFire() &&
                Objects.equals(getName(), weapon.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCaliber(), getFireRange(), getRateOfFire());
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", caliber=" + caliber +
                ", fireRange=" + fireRange +
                ", rateOfFire=" + rateOfFire +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Weapon weapon = (Weapon)o;
        return this.getRateOfFire()-weapon.getRateOfFire();
    }
}
