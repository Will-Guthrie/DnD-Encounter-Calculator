public class Combatant {

    private int AC;
    private int hitPoints;
    private int numAttacks;
    private int damageDice;
    private int toHit;
    private int addToDamage;

    Combatant(int AC, int hitPoints, int numAttacks, int damageDice, int toHit, int addToDamage) {
        this.AC = AC;
        this.hitPoints = hitPoints;
        this.numAttacks = numAttacks;
        this.damageDice = damageDice;
        this.toHit = toHit;
        this.addToDamage = addToDamage;
    }

    public void win() {
        System.out.println("They had " + hitPoints + " health left!");
    }

    public int getAC() {
        return AC;
    }

    public int getAddToDamage() {
        return addToDamage;
    }

    public int getDamageDice() {
        return damageDice;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public int getToHit() {
        return toHit;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
