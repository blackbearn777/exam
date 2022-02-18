import java.net.http.WebSocket;

public class WeaponBuilder{
    public static String name;
    public static float caliber;
    public static int fireRange;
    public static int rateOfFire;

    public WeaponBuilder() {
    }

    public WeaponBuilder(String name, float caliber, int fireRange, int rateOfFire){
        this.name = name;
        this.caliber = caliber;
        this.fireRange = fireRange;
        this.rateOfFire = rateOfFire;
    }

    public static void setName(String name) {
        WeaponBuilder.name = name;
    }

    public static void setCaliber(float caliber) {
        WeaponBuilder.caliber = caliber;
    }

    public static void setFireRange(int fireRange) {
        WeaponBuilder.fireRange = fireRange;
    }

    public static void setRateOfFire(int rateOfFire) {
        WeaponBuilder.rateOfFire = rateOfFire;
    }
}
