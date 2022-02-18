import java.time.LocalDate;
import java.util.Objects;

public class Cadet {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private Double gpa;
    private int group;

    public Cadet() {
    }

    public Cadet(String name, String lastName, LocalDate dateOfBirth, Double gpa, int group) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gpa = gpa;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cadet)) return false;
        Cadet cadet = (Cadet) o;
        return getGroup() == cadet.getGroup() &&
                Objects.equals(getName(), cadet.getName()) &&
                Objects.equals(getLastName(), cadet.getLastName()) &&
                Objects.equals(getDateOfBirth(), cadet.getDateOfBirth()) &&
                Objects.equals(getGpa(), cadet.getGpa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getDateOfBirth(), getGpa(), getGroup());
    }

    @Override
    public String toString() {
        return "Cadet{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gpa=" + gpa +
                ", group=" + group +
                '}';
    }
}
