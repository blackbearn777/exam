import java.util.Objects;

public class BulletproofVest {
    private ProtectionLevel protectionLevel;
    private Double weight;
    private OutcoverMaterial outcoverMaterial;
    private boolean isMolleSystem;
    private Double bulletproofArea;

    public BulletproofVest() {
    }

    public BulletproofVest(ProtectionLevel protectionLevel, Double weight, OutcoverMaterial outcoverMaterial, boolean isMolleSystem, Double bulletproofArea) {
        this.protectionLevel = protectionLevel;
        setWeight(weight);
        this.outcoverMaterial = outcoverMaterial;
        this.isMolleSystem = isMolleSystem;
        setBulletproofArea(bulletproofArea);
    }

    public ProtectionLevel getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(ProtectionLevel protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        if (weight < 2.1 || weight > 8.8)
            this.weight = 2.1;
        else
            this.weight = weight;
    }

    public OutcoverMaterial getOutcoverMaterial() {
        return outcoverMaterial;
    }

    public void setOutcoverMaterial(OutcoverMaterial outcoverMaterial) {
        this.outcoverMaterial = outcoverMaterial;
    }

    public boolean isMolleSystem() {
        return isMolleSystem;
    }

    public void setMolleSystem(boolean molleSystem) {
        isMolleSystem = molleSystem;
    }

    public Double getBulletproofArea() {
        return bulletproofArea;
    }

    public void setBulletproofArea(Double bulletproofArea) {
        if (bulletproofArea < 0.3 || bulletproofArea > 1.4)
            this.bulletproofArea = 0.3;
        else
            this.bulletproofArea = bulletproofArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BulletproofVest)) return false;
        BulletproofVest that = (BulletproofVest) o;
        return isMolleSystem() == that.isMolleSystem() &&
                getProtectionLevel() == that.getProtectionLevel() &&
                Objects.equals(getWeight(), that.getWeight()) &&
                getOutcoverMaterial() == that.getOutcoverMaterial() &&
                Objects.equals(getBulletproofArea(), that.getBulletproofArea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProtectionLevel(), getWeight(), getOutcoverMaterial(), isMolleSystem(), getBulletproofArea());
    }

    @Override
    public String toString() {
        return "BulletproofVest{" +
                "protectionLevel=" + protectionLevel +
                ", weight=" + weight +
                ", outcoverMaterial=" + outcoverMaterial +
                ", isMolleSystem=" + isMolleSystem +
                ", bulletproofArea=" + bulletproofArea +
                '}';
    }

    public boolean isLightWeight(){
        return weight<3.6?true:false;
    }
}
