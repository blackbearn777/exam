import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Human implements Serializable {

    private static final long serialVersionUID = 7829136421241571165L;

    private Double height;
    private Double weight;
    private int age;
    private String sex;
    transient private String nation;

    public Human() {
        super();
    }

    public Human(Double height, Double weight, int age, String sex, String nation) {
        super();
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.nation = nation;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(getHeight(), human.getHeight()) &&
                Objects.equals(getWeight(), human.getWeight()) &&
                Objects.equals(getSex(), human.getSex()) &&
                Objects.equals(getNation(), human.getNation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWeight(), getAge(), getSex(), getNation());
    }

    @Override
    public String toString() {
        return "Human{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(height);
        out.writeDouble(weight);
        out.writeInt(age);
        out.writeUTF(sex);
        out.writeUTF(nation);
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();

        height = in.readDouble();
        weight = in.readDouble();
        age = in.readInt();
        sex = in.readUTF();
        nation = in.readUTF();
    }
}
