package Warriors;
public abstract class Shield {
    protected int shieldPoints;

    public Shield(int shieldPoints) {
        this.shieldPoints = shieldPoints;
    }

    public int getSP() {
        return shieldPoints;
    }
    
    public void setSP(int shieldPoints) {
        this.shieldPoints = shieldPoints;
    }

    public void reduceShield(int damage) {
        shieldPoints -= damage;
        if (shieldPoints < 0) {
            shieldPoints = 0;
        }
    }

    public boolean isShieldExsists() {
        return shieldPoints > 0;
    }

    @Override
    public String toString() {
        return "Shield:" + shieldPoints;
    }

}
