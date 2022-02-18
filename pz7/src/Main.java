import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Cadet> cadets = new ArrayList<>(Arrays.asList(
                new Cadet("Oleh", "Siryy", LocalDate.of(1999,10,4), 4.3, 161),
                new Cadet("Maksym", "Kryvonis", LocalDate.of(1999, 8,7), 4.1, 161),
                new Cadet("Petro", "Hrechka", LocalDate.of(1999, 1,12), 3.3, 261),
                new Cadet("Pavlo", "Neordynarnyy", LocalDate.of(1999, 5,4), 3.2, 261),
                new Cadet("Oleh", "Nevmytyy", LocalDate.of(1999, 1,31), 4.7, 361),
                new Cadet("Dmytro", "Lenin", LocalDate.of(1999, 12,22), 5.0, 362),
                new Cadet("Bob", "Stark", LocalDate.of(1999, 12,17), 4.7, 363),
                new Cadet("Yan", "Popad`ko", LocalDate.of(1999, 4,16), 4.9, 363)
        ));
        //виведення лише тих, у кого середній бал вище 4.0
        List<Cadet> cadets1 = CadetUtil.findAll(
                cs -> cs.stream().filter(c->c.getGpa()>4.0)
                        .collect(Collectors.toList()
                        ), cadets);
        cadets1.stream().forEach(System.out::println);
        System.out.println("\n------------------------------------------------------\n");

        //виведення всіх записів на екран
        CadetUtil.forEach(cs -> cs.stream().forEach(System.out::println), cadets);
        System.out.println("\n------------------------------------------------------\n");

        //виведення відсортованих за датою народження курсантів
        List<Cadet> cadets2 = CadetUtil.sort(
                cs -> cs.stream().sorted(Comparator.comparing(Cadet::getDateOfBirth))
                     .collect(Collectors.toList()), cadets);
        cadets2.stream().forEach(System.out::println);
    }
}
