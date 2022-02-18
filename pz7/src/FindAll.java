import java.util.List;

@FunctionalInterface
public interface FindAll {
    List<Cadet> findAll(List<Cadet> cadets);
}
