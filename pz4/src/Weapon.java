import java.io.Serializable;
import java.util.Objects;

public class Weapon implements Serializable {
    private String name;
    private Double caliber;
    private int rounds;
    private int firingRange;

    public Weapon() {
    }

    public Weapon(String name, Double caliber, int rounds, int firingRange) {
        this.name = name;
        this.caliber = caliber;
        this.rounds = rounds;
        this.firingRange = firingRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCaliber() {
        return caliber;
    }

    public void setCaliber(Double caliber) {
        this.caliber = caliber;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getFiringRange() {
        return firingRange;
    }

    public void setFiringRange(int firingRange) {
        this.firingRange = firingRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return getRounds() == weapon.getRounds() &&
                getFiringRange() == weapon.getFiringRange() &&
                Objects.equals(getName(), weapon.getName()) &&
                Objects.equals(getCaliber(), weapon.getCaliber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCaliber(), getRounds(), getFiringRange());
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", caliber=" + caliber +
                ", rounds=" + rounds +
                ", firingRange=" + firingRange;
    }
}
