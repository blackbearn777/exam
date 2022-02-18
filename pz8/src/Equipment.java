import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Equipment {
    private String title;
    private int size;
    private int countOfItems;
    private Double cost;

    public static List<Equipment> uniqueElements(List<Equipment> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<Equipment> sizedList(List<Equipment> list, int size){
        return list.stream().filter(eq->eq.getSize()>size).collect(Collectors.toList());
    }

    public Equipment() {
    }

    public Equipment(String title, int size, int countOfItems, Double cost) {
        this.title = title;
        this.size = size;
        this.countOfItems = countOfItems;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCountOfItems() {
        return countOfItems;
    }

    public void setCountOfItems(int countOfItems) {
        this.countOfItems = countOfItems;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return getSize() == equipment.getSize() &&
                getCountOfItems() == equipment.getCountOfItems() &&
                Objects.equals(getTitle(), equipment.getTitle()) &&
                Objects.equals(getCost(), equipment.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSize(), getCountOfItems(), getCost());
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "title='" + title + '\'' +
                ", size=" + size +
                ", countOfItems=" + countOfItems +
                ", cost=" + cost +
                '}';
    }
}
