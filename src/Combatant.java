public class Combatant {

    private int AC;
    private int hitPoints;
    private int numAttacks;
    private int toHit;
    private int addToDamage;
    private Dice damageDice;
    private Dice d20;

    Combatant(int AC, int hitPoints, int numAttacks, int toHit, int addToDamage, int damageDice) {
        this.AC = AC;
        this.hitPoints = hitPoints;
        this.numAttacks = numAttacks;
        this.toHit = toHit;
        this.addToDamage = addToDamage;
        this.damageDice = new Dice(damageDice);
        this.d20 = new Dice(20);
    }

    public void win() {
        System.out.println("They had " + hitPoints + " health left!");
    }

    public int getAC() {
        return AC;
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

    public int basicAttackDamage() {
        return damageDice.roll() + addToDamage;
    }

    public int basicAttackToHit() {
        return d20.roll() + toHit;
    }
}
