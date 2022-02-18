import java.util.List;

@FunctionalInterface
public interface Sort {
    List<Cadet> sort(List<Cadet> cadets);
}
