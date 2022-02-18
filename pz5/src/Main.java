import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Weapon weapon = new Weapon(
                new WeaponBuilder("Browning M2", 12.7f, 3000, 450)
        );
        Weapon weapon1 = new Weapon(
                new WeaponBuilder("AK-74", 5.45f, 1350, 600)
        );
        Weapon weapon2 = new Weapon(
                new WeaponBuilder("M16A4", 5.56f, 1500, 700)
        );
        Weapon weapon3 = new Weapon(
                new WeaponBuilder("H&K MP5", 9.0f, 400, 800)
        );
        Weapon weapon4 = new Weapon(
                new WeaponBuilder("H&K MP5", 9.0f, 400, 800)
        );

        TreeSet<Weapon> weaponTreeSet = new TreeSet<Weapon>(Weapon::compareTo);
        weaponTreeSet.add(weapon);
        weaponTreeSet.add(weapon1);
        weaponTreeSet.add(weapon2);
        weaponTreeSet.add(weapon3);
        weaponTreeSet.add(weapon4);//Цей запис не додасться до TreeSet, тому що rateOfFire=800 вже є у weapon3

        weaponTreeSet.stream().forEach(System.out::println);
        System.out.println(weaponTreeSet.size());
    }
}
