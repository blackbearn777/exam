import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<BulletproofVest> bulletproofVestList = new ArrayList<>(
                Arrays.asList(
                        new BulletproofVest(ProtectionLevel.II, 3.2, OutcoverMaterial.NYLON, false, 0.6),
                        new BulletproofVest(ProtectionLevel.IIA, 1.5, OutcoverMaterial.NYLON, false, 0.9),
                        new BulletproofVest(ProtectionLevel.IIA, 3.5, OutcoverMaterial.CORDURA, true, 1.6),
                        new BulletproofVest(ProtectionLevel.IV, 8.2, OutcoverMaterial.POLYESTER, true, 1.4),
                        new BulletproofVest(ProtectionLevel.IV, 9.9, OutcoverMaterial.NYLON, true, 1.6)
                )
        );

        List<BulletproofVest> lightBulletproofVests = bulletproofVestList.stream().filter(BulletproofVest::isLightWeight)
                .filter(bulletproofVest -> bulletproofVest.isMolleSystem())
                .collect(Collectors.toList());

        long corduraVests = bulletproofVestList.stream()
                .filter(bulletproofVest -> bulletproofVest.getOutcoverMaterial().equals(OutcoverMaterial.CORDURA))
                .count();

        bulletproofVestList.stream().forEach(System.out::println);
        System.out.println("\n-----------------------Lightweight bulletproof vests--------------------\n");
        lightBulletproofVests.stream().forEach(System.out::println);
        System.out.println("\n--------------------------Count of CORDURA-vests------------------------\n");
        System.out.println(corduraVests);
        System.out.println("\n------------------------Sorted by bulletproofArea-----------------------\n");
        bulletproofVestList.stream()
                .sorted((b1, b2) -> b2.getBulletproofArea().compareTo(b1.getBulletproofArea()))
                .forEach(System.out::println);

    }
}
