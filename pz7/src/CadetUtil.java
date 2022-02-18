import java.util.List;

public class CadetUtil{

    public static List<Cadet> findAll(FindAll findAll, List<Cadet> cadets) {
        return findAll.findAll(cadets);
        //return cadets.stream().filter(c->c.getGpa()>4.0).collect(Collectors.toList());
    }

    public static void forEach(ForEach forEach, List<Cadet> cadets) {
        forEach.forEach(cadets);
        //cadets.stream().forEach(System.out::println);
    }

    public static List<Cadet> sort(Sort sort, List<Cadet> cadets) {
        return sort.sort(cadets);
        //return cadets.stream().sorted(Comparator.comparing(Cadet::getDateOfBirth))
        //        .collect(Collectors.toList());
    }
}
