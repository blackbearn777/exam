import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {
    private static final long serialVersionUID = 7829136001241571165L;

    private Double height;
    private Double weight;
    private int age;
    private String sex;
    transient private String breed;

    public Animal() {
    }

    public Animal(Double height, Double weight, int age, String sex, String breed) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.breed = breed;
    }


    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getAge() == animal.getAge() &&
                Objects.equals(getHeight(), animal.getHeight()) &&
                Objects.equals(getWeight(), animal.getWeight()) &&
                Objects.equals(getSex(), animal.getSex()) &&
                Objects.equals(getBreed(), animal.getBreed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWeight(), getAge(), getSex(), getBreed());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }


}
